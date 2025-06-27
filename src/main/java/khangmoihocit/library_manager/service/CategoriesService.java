package khangmoihocit.library_manager.service;

import khangmoihocit.library_manager.dto.request.AuthorRequest;
import khangmoihocit.library_manager.dto.request.CategoriesRequest;
import khangmoihocit.library_manager.dto.response.AuthorResponse;
import khangmoihocit.library_manager.dto.response.CategoriesResponse;

import java.util.List;

public interface CategoriesService {
    CategoriesResponse addNewCategory(CategoriesRequest request);
    CategoriesResponse updateCategory(Long id, CategoriesRequest request);
    CategoriesResponse getCategory(Long id);
    List<CategoriesResponse> getCategories();
    List<CategoriesResponse> findAllByName(String name);
    void deleteById(Long id);

}
