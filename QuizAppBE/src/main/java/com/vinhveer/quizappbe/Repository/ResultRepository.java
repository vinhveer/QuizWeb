package com.vinhveer.quizappbe.Repository;

import com.vinhveer.quizappbe.Entity.Result;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultRepository extends MongoRepository<Result, String>  {
}
