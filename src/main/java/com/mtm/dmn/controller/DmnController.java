package com.mtm.dmn.controller;

import com.mtm.dmn.model.DmnDecision;
import com.mtm.dmn.model.DmnResult;
import com.mtm.dmn.service.DmnService;
import org.camunda.bpm.model.dmn.DmnModelInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dmn")
@CrossOrigin(origins = "*")
public class DmnController {

    @Autowired
    private DmnService dmnService;

    // Simple in-memory cache for demo purposes
    private final Map<String, DmnDecision> decisionCache = new HashMap<>();
    private final Map<String, DmnModelInstance> modelCache = new HashMap<>();

    @PostMapping("/upload")
    public ResponseEntity<?> uploadDmnFile(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "File is empty"));
            }

            if (!dmnService.isDmnFile(file)) {
                return ResponseEntity.badRequest().body(Map.of("error", "Invalid file type. Please upload a .dmn or .xml file"));
            }

            DmnDecision decision = dmnService.parseDmnFile(file);
            
            // Store decision and model separately in cache
            decisionCache.put(decision.getId(), decision);
            modelCache.put(decision.getId(), decision.getDmnModel());
            
            // Clear the model from the decision object to avoid serialization issues
            decision.setDmnModel(null);
            
            return ResponseEntity.ok(decision);

        } catch (IOException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Error reading file: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Error parsing DMN file: " + e.getMessage()));
        }
    }

    @PostMapping("/evaluate")
    public ResponseEntity<?> evaluateDecision(@RequestBody Map<String, Object> request) {
        try {
            String decisionId = (String) request.get("decisionId");
            @SuppressWarnings("unchecked")
            Map<String, Object> inputValues = (Map<String, Object>) request.get("inputs");

            // Get decision and model from cache
            DmnDecision decision = decisionCache.get(decisionId);
            DmnModelInstance model = modelCache.get(decisionId);
            
            if (decision == null || model == null) {
                return ResponseEntity.badRequest().body(Map.of("error", "Decision not found. Please upload the DMN file again."));
            }

            // Temporarily set the model back for evaluation
            decision.setDmnModel(model);
            
            DmnResult result = dmnService.evaluateDecision(decision, inputValues);
            
            // Clear the model again to avoid serialization issues
            decision.setDmnModel(null);
            
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Error evaluating decision: " + e.getMessage()));
        }
    }
}
