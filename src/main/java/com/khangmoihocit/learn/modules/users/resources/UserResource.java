package com.khangmoihocit.learn.modules.users.resources;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResource {
    Long id;
    String email;
    String name;
}
