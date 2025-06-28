package khangmoihocit.library_manager.dto.response;

import jakarta.persistence.Column;
import khangmoihocit.library_manager.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String username;
    String password;
    String email;
    String fullName;
    LocalDateTime createdAt;
    Set<RoleResponse> roles;
}
