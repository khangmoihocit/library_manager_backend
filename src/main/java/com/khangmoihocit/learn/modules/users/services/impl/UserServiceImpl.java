package com.khangmoihocit.learn.modules.users.services.impl;

import com.khangmoihocit.learn.Resources.ErrorResource;
import com.khangmoihocit.learn.modules.users.entities.User;
import com.khangmoihocit.learn.modules.users.repositories.UserRepository;
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
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends BaseService implements UserService {

    UserRepository userRepository;
    JwtService jwtService;
    PasswordEncoder passwordEncoder;

    @Override
    public Object authenticate(LoginRequest loginRequest) {
        try {
            User user = userRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new BadRequestException("email hoặc mật khẩu không chính xác."));
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                throw new BadRequestException("email hoặc mật khẩu không chính xác.");
            }

            String token = jwtService.generateToken(user.getId(), user.getEmail());
            UserResource userResource = UserResource.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .name(user.getName())
                    .build();

            return LoginResource.builder()
                    .token(token)
                    .user(userResource)
                    .build();

        } catch (BadRequestException ex) {
            log.error("Lỗi xác thực: {}", ex.getMessage());

            Map<String, String> errors = new HashMap<>();
            errors.put("message", ex.getMessage());
            return ErrorResource.builder()
                    .message("có vấn đề xẩy ra trong quá trình xác thực")
                    .errors(errors)
                    .build();
        }
    }


}
