package com.khangmoihocit.learn.modules.users.services.impl;

import com.khangmoihocit.learn.modules.users.entities.User;
import com.khangmoihocit.learn.modules.users.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long id = Long.valueOf(username);
        User user = userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("user not exist"));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }
}
