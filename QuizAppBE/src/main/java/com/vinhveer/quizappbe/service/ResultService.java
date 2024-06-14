package com.vinhveer.quizappbe.service;

import com.vinhveer.quizappbe.entity.Result;
import com.vinhveer.quizappbe.payload.BodyResponse;

import java.util.List;

public interface ResultService {
    BodyResponse<List<Result>> getAllResults();
    BodyResponse<Result> getResultById(String id);
    BodyResponse<Result> saveResult(Result result);
    BodyResponse<Void> deleteResult(String id);
}
