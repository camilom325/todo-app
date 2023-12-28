package com.example.ToDoBack.auth;

import org.springframework.stereotype.Service;

import com.example.ToDoBack.JWT.JwtService;
import com.example.ToDoBack.User.Role;
import com.example.ToDoBack.User.User;
import com.example.ToDoBack.User.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwsService;

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(Role.USER)
                .build();

        userRepository.insert(user);

        return AuthResponse.builder()
                .token(jwsService.getToken(user))
                .build();
    }

    public AuthResponse login(LoginRequest request) {
        return null;
    }

}
