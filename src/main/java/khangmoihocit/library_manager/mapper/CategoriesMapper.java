package khangmoihocit.library_manager.mapper;

import khangmoihocit.library_manager.dto.request.CategoriesRequest;
import khangmoihocit.library_manager.entity.Categories;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriesMapper {

    Categories toCategories(CategoriesRequest request);
}
