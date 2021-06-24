package com.jk.di.dataflow.dataflowtransforms.codeengine.rules;

/**
 * @author chao
 * @description
 * @create 2021-06-02 22:11
 */

import com.jk.di.dataflow.dataflowtransforms.codeengine.CodeEngineException;
import org.apache.kafka.connect.data.Schema;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/** Transform column value. */
public class TransformValue implements CodeEngine {

    private static final Logger logger = LoggerFactory.getLogger(TransformValue.class);

    private enum Mode {
        VALUE_TRANSFORM,
        VALUE_REPLACE
    }

    private static final String REPLACES_STR_DELIMITER = ",(?=\\s*s\\|[^\\|]*\\|[^\\|]*\\|)";
    private static final Pattern REPLACE_STR_PATTERN =
            Pattern.compile("\\s*s\\|([^\\|]*)\\|([^\\|]*)\\|");
    private static final Pattern VALUE_TRANSFORM_PATTERN =
            Pattern.compile("([A-Za-z0-9_]+) *[+\\-*/] *([A-Za-z0-9_]+)");

    private Map<String, String> replacesMap = new HashMap<>();
    private Throwable SYNTAX_NOT_VALID;
    private String expression;
    private String columnName;
    private Mode mode;
    private ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

    public TransformValue(String columnName, String expr) {
        this.columnName = columnName;
        this.expression = expr;
        Matcher matcher = VALUE_TRANSFORM_PATTERN.matcher(expr);
        if (matcher.matches()) {
            mode = Mode.VALUE_TRANSFORM;
        } else {
            mode = Mode.VALUE_REPLACE;
            String[] replaceStrs = expr.split(REPLACES_STR_DELIMITER);
            for (String replaceStr : replaceStrs) {
                Matcher replaceMatcher = REPLACE_STR_PATTERN.matcher(replaceStr);
                if (replaceMatcher.find()) {
                    String oldStr = replaceMatcher.group(1);
                    String newStr = replaceMatcher.group(2);
                    if (isRegex(oldStr)) {
                        replacesMap.put(oldStr, newStr);
                    }
                } else {
                    SYNTAX_NOT_VALID =
                            new IllegalArgumentException("The rule format " + replaceStr + "is invalid.");
                }
            }
        }
    }

    @Override
    public JSONObject process(JSONObject record, Schema schema) throws CodeEngineException {
        if (record == null) {
            return null;
        }
        if (mode == Mode.VALUE_TRANSFORM) {
            return valueTransform(record, schema);
        } else {
            return valueReplace(record, schema);
        }
    }

    private JSONObject valueReplace(JSONObject record, Schema schema) throws CodeEngineException {
        if (SYNTAX_NOT_VALID != null) {
            throw new CodeEngineException(this, record, SYNTAX_NOT_VALID);
        }
        try {
            String result = record.getString(columnName);
            if (isNotBlank(result)) {
                for (Map.Entry<String, String> entry : replacesMap.entrySet()) {
                    result = result.replaceAll(entry.getKey(), entry.getValue());
                }
                return record.put(columnName, result);
            }
        } catch (Exception e) {
            throw new CodeEngineException(this, record, e);
        }
        return record;
    }

    private JSONObject valueTransform(JSONObject record, Schema schema) throws CodeEngineException {
        try {
            final Schema.Type columnType = schema.field(columnName).schema().type();
            String colValue = record.getString(columnName);
            if (isNotBlank(colValue)) {
                engine.eval(String.format("%s = %s", columnName, record.getString(columnName)));
                final Double evalResult = ((Double) engine.eval(expression));
                final Object result;
                if (columnType == Schema.Type.INT8
                        || columnType == Schema.Type.INT16
                        || columnType == Schema.Type.INT32) {
                    result = evalResult.intValue();
                } else if (columnType == Schema.Type.INT64) {
                    result = evalResult.longValue();
                } else {
                    result = evalResult;
                }
                record.put(columnName, result);
            }
        } catch (Exception e) {
            throw new CodeEngineException(this, e);
        }
        return record;
    }

    @Override
    public String toString() {
        return "TransformValue:[" + columnName + " : " + expression + "]";
    }

    private boolean isRegex(String regexStr) {
        try {
            Pattern.compile(regexStr);
            return true;
        } catch (PatternSyntaxException e) {
            logger.error(e.getMessage(), e);
            SYNTAX_NOT_VALID = e;
        }
        return false;
    }
}
