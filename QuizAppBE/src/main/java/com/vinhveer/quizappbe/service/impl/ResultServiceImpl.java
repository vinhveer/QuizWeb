package com.vinhveer.quizappbe.service.impl;

import com.vinhveer.quizappbe.entity.Result;
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
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @Override
    public Optional<Result> getResultById(String id) {
        return resultRepository.findById(id);
    }

    @Override
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public void deleteResult(String id) {
        resultRepository.deleteById(id);
    }
}
