package com.vinhveer.quizappbe.service;

import com.vinhveer.quizappbe.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> getAllQuestions();
    Optional<Question> getQuestionById(String id);
    Question saveQuestion(Question question);
    void deleteQuestion(String id);
}
