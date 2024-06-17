package com.vinhveer.quizapp.Repository;

import com.vinhveer.quizapp.Entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
    List<Quiz> findByCategoryId(String categoryId);
    List<Quiz> findByCreatedBy(String userId);
}
