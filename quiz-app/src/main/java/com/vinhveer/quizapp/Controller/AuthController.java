package com.vinhveer.quizapp.Controller;

import com.vinhveer.quizapp.Payload.Request.AuthRequest;
import com.vinhveer.quizapp.Payload.Request.UserRequest;
import com.vinhveer.quizapp.Payload.Response.AuthResponse;
import com.vinhveer.quizapp.Payload.Response.BodyResponse;
import com.vinhveer.quizapp.Payload.Response.UserResponse;
import com.vinhveer.quizapp.Service.Impl.UserServiceImpl;
import com.vinhveer.quizapp.Utils.JwtTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserServiceImpl userService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserServiceImpl userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<BodyResponse<AuthResponse>> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new BodyResponse<>("fail", "Incorrect username or password", null), HttpStatus.UNAUTHORIZED);
        }

        final UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        AuthResponse authResponse = new AuthResponse(jwt);
        return ResponseEntity.ok(new BodyResponse<>("success", "Login successful", authResponse));
    }

    @PostMapping("/register")
    public ResponseEntity<BodyResponse<UserResponse>> registerUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);
        return ResponseEntity.ok(new BodyResponse<>("success", "User registered successfully", userResponse));
    }

    @GetMapping("/existsByUsername/{username}")
    public ResponseEntity<BodyResponse<Boolean>> existsByUsername(@PathVariable String username) {
        boolean exists = userService.existsByUsername(username);
        BodyResponse<Boolean> response = new BodyResponse<>("success", exists ? "Username exists" : "Username does not exist", exists);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/existsByEmail/{email}")
    public ResponseEntity<BodyResponse<Boolean>> existsByEmail(@PathVariable String email) {
        boolean exists = userService.existsByEmail(email);
        BodyResponse<Boolean> response = new BodyResponse<>("success", exists ? "Email exists" : "Email does not exist", exists);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    public ResponseEntity<BodyResponse<UserResponse>> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserResponse userResponse = userService.getUserByUsername(username);
        return ResponseEntity.ok(new BodyResponse<>("success", "User details retrieved successfully", userResponse));
    }
}
