package com.vinhveer.quizappbe.repository;

import com.vinhveer.quizappbe.entity.Result;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultRepository extends MongoRepository<Result, String>  {
}
