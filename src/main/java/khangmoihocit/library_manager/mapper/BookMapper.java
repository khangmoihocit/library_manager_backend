package khangmoihocit.library_manager.mapper;

import khangmoihocit.library_manager.dto.request.BookRequest;
import khangmoihocit.library_manager.dto.response.BookResponse;
import khangmoihocit.library_manager.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target="authorName", ignore = true)
    @Mapping(target="categoriesName", ignore = true)
    BookResponse toBookResponse(Book book);

    Book toBook(BookRequest bookRequest);
}
