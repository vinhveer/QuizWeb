package com.vinhveer.quizappbe.repository;

import com.vinhveer.quizappbe.entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizRepository extends MongoRepository<Quiz, String> {
    List<Quiz> findByCategoryId(String categoryId);
    List<Quiz> findByCreatedBy(String userId);
}
