package com.fitnexus.mapper;

import com.fitnexus.dto.response.UserResponse;
import com.fitnexus.model.User;

public class UserMapper {
    public static UserResponse mapToDto(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setCreatedAt(user.getCreatedAt());
        response.setModifiedAt(user.getModifiedAt());
        return response;
    }
}
