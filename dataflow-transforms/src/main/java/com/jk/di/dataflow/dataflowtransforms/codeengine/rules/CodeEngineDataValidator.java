package com.jk.di.dataflow.dataflowtransforms.codeengine.rules;

import com.jk.di.dataflow.dataflowtransforms.utils.CollectionUtils;
import com.jk.di.dataflow.dataflowtransforms.utils.JsonConvert;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author chao
 * @description
 * @create 2021-06-02 22:08
 */
public class CodeEngineDataValidator {

    public static void validate(JSONObject afterValue, JSONObject dataJson)
            throws IllegalArgumentException, JSONException {
        if (!Objects.equals(dataJson, afterValue)) {
            Map<String, Object> after = JsonConvert.toMap(afterValue);
            Map<String, Object> data = JsonConvert.toMap(dataJson);
            if (after.size() > data.size()) {
                throw new IllegalArgumentException(
                       /* DpErrorParser.VALIDATION_FAILED_MSG + */"Invalid data format. Cannot delete columns.");
            } else if (after.size() < data.size()) {
                throw new IllegalArgumentException(
                        /*DpErrorParser.VALIDATION_FAILED_MSG + */"Invalid data format. Cannot add columns");
            }
            if (CollectionUtils.isNotEmpty(
                    after.keySet().stream()
                            .filter(key -> !data.containsKey(key))
                            .collect(Collectors.toList()))) {
                throw new IllegalArgumentException(
                       /* DpErrorParser.VALIDATION_FAILED_MSG +*/ "Invalid data format. Cannot modify column name");
            }
            List<String> modifiedTypeKeys =
                    after.keySet().stream()
                            .filter(
                                    key -> {
                                        Object value = after.get(key);
                                        if (Objects.isNull(value) || Objects.equals(value, JSONObject.NULL)) {
                                            return false;
                                        } else {
                                            return !value.getClass().isAssignableFrom(data.get(key).getClass());
                                        }
                                    })
                            .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(modifiedTypeKeys)) {
                StringBuilder errorMsg = new StringBuilder(1000);
                modifiedTypeKeys.stream()
                        .forEach(
                                key -> {
                                    errorMsg
                                            .append("The expected type of column \"")
                                            .append(key)
                                            .append(" \"is \"")
                                            .append(after.get(key).getClass().getName())
                                            .append("\", but actually it is \"")
                                            .append(data.get(key).getClass().getName())
                                            .append("\".");
                                });
                throw new IllegalArgumentException(
                       /* DpErrorParser.VALIDATION_FAILED_MSG +*/ "Invalid data format." + errorMsg.toString());
            }
        }
    }
}