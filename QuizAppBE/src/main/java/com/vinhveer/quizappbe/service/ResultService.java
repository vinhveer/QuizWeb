package com.vinhveer.quizappbe.service;

import com.vinhveer.quizappbe.entity.Result;

import java.util.List;
import java.util.Optional;

public interface ResultService {
    List<Result> getAllResults();
    Optional<Result> getResultById(String id);
    Result saveResult(Result result);
    void deleteResult(String id);
}
