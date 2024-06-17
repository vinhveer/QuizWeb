package com.vinhveer.quizapp.Service;

import com.vinhveer.quizapp.Payload.Request.UserRequest;
import com.vinhveer.quizapp.Payload.Response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    UserResponse getUserById(String id);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(String id, UserRequest userRequest);
    void deleteUser(String id);
}
