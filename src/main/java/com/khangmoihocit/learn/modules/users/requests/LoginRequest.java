package com.khangmoihocit.learn.modules.users.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {

    @Email(message = "email không đúng định dạng")
    @NotBlank(message = "email không được để trống")
    String email;

    @NotBlank(message = "mật khẩu không được để trống")
    String password;
}
