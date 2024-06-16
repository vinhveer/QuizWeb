package com.vinhveer.quizappbe.Service;

import com.vinhveer.quizappbe.Entity.Question;
import com.vinhveer.quizappbe.Payload.BodyResponse;

import java.util.List;

public interface QuestionService {
    BodyResponse<List<Question>> getAllQuestions();
    BodyResponse<Question> getQuestionById(String id);
    BodyResponse<Question> saveQuestion(Question question);
    BodyResponse<Void> deleteQuestion(String id);
}
