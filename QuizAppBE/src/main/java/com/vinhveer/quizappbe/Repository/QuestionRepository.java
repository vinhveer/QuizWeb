package com.vinhveer.quizappbe.Repository;

import com.vinhveer.quizappbe.Entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {
}
