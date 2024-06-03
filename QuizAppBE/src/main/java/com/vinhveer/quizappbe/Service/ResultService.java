package com.vinhveer.quizappbe.Service;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;

public interface ResultService {
    List<Result> getAllResults();
    Optional<Result> getResultById(String id);
    Result saveResult(Result result);
    void deleteResult(String id);
}
