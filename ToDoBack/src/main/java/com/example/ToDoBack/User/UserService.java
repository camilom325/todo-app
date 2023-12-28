package com.example.ToDoBack.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDetailDTO getUser(String id) {

        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            return UserDetailDTO.builder()
                    .id(user.id)
                    .username(user.username)
                    .firstName(user.firstName)
                    .lastName(user.lastName)
                    .build();
        }
        return null;
    }

    @Transactional
    public Object updateUser(UserRequest userRequest) {
        User user = User.builder()
                .id(userRequest.id)
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.lastName)
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return new UserResponse("El usuario fue registrad");

    }

}
