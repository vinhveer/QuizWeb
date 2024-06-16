package com.vinhveer.quizappbe.Controller;

import com.vinhveer.quizappbe.Entity.Quiz;
import com.vinhveer.quizappbe.Payload.BodyResponse;
import com.vinhveer.quizappbe.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public ResponseEntity<BodyResponse<List<Quiz>>> getAllQuizzes() {
        BodyResponse<List<Quiz>> response = quizService.getAllQuizzes();
        return ResponseEntity.status(response.isStatus() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodyResponse<Quiz>> getQuizById(@PathVariable String id) {
        BodyResponse<Quiz> response = quizService.getQuizById(id);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping
    public ResponseEntity<BodyResponse<Quiz>> createQuiz(@RequestBody Quiz quiz) {
        BodyResponse<Quiz> response = quizService.saveQuiz(quiz);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodyResponse<Quiz>> updateQuiz(@PathVariable String id, @RequestBody Quiz quizDetails) {
        BodyResponse<Quiz> existingQuizResponse = quizService.getQuizById(id);
        if (!existingQuizResponse.isStatus()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(existingQuizResponse);
        }

        quizDetails.setId(id);
        BodyResponse<Quiz> updatedQuizResponse = quizService.saveQuiz(quizDetails);
        return ResponseEntity.status(updatedQuizResponse.isStatus() ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(updatedQuizResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BodyResponse<Void>> deleteQuiz(@PathVariable String id) {
        BodyResponse<Void> response = quizService.deleteQuiz(id);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<BodyResponse<List<Quiz>>> getQuizzesByCategoryId(@PathVariable String categoryId) {
        BodyResponse<List<Quiz>> response = quizService.getQuizzesByCategoryId(categoryId);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<BodyResponse<List<Quiz>>> getQuizzesByUserId(@PathVariable String userId) {
        BodyResponse<List<Quiz>> response = quizService.getQuizzesByUserId(userId);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
