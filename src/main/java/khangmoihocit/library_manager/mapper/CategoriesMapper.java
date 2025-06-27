package khangmoihocit.library_manager.mapper;

import khangmoihocit.library_manager.dto.request.CategoriesRequest;
import khangmoihocit.library_manager.dto.response.CategoriesResponse;
import khangmoihocit.library_manager.entity.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoriesMapper {

    @Mapping(target = "id", ignore = true)
    Categories toCategories(CategoriesRequest request);
    CategoriesResponse toCategoriesResponse(Categories categories);

    @Mapping(target = "id", ignore = true)
    void updateCategories(@MappingTarget Categories categories, CategoriesRequest request);
}
