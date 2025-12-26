package com.khangmoihocit.learn.modules.users.controllers;

import com.khangmoihocit.learn.Resources.SuccessResource;
import com.khangmoihocit.learn.modules.users.entities.User;
import com.khangmoihocit.learn.modules.users.repositories.UserRepository;
import com.khangmoihocit.learn.modules.users.resources.UserResource;
import com.sun.net.httpserver.Authenticator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {

    UserRepository userRepository;

    @GetMapping("/my-profile")
    ResponseEntity<?> me(){
        String email = "khang567.ht@gmail.com";
        User user = userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User không tồn tại"));
        UserResource userResource = UserResource.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();

        SuccessResource<UserResource> response = SuccessResource.<UserResource>builder()
                .message("SUCCESS")
                .data(userResource)
                .build();
        return ResponseEntity.ok(response);
    }
}
