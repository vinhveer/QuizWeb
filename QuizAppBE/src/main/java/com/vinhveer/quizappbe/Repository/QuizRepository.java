package com.vinhveer.quizappbe.Repository;

import com.vinhveer.quizappbe.Entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizRepository extends MongoRepository<Quiz, String> {
    List<Quiz> findByCategoryId(String categoryId);
    List<Quiz> findByCreatedBy(String userId);
}
