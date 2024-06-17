package com.vinhveer.quizapp.Repository;

import com.vinhveer.quizapp.Entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findByQuizId(String quizId);
}
