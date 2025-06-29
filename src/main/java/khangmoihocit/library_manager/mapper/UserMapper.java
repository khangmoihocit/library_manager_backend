package khangmoihocit.library_manager.mapper;

import khangmoihocit.library_manager.dto.request.UserRequest;
import khangmoihocit.library_manager.dto.response.UserResponse;
import khangmoihocit.library_manager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest request);
    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserRequest request);
}
