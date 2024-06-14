package com.vinhveer.quizappbe.service.impl;

import com.vinhveer.quizappbe.entity.Result;
import com.vinhveer.quizappbe.payload.BodyResponse;
import com.vinhveer.quizappbe.repository.ResultRepository;
import com.vinhveer.quizappbe.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public BodyResponse<List<Result>> getAllResults() {
        try {
            List<Result> results = resultRepository.findAll();
            return new BodyResponse<>(true, "Results retrieved successfully", results);
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to retrieve results: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Result> getResultById(String id) {
        try {
            Optional<Result> optionalResult = resultRepository.findById(id);
            if (optionalResult.isPresent()) {
                return new BodyResponse<>(true, "Result retrieved successfully", optionalResult.get());
            } else {
                return new BodyResponse<>(false, "Result not found", null);
            }
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to retrieve result: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Result> saveResult(Result result) {
        try {
            Result savedResult = resultRepository.save(result);
            return new BodyResponse<>(true, "Result saved successfully", savedResult);
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to save result: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Void> deleteResult(String id) {
        try {
            Optional<Result> optionalResult = resultRepository.findById(id);
            if (optionalResult.isPresent()) {
                resultRepository.deleteById(id);
                return new BodyResponse<>(true, "Result deleted successfully", null);
            } else {
                return new BodyResponse<>(false, "Result not found", null);
            }
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to delete result: " + e.getMessage(), null);
        }
    }
}
