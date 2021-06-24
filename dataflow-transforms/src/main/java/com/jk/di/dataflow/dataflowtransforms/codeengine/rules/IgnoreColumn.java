package com.jk.di.dataflow.dataflowtransforms.codeengine.rules;

/**
 * @author chao
 * @description
 * @create 2021-06-02 22:10
 */

import com.jk.di.dataflow.dataflowtransforms.codeengine.CodeEngineException;
import org.apache.kafka.connect.data.Schema;
import org.codehaus.jettison.json.JSONObject;

/** A code engine ignores some columns of current processing table. */
public class IgnoreColumn implements CodeEngine {
    public String columnName;

    public IgnoreColumn(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public JSONObject process(JSONObject record, Schema schema) throws CodeEngineException {
        if (record != null) {
            // NOTE: checked with @shao 20160716, or would break schema evolution rule
            try {
                if (record.opt(columnName) != JSONObject.NULL) {
                    record.put(columnName, JSONObject.NULL);
                }
            } catch (Exception e) {
                throw new CodeEngineException(this, record, e);
            }
        }
        // record.remove(this.columnName);
        return record;
    }

    @Override
    public String toString() {
        return "IgnoreColumn:[" + columnName + "]";
    }
}
