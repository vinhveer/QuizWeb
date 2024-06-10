package com.vinhveer.quizappbe.controller;

import com.vinhveer.quizappbe.entity.Result;
import com.vinhveer.quizappbe.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable String id) {
        Optional<Result> result = resultService.getResultById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return resultService.saveResult(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> updateResult(@PathVariable String id, @RequestBody Result resultDetails) {
        Optional<Result> result = resultService.getResultById(id);
        if (result.isPresent()) {
            resultDetails.setId(id);
            return ResponseEntity.ok(resultService.saveResult(resultDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable String id) {
        resultService.deleteResult(id);
        return ResponseEntity.noContent().build();
    }
}
