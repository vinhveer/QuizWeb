package com.vinhveer.quizapp.Controller;

import com.vinhveer.quizapp.Payload.Request.UserRequest;
import com.vinhveer.quizapp.Payload.Response.BodyResponse;
import com.vinhveer.quizapp.Payload.Response.UserResponse;
import com.vinhveer.quizapp.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<BodyResponse<UserResponse>> createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);
        BodyResponse<UserResponse> response = new BodyResponse<>("success", "User created successfully", userResponse);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodyResponse<UserResponse>> getUserById(@PathVariable String id) {
        UserResponse userResponse = userService.getUserById(id);
        BodyResponse<UserResponse> response = new BodyResponse<>("success", "User retrieved successfully", userResponse);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<BodyResponse<List<UserResponse>>> getAllUsers() {
        List<UserResponse> userResponses = userService.getAllUsers();
        BodyResponse<List<UserResponse>> response = new BodyResponse<>("success", "Users retrieved successfully", userResponses);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodyResponse<UserResponse>> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.updateUser(id, userRequest);
        BodyResponse<UserResponse> response = new BodyResponse<>("success", "User updated successfully", userResponse);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BodyResponse<Void>> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        BodyResponse<Void> response = new BodyResponse<>("success", "User deleted successfully", null);
        return ResponseEntity.ok(response);
    }
}
