package com.khangmoihocit.learn.modules.users.services.impl;

import com.khangmoihocit.learn.BaseService;
import com.khangmoihocit.learn.modules.users.dtos.LoginRequest;
import com.khangmoihocit.learn.modules.users.dtos.LoginResponse;
import com.khangmoihocit.learn.modules.users.services.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }
}
