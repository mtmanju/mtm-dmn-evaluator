package com.mtm.dmn.model;

import java.util.Map;

public class DmnResult {
    private String decisionId;
    private String decisionName;
    private boolean matched;
    private Map<String, Object> outputs;
    private String errorMessage;

    // Constructors
    public DmnResult() {}

    public DmnResult(String decisionId, String decisionName) {
        this.decisionId = decisionId;
        this.decisionName = decisionName;
    }

    // Getters and Setters
    public String getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(String decisionId) {
        this.decisionId = decisionId;
    }

    public String getDecisionName() {
        return decisionName;
    }

    public void setDecisionName(String decisionName) {
        this.decisionName = decisionName;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public Map<String, Object> getOutputs() {
        return outputs;
    }

    public void setOutputs(Map<String, Object> outputs) {
        this.outputs = outputs;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
