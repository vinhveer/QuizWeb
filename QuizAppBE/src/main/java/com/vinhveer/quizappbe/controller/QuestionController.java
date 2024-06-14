package com.vinhveer.quizappbe.controller;

import com.vinhveer.quizappbe.entity.Question;
import com.vinhveer.quizappbe.payload.BodyResponse;
import com.vinhveer.quizappbe.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<BodyResponse<List<Question>>> getAllQuestions() {
        BodyResponse<List<Question>> response = questionService.getAllQuestions();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodyResponse<Question>> getQuestionById(@PathVariable String id) {
        BodyResponse<Question> response = questionService.getQuestionById(id);
        if (response.isStatus()) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<BodyResponse<Question>> createQuestion(@RequestBody Question question) {
        BodyResponse<Question> response = questionService.saveQuestion(question);
        if (response.isStatus()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodyResponse<Question>> updateQuestion(@PathVariable String id, @RequestBody Question questionDetails) {
        BodyResponse<Question> existingQuestionResponse = questionService.getQuestionById(id);
        if (!existingQuestionResponse.isStatus()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(existingQuestionResponse);
        }

        questionDetails.setId(id);
        BodyResponse<Question> updatedQuestionResponse = questionService.saveQuestion(questionDetails);
        return ResponseEntity.status(HttpStatus.OK).body(updatedQuestionResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BodyResponse<Void>> deleteQuestion(@PathVariable String id) {
        BodyResponse<Void> response = questionService.deleteQuestion(id);
        if (response.isStatus()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
