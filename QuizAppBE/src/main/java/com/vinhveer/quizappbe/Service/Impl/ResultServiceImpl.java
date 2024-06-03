package com.vinhveer.quizappbe.Service.Impl;

import com.vinhveer.quizappbe.Service.ResultService;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService {
    @Override
    public List<Result> getAllResults() {
        return List.of();
    }

    @Override
    public Optional<Result> getResultById(String id) {
        return Optional.empty();
    }

    @Override
    public Result saveResult(Result result) {
        return null;
    }

    @Override
    public void deleteResult(String id) {

    }
}
