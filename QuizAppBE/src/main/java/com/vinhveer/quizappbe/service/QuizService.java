package com.vinhveer.quizappbe.service;

import com.vinhveer.quizappbe.entity.Quiz;
import com.vinhveer.quizappbe.payload.BodyResponse;

import java.util.List;

public interface QuizService {

    BodyResponse<List<Quiz>> getAllQuizzes();

    BodyResponse<Quiz> getQuizById(String id);

    BodyResponse<Quiz> saveQuiz(Quiz quiz);

    BodyResponse<Void> deleteQuiz(String id);

    BodyResponse<List<Quiz>> getQuizzesByCategoryId(String categoryId);

    BodyResponse<List<Quiz>> getQuizzesByUserId(String userId);
}
