package khangmoihocit.library_manager.dto.response;

import khangmoihocit.library_manager.entity.Author;
import khangmoihocit.library_manager.entity.Categories;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {
    Long id;
    String title;
    String authorName;
    String categoriesName;
    LocalDate publishedDate;
    String description;
    int quantity;
}
