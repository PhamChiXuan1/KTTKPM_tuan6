package com.example.restuser.controller;

import com.example.restuser.model.User;
import com.example.restuser.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
