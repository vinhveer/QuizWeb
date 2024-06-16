package com.vinhveer.quizappbe.Controller;

import com.vinhveer.quizappbe.Entity.User;
import com.vinhveer.quizappbe.Payload.*;
import com.vinhveer.quizappbe.Repository.UserRepository;
import com.vinhveer.quizappbe.Service.CustomUserDetailsService;
import com.vinhveer.quizappbe.Util.JwtUtil;
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
    public ResponseEntity<BodyResponse<AuthenticationResponse>> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BodyResponse<>(false, "Incorrect username or password", null));
        }

        User user = userRepository.findByUsername(authenticationRequest.getUsername());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BodyResponse<>(false, "User not found", null));
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        AuthenticationResponse authResponse = new AuthenticationResponse(jwt, user.getId());
        return ResponseEntity.ok(new BodyResponse<>(true, "Authentication successful", authResponse));
    }

    @PostMapping("/register")
    public ResponseEntity<BodyResponse<String>> registerUser(@RequestBody RegisterRequest registerRequest) {
        if (userRepository.findByUsername(registerRequest.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BodyResponse<>(false, "Username is already taken!", null));
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
            return ResponseEntity.ok(new BodyResponse<>(true, "User registered successfully!", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BodyResponse<>(false, "An error occurred during registration", null));
        }
    }
}
