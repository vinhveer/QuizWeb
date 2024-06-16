package com.vinhveer.quizappbe.Service;

import com.vinhveer.quizappbe.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(String id);
    User saveUser(User user);
    void deleteUser(String id);
}
