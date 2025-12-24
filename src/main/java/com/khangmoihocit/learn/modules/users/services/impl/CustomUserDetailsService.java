package com.khangmoihocit.learn.modules.users.services.impl;

import com.khangmoihocit.learn.modules.users.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
public class CustomUserDetailsService {
    private final UserRepository userRepository;

    
}
