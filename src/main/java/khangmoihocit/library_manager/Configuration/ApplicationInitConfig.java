package khangmoihocit.library_manager.Configuration;


import khangmoihocit.library_manager.entity.Role;
import khangmoihocit.library_manager.entity.User;
import khangmoihocit.library_manager.enums.RoleEnum;
import khangmoihocit.library_manager.exception.AppException;
import khangmoihocit.library_manager.repository.RoleRepository;
import khangmoihocit.library_manager.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    //tự tạo tài khoản admin với quyền admin
    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            if (!roleRepository.existsById(RoleEnum.USER.name())) {
                roleRepository.save(Role.builder()
                        .name(RoleEnum.USER.name())
                        .description("user role")
                        .build());
            }

            if (userRepository.findByUsername("admin").isEmpty()) {
                Role role = roleRepository.findById(RoleEnum.ADMIN.name())
                        .orElseGet(() -> {
                            return Role.builder()
                                    .name(RoleEnum.ADMIN.name())
                                    .description("this is admin role")
                                    .build();
                        });
                role = roleRepository.save(role);
                var roles = new HashSet<Role>();
                roles.add(role);

                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .email("admin@gmail.com")
                        .roles(roles)
                        .build();
                userRepository.save(user);
            }
        };
    }
}



