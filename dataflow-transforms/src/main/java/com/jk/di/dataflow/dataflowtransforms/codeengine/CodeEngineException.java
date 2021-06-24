package com.jk.di.dataflow.dataflowtransforms.codeengine;

import com.jk.di.dataflow.dataflowtransforms.codeengine.rules.CodeEngine;
import org.codehaus.jettison.json.JSONObject;


/**
 * @author chao
 * @description
 * @create 2021-06-02 22:06
 */
public class CodeEngineException extends Exception {
    public CodeEngineException(CodeEngine rule, Throwable t) {
        super("Rule: " + rule.toString() + " is not valid.", t);
    }

    public CodeEngineException(CodeEngine rule, JSONObject recordBody, Throwable t) {
        super(buildErrorMessage(rule, recordBody), t);
    }

    private static String buildErrorMessage(CodeEngine rule, JSONObject recordBody) {
        StringBuilder messageBuilder = new StringBuilder("Apply Rule: ");
        if (rule != null) {
            messageBuilder.append(rule.toString());
        }
        messageBuilder.append(" on record: ");
        if (recordBody != null) {
            messageBuilder.append(recordBody.toString());
        }
        return messageBuilder.append(" failed.").toString();
    }
}
