package khangmoihocit.library_manager.controller;

import khangmoihocit.library_manager.dto.request.ApiResponse;
import khangmoihocit.library_manager.dto.request.AuthorRequest;
import khangmoihocit.library_manager.dto.response.AuthorResponse;
import khangmoihocit.library_manager.service.AuthorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add-new")
    public ApiResponse<AuthorResponse> addNewAuthor(@RequestBody AuthorRequest request) {
        return ApiResponse.<AuthorResponse>builder()
                .result(authorService.addNewAuthor(request))
                .build();
    }

    @PutMapping("/update/{id}")
    public ApiResponse<AuthorResponse> updateAuthor(@PathVariable Long id, @RequestBody AuthorRequest request) {
        return ApiResponse.<AuthorResponse>builder()
                .result(authorService.updateAuthor(id, request))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<AuthorResponse> getAuthor(@PathVariable Long id) {
        return ApiResponse.<AuthorResponse>builder()
                .result(authorService.getAuthor(id))
                .build();
    }

    @GetMapping("/get-all")
    public ApiResponse<List<AuthorResponse>> getAllAuthors() {
        return ApiResponse.<List<AuthorResponse>>builder()
                .result(authorService.getAuthors())
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        authorService.deleteById(id);
        return ApiResponse.<Void>builder()
                .message("tác giả đã được xóa")
                .build();
    }
}
