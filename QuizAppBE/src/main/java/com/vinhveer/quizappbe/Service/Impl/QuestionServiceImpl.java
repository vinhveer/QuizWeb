package com.vinhveer.quizappbe.Service.Impl;

import com.vinhveer.quizappbe.Entity.Question;
import com.vinhveer.quizappbe.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Override
    public List<Question> getAllQuestions() {
        return List.of();
    }

    @Override
    public Optional<Question> getQuestionById(String id) {
        return Optional.empty();
    }

    @Override
    public Question saveQuestion(Question question) {
        return null;
    }

    @Override
    public void deleteQuestion(String id) {

    }
}
