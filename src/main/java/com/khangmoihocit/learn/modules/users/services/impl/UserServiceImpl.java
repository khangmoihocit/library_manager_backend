package com.khangmoihocit.learn.modules.users.services.impl;

import com.khangmoihocit.learn.BaseService;
import com.khangmoihocit.learn.modules.users.requests.LoginRequest;
import com.khangmoihocit.learn.modules.users.resources.LoginResource;
import com.khangmoihocit.learn.modules.users.resources.UserResource;
import com.khangmoihocit.learn.modules.users.services.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Override
    public LoginResource login(LoginRequest loginRequest) {
        LoginResource loginResource = LoginResource.builder()
                .token("random_token")
                .user(UserResource.builder().id(1L).email(loginRequest.getEmail()).build())
                .build();
        return loginResource;
    }


}
