package com.vinhveer.quizappbe.repository;

import com.vinhveer.quizappbe.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {
}
