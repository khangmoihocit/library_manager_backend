package khangmoihocit.library_manager.service.impl;

import khangmoihocit.library_manager.dto.request.CategoriesRequest;
import khangmoihocit.library_manager.dto.response.CategoriesResponse;
import khangmoihocit.library_manager.entity.Categories;
import khangmoihocit.library_manager.exception.AppException;
import khangmoihocit.library_manager.exception.ErrorCode;
import khangmoihocit.library_manager.mapper.CategoriesMapper;
import khangmoihocit.library_manager.repository.CategoriesRepository;
import khangmoihocit.library_manager.service.CategoriesService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoriesServiceImpl implements CategoriesService {
    CategoriesRepository categoriesRepository;
    CategoriesMapper categoriesMapper;

    @Override
    public CategoriesResponse addNewCategory(CategoriesRequest request) {
        Categories categories = categoriesMapper.toCategories(request);
        categories = categoriesRepository.save(categories);

        return categoriesMapper.toCategoriesResponse(categories);
    }

    @Override
    public CategoriesResponse updateCategory(Long id, CategoriesRequest request) {
        Categories categories = categoriesRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        categoriesMapper.updateCategories(categories, request);
        categories = categoriesRepository.save(categories);

        return categoriesMapper.toCategoriesResponse(categories);
    }

    @Override
    public CategoriesResponse getCategory(Long id) {
        return categoriesMapper.toCategoriesResponse(
                categoriesRepository.findById(id)
                        .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED)));
    }

    @Override
    public List<CategoriesResponse> getCategories() {
        List<Categories> categoriesList = categoriesRepository.findAll();
        if (categoriesList.isEmpty()) throw new AppException(ErrorCode.CATEGORIES_EMPTY);

        return categoriesList.stream().map(categoriesMapper::toCategoriesResponse).toList();
    }

    @Override
    public List<CategoriesResponse> findAllByName(String name) {
        List<Categories> categoriesList = categoriesRepository.findAllByNameContaining(name);
        if (categoriesList.isEmpty()) throw new AppException(ErrorCode.CATEGORIES_EMPTY);

        return categoriesList.stream().map(categoriesMapper::toCategoriesResponse).toList();
    }

    @Override
    public void deleteById(Long id) {
        Categories categories = categoriesRepository.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        categoriesRepository.deleteById(id);
    }
}
