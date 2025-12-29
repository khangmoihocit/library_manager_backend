package com.khangmoihocit.learn.modules.users.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL) //nếu 1 thuôc tính là null sẽ không hiện khi trả về
public class UserResource {
    Long id;
    String email;
    String name;
    String phone;
}
