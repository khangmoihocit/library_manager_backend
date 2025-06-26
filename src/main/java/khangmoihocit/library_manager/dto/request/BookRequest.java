package khangmoihocit.library_manager.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {
    Long id;
    String title;
    AuthorRequest author;
    CategoriesRequest categories;
    LocalDate publishedDate;
    String description;
    int quantity;
}
