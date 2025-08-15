package com.fitnexus.service.impl;

import com.fitnexus.dto.response.UserResponse;
import com.fitnexus.dto.request.UserRequest;
import com.fitnexus.mapper.UserMapper;
import com.fitnexus.model.User;
import com.fitnexus.repository.UserRepository;
import com.fitnexus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse getUserDetailsById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found for UserId: " + userId));
        return UserMapper.mapToDto(user);
    }

    @Override
    public UserResponse resisterNewUser(UserRequest userRequest) {
        try {
            if (userRequest == null) {
                throw new IllegalAccessException("User request must not be null;");
            }
            if (userRepository.findByEmail(userRequest.getEmail())) {
                throw new RuntimeException("User with email " + userRequest.getEmail() + " already exists");
            }
            User user = new User();
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setPassword(userRequest.getPassword());
            user.setEmail(userRequest.getEmail());
            User resister = userRepository.save(user);
            return UserMapper.mapToDto(resister);
        } catch (Exception e) {
            throw new RuntimeException("Exception while registering new user: " + e.getMessage());
        }
    }

    @Override
    public boolean validateUserById(String userId) {
        return userRepository.existsById(userId);
    }

}
