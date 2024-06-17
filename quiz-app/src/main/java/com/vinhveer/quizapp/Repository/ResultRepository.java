package com.vinhveer.quizapp.Repository;

import com.vinhveer.quizapp.Entity.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends MongoRepository<Result, String> {
}
