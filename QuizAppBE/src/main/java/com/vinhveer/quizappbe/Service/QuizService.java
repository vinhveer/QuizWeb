package com.vinhveer.quizappbe.Service;

import com.vinhveer.quizappbe.Entity.Quiz;
import com.vinhveer.quizappbe.Payload.BodyResponse;

import java.util.List;

public interface QuizService {

    BodyResponse<List<Quiz>> getAllQuizzes();

    BodyResponse<Quiz> getQuizById(String id);

    BodyResponse<Quiz> saveQuiz(Quiz quiz);

    BodyResponse<Void> deleteQuiz(String id);

    BodyResponse<List<Quiz>> getQuizzesByCategoryId(String categoryId);

    BodyResponse<List<Quiz>> getQuizzesByUserId(String userId);
}
