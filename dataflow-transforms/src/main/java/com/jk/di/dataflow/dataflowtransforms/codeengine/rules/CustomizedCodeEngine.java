package com.jk.di.dataflow.dataflowtransforms.codeengine.rules;

import com.jk.di.dataflow.dataflowtransforms.codeengine.CustomizedCodeEngineException;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;


/**
 * @author chao
 * @description
 * @create 2021-06-02 22:08
 */
public interface CustomizedCodeEngine {
    List<JSONObject> process(JSONObject data, Object dpRecordMeta)
            throws CustomizedCodeEngineException;

    interface ParameterConverter {
        Object convert(JSONObject data, Object dpRecordMeta);
    }
}

