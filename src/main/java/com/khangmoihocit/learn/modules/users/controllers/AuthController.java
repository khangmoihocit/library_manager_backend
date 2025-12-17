package com.khangmoihocit.learn.modules.users.controllers;

import com.khangmoihocit.learn.modules.users.dtos.LoginRequest;
import com.khangmoihocit.learn.modules.users.dtos.LoginResponse;
import com.khangmoihocit.learn.modules.users.services.interfaces.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/auth/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthController {
    UserService userService;

    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse auth = userService.login(loginRequest);
        return ResponseEntity.ok(auth);
    }
}
