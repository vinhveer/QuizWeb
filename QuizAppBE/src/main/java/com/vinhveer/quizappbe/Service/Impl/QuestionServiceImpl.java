package com.vinhveer.quizappbe.Service.Impl;

import com.vinhveer.quizappbe.Entity.Question;
import com.vinhveer.quizappbe.Payload.BodyResponse;
import com.vinhveer.quizappbe.Repository.QuestionRepository;
import com.vinhveer.quizappbe.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public BodyResponse<List<Question>> getAllQuestions() {
        try {
            List<Question> questions = questionRepository.findAll();
            return new BodyResponse<>(true, "Questions retrieved successfully", questions);
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to retrieve questions: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Question> getQuestionById(String id) {
        try {
            Optional<Question> optionalQuestion = questionRepository.findById(id);
            if (optionalQuestion.isPresent()) {
                return new BodyResponse<>(true, "Question retrieved successfully", optionalQuestion.get());
            } else {
                return new BodyResponse<>(false, "Question not found", null);
            }
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to retrieve question: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Question> saveQuestion(Question question) {
        try {
            Question savedQuestion = questionRepository.save(question);
            return new BodyResponse<>(true, "Question saved successfully", savedQuestion);
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to save question: " + e.getMessage(), null);
        }
    }

    @Override
    public BodyResponse<Void> deleteQuestion(String id) {
        try {
            Optional<Question> optionalQuestion = questionRepository.findById(id);
            if (optionalQuestion.isPresent()) {
                questionRepository.deleteById(id);
                return new BodyResponse<>(true, "Question deleted successfully", null);
            } else {
                return new BodyResponse<>(false, "Question not found", null);
            }
        } catch (Exception e) {
            return new BodyResponse<>(false, "Failed to delete question: " + e.getMessage(), null);
        }
    }
}
