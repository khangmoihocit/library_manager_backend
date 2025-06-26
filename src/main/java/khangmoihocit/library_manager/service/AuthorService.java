package khangmoihocit.library_manager.service;

import khangmoihocit.library_manager.dto.request.AuthorRequest;
import khangmoihocit.library_manager.dto.response.AuthorResponse;
import khangmoihocit.library_manager.entity.Author;

import java.util.List;

public interface AuthorService {
    AuthorResponse addNewAuthor(AuthorRequest request);
    AuthorResponse updateAuthor(Long id, AuthorRequest request);
    AuthorResponse getAuthor(Long id);
    List<AuthorResponse> getAuthors();
    void deleteById(Long id);
}
