package com.backend_xeercise.taskmanagementsystem.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_xeercise.taskmanagementsystem.datatransferopject.LoginRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Logic to authenticate the user
        if (authenticate(username, password)) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }

    private boolean authenticate(String username, String password) {
        // Replace this with your authentication logic
        return "username".equals(username) && "password".equals(password);
    }
}