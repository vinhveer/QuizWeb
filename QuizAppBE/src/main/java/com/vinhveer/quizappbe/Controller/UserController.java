package com.vinhveer.quizappbe.Controller;

import com.vinhveer.quizappbe.Entity.User;
import com.vinhveer.quizappbe.Payload.BodyResponse;
import com.vinhveer.quizappbe.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<BodyResponse<List<User>>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(new BodyResponse<>(true, "Users retrieved successfully", users));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BodyResponse<>(false, "Error fetching all users: " + e.getMessage(), null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodyResponse<User>> getUserById(@PathVariable String id) {
        try {
            Optional<User> user = userService.getUserById(id);
            return user.map(value -> ResponseEntity.ok(new BodyResponse<>(true, "User retrieved successfully", value)))
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(new BodyResponse<>(false, "User not found with ID: " + id, null)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BodyResponse<>(false, "Error fetching user by ID: " + id + ", " + e.getMessage(), null));
        }
    }

    @PostMapping
    public ResponseEntity<BodyResponse<User>> createUser(@RequestBody User user) {
        try {
            User savedUser = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new BodyResponse<>(true, "User created successfully", savedUser));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BodyResponse<>(false, "Error creating user: " + e.getMessage(), null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodyResponse<User>> updateUser(@PathVariable String id, @RequestBody User userDetails) {
        try {
            Optional<User> user = userService.getUserById(id);
            if (user.isPresent()) {
                userDetails.setId(id);
                User updatedUser = userService.saveUser(userDetails);
                return ResponseEntity.ok(new BodyResponse<>(true, "User updated successfully", updatedUser));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new BodyResponse<>(false, "User not found with ID: " + id, null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BodyResponse<>(false, "Error updating user: " + e.getMessage(), null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BodyResponse<Void>> deleteUser(@PathVariable String id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new BodyResponse<>(true, "User deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BodyResponse<>(false, "Error deleting user by ID: " + id + ", " + e.getMessage(), null));
        }
    }
}
