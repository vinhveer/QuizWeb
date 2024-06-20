package com.vinhveer.quizapp.Service;

import com.vinhveer.quizapp.Payload.Request.UserRequest;
import com.vinhveer.quizapp.Payload.Response.BodyResponse;
import com.vinhveer.quizapp.Payload.Response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    UserResponse getUserById(String id);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(String id, UserRequest userRequest);
    void deleteUser(String id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    void changePassword(String id, String oldPassword , String newPassword);
}
