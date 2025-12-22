package com.khangmoihocit.learn.modules.users.services.impl;

import com.khangmoihocit.learn.services.BaseService;
import com.khangmoihocit.learn.modules.users.requests.LoginRequest;
import com.khangmoihocit.learn.modules.users.resources.LoginResource;
import com.khangmoihocit.learn.modules.users.resources.UserResource;
import com.khangmoihocit.learn.modules.users.services.interfaces.UserService;
import com.khangmoihocit.learn.services.JwtService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends BaseService implements UserService {

    JwtService jwtService;

    @Override
    public LoginResource authenticate(LoginRequest loginRequest) {
        LoginResource loginResource = LoginResource.builder()
                .token("random_token")
                .user(UserResource.builder().id(1L).email(loginRequest.getEmail()).build())
                .build();
        return loginResource;
    }


}
