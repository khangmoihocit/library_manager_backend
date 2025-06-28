package khangmoihocit.library_manager.service.impl;

import khangmoihocit.library_manager.dto.request.UserRequest;
import khangmoihocit.library_manager.dto.response.UserResponse;
import khangmoihocit.library_manager.entity.Role;
import khangmoihocit.library_manager.entity.User;
import khangmoihocit.library_manager.enums.RoleEnum;
import khangmoihocit.library_manager.exception.AppException;
import khangmoihocit.library_manager.enums.ErrorCode;
import khangmoihocit.library_manager.mapper.UserMapper;
import khangmoihocit.library_manager.repository.RoleRepository;
import khangmoihocit.library_manager.repository.UserRepository;
import khangmoihocit.library_manager.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserRequest request) {
        if(userRepository.existsByUsername(request.getUsername())) throw new AppException(ErrorCode.USERNAME_EXISTED);
        if (userRepository.existsByEmail(request.getEmail())) throw new AppException(ErrorCode.EMAIL_EXISTED);

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role role = roleRepository.findById(RoleEnum.USER.name())
                .orElseGet(()->{
                    Role newRole = new Role();
                    newRole.setName(RoleEnum.USER.name());
                    newRole.setDescription("this is user role");
                    return newRole;
                });
        role = roleRepository.save(role);
        user.setRoles(Set.of(role));

        user = userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        return null;
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()) throw new AppException(ErrorCode.USER_NOT_EXISTED);
        return users.stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public void deleteUser(Long id) {

    }
}
