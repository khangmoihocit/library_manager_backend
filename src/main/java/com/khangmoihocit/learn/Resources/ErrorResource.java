package com.khangmoihocit.learn.Resources;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResource {
    String message;
    Map<String, String> errors;
}
