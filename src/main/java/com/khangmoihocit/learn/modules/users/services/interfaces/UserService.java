package com.khangmoihocit.learn.modules.users.services.interfaces;

import com.khangmoihocit.learn.modules.users.dtos.LoginRequest;
import com.khangmoihocit.learn.modules.users.dtos.LoginResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
}
