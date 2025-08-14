package com.fitnexus.service;

import com.fitnexus.dto.response.UserResponse;
import com.fitnexus.dto.request.UserRequest;

public interface UserService {
    UserResponse getUserDetailsById(String userId);

    UserResponse resisterNewUser(UserRequest userRequest) throws IllegalAccessException;

    boolean validateUserById(String userId);
}
