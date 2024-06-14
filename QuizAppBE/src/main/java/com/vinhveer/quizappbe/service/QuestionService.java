package com.vinhveer.quizappbe.service;

import com.vinhveer.quizappbe.entity.Question;
import com.vinhveer.quizappbe.payload.BodyResponse;

import java.util.List;

public interface QuestionService {
    BodyResponse<List<Question>> getAllQuestions();
    BodyResponse<Question> getQuestionById(String id);
    BodyResponse<Question> saveQuestion(Question question);
    BodyResponse<Void> deleteQuestion(String id);
}
