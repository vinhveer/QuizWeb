package com.vinhveer.quizappbe.Service.Impl;

import com.vinhveer.quizappbe.Entity.User;
import com.vinhveer.quizappbe.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public Optional<User> getUserById(String id) {
        return Optional.empty();
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }
}
