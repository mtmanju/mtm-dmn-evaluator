package com.mtm.dmn.model;

public class DmnInput {
    private String id;
    private String label;
    private String expression;
    private String type;

    // Constructors
    public DmnInput() {}

    public DmnInput(String id, String label, String type) {
        this.id = id;
        this.label = label;
        this.type = type;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
