package com.jk.di.dataflow.dataflowtransforms.codeengine.rules;

import com.jk.di.dataflow.dataflowtransforms.codeengine.CodeEngineException;
import org.apache.kafka.connect.data.Schema;
import org.codehaus.jettison.json.JSONObject;

/**
 * @author chao
 * @description
 * @create 2021-06-02 22:06
 */
@FunctionalInterface
public interface CodeEngine {
    JSONObject process(JSONObject record, Schema schema) throws CodeEngineException;
}
