package com.vinhveer.quizappbe.repository;

import com.vinhveer.quizappbe.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>  {
    User findByUsername(String username);
}
