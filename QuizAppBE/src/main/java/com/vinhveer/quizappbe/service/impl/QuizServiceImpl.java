package com.vinhveer.quizappbe.service.impl;

import com.vinhveer.quizappbe.entity.Quiz;
import com.vinhveer.quizappbe.payload.BodyResponse;
import com.vinhveer.quizappbe.repository.QuizRepository;
import com.vinhveer.quizappbe.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public BodyResponse<List<Quiz>> getAllQuizzes() {
        try {
            List<Quiz> quizzes = quizRepository.findAll();
            return new BodyResponse<>(true, "Quizzes retrieved successfully", quizzes);
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to retrieve quizzes: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Quiz> getQuizById(String id) {
        try {
            Optional<Quiz> optionalQuiz = quizRepository.findById(id);
            if (optionalQuiz.isPresent()) {
                return new BodyResponse<>(true, "Quiz retrieved successfully", optionalQuiz.get());
            } else {
                return new BodyResponse<>(false, "Quiz not found", null);
            }
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to retrieve quiz: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Quiz> saveQuiz(Quiz quiz) {
        try {
            Quiz savedQuiz = quizRepository.save(quiz);
            return new BodyResponse<>(true, "Quiz saved successfully", savedQuiz);
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to save quiz: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Void> deleteQuiz(String id) {
        try {
            Optional<Quiz> optionalQuiz = quizRepository.findById(id);
            if (optionalQuiz.isPresent()) {
                quizRepository.deleteById(id);
                return new BodyResponse<>(true, "Quiz deleted successfully", null);
            } else {
                return new BodyResponse<>(false, "Quiz not found", null);
            }
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to delete quiz: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<List<Quiz>> getQuizzesByCategoryId(String categoryId) {
        try {
            List<Quiz> quizzes = quizRepository.findByCategoryId(categoryId);
            return new BodyResponse<>(true, "Quizzes retrieved successfully", quizzes);
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to retrieve quizzes: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<List<Quiz>> getQuizzesByUserId(String userId) {
        try {
            List<Quiz> quizzes = quizRepository.findByCreatedBy(userId);
            return new BodyResponse<>(true, "Quizzes retrieved successfully", quizzes);
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to retrieve quizzes: " + e.getMessage(), null);
        }
    }
}
