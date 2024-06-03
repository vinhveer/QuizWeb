package com.vinhveer.quizappbe.Repository;

import com.vinhveer.quizappbe.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>  {
}
