package khangmoihocit.library_manager.controller;

import khangmoihocit.library_manager.dto.request.ApiResponse;
import khangmoihocit.library_manager.dto.request.CategoriesRequest;
import khangmoihocit.library_manager.dto.response.CategoriesResponse;
import khangmoihocit.library_manager.service.CategoriesService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoriesController {
    CategoriesService categoriesService;

    @PostMapping("/add-new")
    ApiResponse<CategoriesResponse> addNewCategory(@RequestBody CategoriesRequest request) {
        return ApiResponse.<CategoriesResponse>builder()
                .result(categoriesService.addNewCategory(request))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<CategoriesResponse> updateCategory(@PathVariable Long id, @RequestBody CategoriesRequest request) {
        return ApiResponse.<CategoriesResponse>builder()
                .result(categoriesService.updateCategory(id, request))
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<CategoriesResponse> getCategory(@PathVariable Long id) {
        return ApiResponse.<CategoriesResponse>builder()
                .result(categoriesService.getCategory(id))
                .build();
    }

    @GetMapping("/get-all")
    ApiResponse<List<CategoriesResponse>> getCategories() {
        return ApiResponse.<List<CategoriesResponse>>builder()
                .result(categoriesService.getCategories())
                .build();
    }

    @GetMapping("/find-all-by-name/{name}")
    ApiResponse<List<CategoriesResponse>> getCategories(@PathVariable String name) {
        return ApiResponse.<List<CategoriesResponse>>builder()
                .result(categoriesService.findAllByName(name))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> delete(@PathVariable Long id) {
        categoriesService.deleteById(id);
        return ApiResponse.<Void>builder()
                .message("thể loại sách đã được xóa")
                .build();
    }
}
