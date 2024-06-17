package com.vinhveer.quizapp.Service.Impl;

import com.vinhveer.quizapp.Entity.User;
import com.vinhveer.quizapp.Exception.InvalidRequestException;
import com.vinhveer.quizapp.Exception.ResourceNotFoundException;
import com.vinhveer.quizapp.Payload.Request.UserRequest;
import com.vinhveer.quizapp.Payload.Response.UserResponse;
import com.vinhveer.quizapp.Repository.UserRepository;
import com.vinhveer.quizapp.Service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        if (!StringUtils.hasText(userRequest.getUsername()) || !StringUtils.hasText(userRequest.getEmail()) || !StringUtils.hasText(userRequest.getPassword())) {
            throw new InvalidRequestException("Username, email, and password are required");
        }

        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword())); // Mã hóa mật khẩu
        user.setAvatar(userRequest.getAvatar());
        user.setCreateAt(LocalDateTime.now().toString());
        user.setUpdateAt(LocalDateTime.now().toString());

        user = userRepository.save(user);

        return mapToResponse(user);
    }

    @Override
    public UserResponse getUserById(String id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            return mapToResponse(userOpt.get());
        }
        throw new ResourceNotFoundException("User not found with id: " + id);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse updateUser(String id, UserRequest userRequest) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (StringUtils.hasText(userRequest.getUsername())) {
                user.setUsername(userRequest.getUsername());
            }
            if (StringUtils.hasText(userRequest.getEmail())) {
                user.setEmail(userRequest.getEmail());
            }
            if (StringUtils.hasText(userRequest.getPassword())) {
                user.setPassword(passwordEncoder.encode(userRequest.getPassword())); // Mã hóa mật khẩu
            }
            if (StringUtils.hasText(userRequest.getAvatar())) {
                user.setAvatar(userRequest.getAvatar());
            }
            user.setUpdateAt(LocalDateTime.now().toString());

            user = userRepository.save(user);

            return mapToResponse(user);
        }
        throw new ResourceNotFoundException("User not found with id: " + id);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    private UserResponse mapToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setAvatar(user.getAvatar());
        userResponse.setCreateAt(user.getCreateAt());
        userResponse.setUpdateAt(user.getUpdateAt());
        return userResponse;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}
