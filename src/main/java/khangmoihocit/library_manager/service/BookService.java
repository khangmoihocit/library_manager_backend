package khangmoihocit.library_manager.service;

import khangmoihocit.library_manager.dto.request.BookRequest;
import khangmoihocit.library_manager.dto.response.BookResponse;

public interface BookService {
    BookResponse addNewBook(BookRequest request);
    BookResponse getBook(Long id);
    BookResponse getAllBooks();
    BookResponse updateBook(Long id);
    void deleteById(Long id);
}
