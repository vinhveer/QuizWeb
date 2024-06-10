package com.vinhveer.quizappbe.service.impl;

import com.vinhveer.quizappbe.entity.Quiz;
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
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> getQuizById(String id) {
        return quizRepository.findById(id);
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void deleteQuiz(String id) {
        quizRepository.deleteById(id);
    }

    @Override
    public List<Quiz> getQuizzesByCategoryId(String categoryId) {
        return quizRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Quiz> getQuizzesByUserId(String userId) {
        return quizRepository.findByCreatedBy(userId);
    }
}
