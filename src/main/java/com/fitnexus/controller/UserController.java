package com.fitnexus.controller;

import com.fitnexus.dto.response.UserResponse;
import com.fitnexus.dto.request.UserRequest;
import com.fitnexus.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/getUserDetailsById/{userId}")
    public ResponseEntity<UserResponse> getUserDetailsById (@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUserDetailsById(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> resisterNewUser (@Valid @RequestBody UserRequest userRequest) throws IllegalAccessException {
        return ResponseEntity.ok(userService.resisterNewUser(userRequest));
    }

    @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> validateUser (@PathVariable String userId) {
        return ResponseEntity.ok(userService.validateUserById(userId));
    }

}
