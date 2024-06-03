package com.vinhveer.quizappbe.Service.Impl;

import com.vinhveer.quizappbe.Entity.Quiz;
import com.vinhveer.quizappbe.Service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {
    @Override
    public List<Quiz> getAllQuizzes() {
        return List.of();
    }

    @Override
    public Optional<Quiz> getQuizById(String id) {
        return Optional.empty();
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return null;
    }

    @Override
    public void deleteQuiz(String id) {

    }
}
