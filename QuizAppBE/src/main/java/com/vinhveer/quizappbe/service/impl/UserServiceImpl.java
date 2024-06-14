package com.vinhveer.quizappbe.service.impl;

import com.vinhveer.quizappbe.entity.User;
import com.vinhveer.quizappbe.repository.UserRepository;
import com.vinhveer.quizappbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching all users", e);
        }
    }

    @Override
    public Optional<User> getUserById(String id) {
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching user by ID: " + id, e);
        }
    }

    @Override
    public User saveUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error saving user", e);
        }
    }

    @Override
    public void deleteUser(String id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user by ID: " + id, e);
        }
    }
}
