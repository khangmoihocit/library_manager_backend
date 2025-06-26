package khangmoihocit.library_manager.mapper;

import khangmoihocit.library_manager.dto.request.AuthorRequest;
import khangmoihocit.library_manager.dto.request.CategoriesRequest;
import khangmoihocit.library_manager.dto.response.AuthorResponse;
import khangmoihocit.library_manager.entity.Author;
import khangmoihocit.library_manager.entity.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthor(AuthorRequest request);
    AuthorResponse toAuthorResponse(Author author);
    void updateAuthor(@MappingTarget Author author, AuthorRequest request);
}
