package com.vinhveer.quizappbe.controller;

import com.vinhveer.quizappbe.entity.Result;
import com.vinhveer.quizappbe.payload.BodyResponse;
import com.vinhveer.quizappbe.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping
    public ResponseEntity<BodyResponse<List<Result>>> getAllResults() {
        BodyResponse<List<Result>> response = resultService.getAllResults();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodyResponse<Result>> getResultById(@PathVariable String id) {
        BodyResponse<Result> response = resultService.getResultById(id);
        if (response.isStatus()) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<BodyResponse<Result>> createResult(@RequestBody Result result) {
        BodyResponse<Result> response = resultService.saveResult(result);
        if (response.isStatus()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodyResponse<Result>> updateResult(@PathVariable String id, @RequestBody Result resultDetails) {
        BodyResponse<Result> existingResultResponse = resultService.getResultById(id);
        if (!existingResultResponse.isStatus()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(existingResultResponse);
        }

        resultDetails.setId(id);
        BodyResponse<Result> updatedResultResponse = resultService.saveResult(resultDetails);
        return ResponseEntity.status(HttpStatus.OK).body(updatedResultResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BodyResponse<Void>> deleteResult(@PathVariable String id) {
        BodyResponse<Void> response = resultService.deleteResult(id);
        if (response.isStatus()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
