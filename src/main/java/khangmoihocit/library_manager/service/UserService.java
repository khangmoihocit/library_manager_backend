package khangmoihocit.library_manager.service;

import khangmoihocit.library_manager.dto.request.UserRequest;
import khangmoihocit.library_manager.dto.response.UserResponse;
import khangmoihocit.library_manager.entity.User;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);
    UserResponse updateUser(Long id, UserRequest request);
    UserResponse getUser(Long id);
    List<UserResponse> getUsers();
    void deleteUser(Long id);
}
