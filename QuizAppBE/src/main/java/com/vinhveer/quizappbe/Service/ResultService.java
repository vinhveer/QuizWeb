package com.vinhveer.quizappbe.Service;

import com.vinhveer.quizappbe.Entity.Result;
import com.vinhveer.quizappbe.Payload.BodyResponse;

import java.util.List;

public interface ResultService {
    BodyResponse<List<Result>> getAllResults();
    BodyResponse<Result> getResultById(String id);
    BodyResponse<Result> saveResult(Result result);
    BodyResponse<Void> deleteResult(String id);
}
