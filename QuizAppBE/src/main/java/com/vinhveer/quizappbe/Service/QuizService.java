package com.vinhveer.quizappbe.Service;

import com.vinhveer.quizappbe.Entity.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    List<Quiz> getAllQuizzes();
    Optional<Quiz> getQuizById(String id);
    Quiz saveQuiz(Quiz quiz);
    void deleteQuiz(String id);
}
