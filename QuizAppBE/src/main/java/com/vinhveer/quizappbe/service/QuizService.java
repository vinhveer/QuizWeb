package com.vinhveer.quizappbe.service;

import com.vinhveer.quizappbe.entity.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    List<Quiz> getAllQuizzes();
    Optional<Quiz> getQuizById(String id);
    List<Quiz> getQuizzesByCategoryId(String categoryId);
    List<Quiz> getQuizzesByUserId(String userId);
    Quiz saveQuiz(Quiz quiz);
    void deleteQuiz(String id);
}
