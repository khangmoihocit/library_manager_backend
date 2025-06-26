package khangmoihocit.library_manager.service.impl;

import khangmoihocit.library_manager.dto.request.BookRequest;
import khangmoihocit.library_manager.dto.response.BookResponse;
import khangmoihocit.library_manager.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public BookResponse addNewBook(BookRequest request) {
        return null;
    }

    @Override
    public BookResponse getBook(Long id) {
        return null;
    }

    @Override
    public BookResponse getAllBooks() {
        return null;
    }

    @Override
    public BookResponse updateBook(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
