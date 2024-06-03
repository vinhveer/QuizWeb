package com.vinhveer.quizappbe.Repository;

import com.vinhveer.quizappbe.Entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz, String> {
}
