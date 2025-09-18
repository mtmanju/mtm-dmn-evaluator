package com.mtm.dmn.service;

import com.mtm.dmn.model.DmnDecision;
import com.mtm.dmn.model.DmnInput;
import com.mtm.dmn.model.DmnOutput;
import com.mtm.dmn.model.DmnResult;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.bpm.model.dmn.Dmn;
import org.camunda.bpm.model.dmn.DmnModelInstance;
import org.camunda.bpm.model.dmn.instance.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DmnService {

    private final DmnEngine dmnEngine;

    public DmnService() {
        this.dmnEngine = DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine();
    }

    public DmnDecision parseDmnFile(MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            DmnModelInstance dmnModel = Dmn.readModelFromStream(inputStream);
            return extractDecisionInfo(dmnModel);
        } catch (Exception e) {
            throw new IOException("Error parsing DMN file: " + e.getMessage(), e);
        }
    }

    private DmnDecision extractDecisionInfo(DmnModelInstance dmnModel) {
        DmnDecision decision = new DmnDecision();
        
        // Get the first decision (not decision table)
        Decision dmnDecision = dmnModel.getModelElementsByType(Decision.class)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No decision found in DMN file"));

        decision.setId(dmnDecision.getId());
        decision.setName(dmnDecision.getName());
        
        // Get the decision table from the model (since getDecisionTable() method doesn't exist)
        DecisionTable decisionTable = dmnModel.getModelElementsByType(DecisionTable.class)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No decision table found in DMN file"));

        // Extract input definitions
        java.util.List<DmnInput> inputs = decisionTable.getInputs().stream()
                .map(this::mapToDmnInput)
                .collect(Collectors.toList());
        decision.setInputs(inputs);

        // Extract output definitions
        java.util.List<DmnOutput> outputs = decisionTable.getOutputs().stream()
                .map(this::mapToDmnOutput)
                .collect(Collectors.toList());
        decision.setOutputs(outputs);

        // Store the model instance for evaluation
        decision.setDmnModel(dmnModel);

        return decision;
    }

    private DmnInput mapToDmnInput(Input input) {
        DmnInput dmnInput = new DmnInput();
        dmnInput.setId(input.getId());
        dmnInput.setLabel(input.getLabel());
        
        // Get input expression
        InputExpression inputExpression = input.getInputExpression();
        if (inputExpression != null) {
            dmnInput.setExpression(inputExpression.getTextContent());
            dmnInput.setType(inputExpression.getTypeRef());
        }
        
        return dmnInput;
    }

    private DmnOutput mapToDmnOutput(Output output) {
        DmnOutput dmnOutput = new DmnOutput();
        dmnOutput.setId(output.getId());
        dmnOutput.setName(output.getName());
        dmnOutput.setLabel(output.getLabel());
        dmnOutput.setType(output.getTypeRef());
        return dmnOutput;
    }

    public DmnResult evaluateDecision(DmnDecision decision, Map<String, Object> inputValues) {
        try {
            DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(
                    decision.getId(), 
                    decision.getDmnModel(), 
                    inputValues
            );

            DmnResult dmnResult = new DmnResult();
            dmnResult.setDecisionId(decision.getId());
            dmnResult.setDecisionName(decision.getName());
            
            if (!result.isEmpty()) {
                // Get the first matching rule result
                Map<String, Object> resultMap = result.getSingleResult().getEntryMap();
                dmnResult.setOutputs(resultMap);
                dmnResult.setMatched(true);
            } else {
                dmnResult.setMatched(false);
                dmnResult.setOutputs(new HashMap<>());
            }

            return dmnResult;
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating DMN decision: " + e.getMessage(), e);
        }
    }

    public boolean isDmnFile(MultipartFile file) {
        String filename = file.getOriginalFilename();
        return filename != null && (filename.endsWith(".dmn") || filename.endsWith(".xml"));
    }
}
