package com.vinhveer.quizappbe.controller;

import com.vinhveer.quizappbe.entity.User;
import com.vinhveer.quizappbe.model.AuthenticationRequest;
import com.vinhveer.quizappbe.model.AuthenticationResponse;
import com.vinhveer.quizappbe.model.ErrorResponse;
import com.vinhveer.quizappbe.model.RegisterRequest;
import com.vinhveer.quizappbe.repository.UserRepository;
import com.vinhveer.quizappbe.service.CustomUserDetailsService;
import com.vinhveer.quizappbe.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            ErrorResponse errorResponse = new ErrorResponse("Incorrect username or password", HttpStatus.UNAUTHORIZED.value());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }

        User user = userRepository.findByUsername(authenticationRequest.getUsername());
        if (user == null) {
            ErrorResponse errorResponse = new ErrorResponse("User not found", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwt, user.getId()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        if (userRepository.findByUsername(registerRequest.getUsername()) != null) {
            ErrorResponse errorResponse = new ErrorResponse("Username is already taken!", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        try {
            String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
            User newUser = new User();
            newUser.setUsername(registerRequest.getUsername());
            newUser.setEmail(registerRequest.getEmail());
            newUser.setPassword(encodedPassword);
            newUser.setCreateAt(java.time.LocalDateTime.now().toString());
            newUser.setUpdateAt(java.time.LocalDateTime.now().toString());
            newUser.setAvatar(registerRequest.getAvatar());

            userRepository.save(newUser);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("An error occurred during registration", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
