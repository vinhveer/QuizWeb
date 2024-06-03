package com.vinhveer.quizappbe.Service;

import com.vinhveer.quizappbe.Entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> getAllQuestions();
    Optional<Question> getQuestionById(String id);
    Question saveQuestion(Question question);
    void deleteQuestion(String id);
}
