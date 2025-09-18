package com.mtm.dmn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.camunda.bpm.model.dmn.DmnModelInstance;

import java.util.List;

public class DmnDecision {
    private String id;
    private String name;
    private List<DmnInput> inputs;
    private List<DmnOutput> outputs;
    
    @JsonIgnore
    private DmnModelInstance dmnModel;

    // Constructors
    public DmnDecision() {}

    public DmnDecision(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DmnInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<DmnInput> inputs) {
        this.inputs = inputs;
    }

    public List<DmnOutput> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<DmnOutput> outputs) {
        this.outputs = outputs;
    }

    public DmnModelInstance getDmnModel() {
        return dmnModel;
    }

    public void setDmnModel(DmnModelInstance dmnModel) {
        this.dmnModel = dmnModel;
    }
}
