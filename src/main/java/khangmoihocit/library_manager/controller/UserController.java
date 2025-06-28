package khangmoihocit.library_manager.controller;

import khangmoihocit.library_manager.dto.request.ApiResponse;
import khangmoihocit.library_manager.dto.request.UserRequest;
import khangmoihocit.library_manager.dto.response.UserResponse;
import khangmoihocit.library_manager.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping("register")
    public ApiResponse<UserResponse> createUser(@RequestBody UserRequest userRequest){
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(userRequest))
                .build();
    }


}
