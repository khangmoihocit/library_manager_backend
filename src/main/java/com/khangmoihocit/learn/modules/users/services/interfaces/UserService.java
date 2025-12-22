package com.khangmoihocit.learn.modules.users.services.interfaces;

import com.khangmoihocit.learn.modules.users.requests.LoginRequest;
import com.khangmoihocit.learn.modules.users.resources.LoginResource;

public interface UserService {
    Object authenticate(LoginRequest loginRequest);
}
