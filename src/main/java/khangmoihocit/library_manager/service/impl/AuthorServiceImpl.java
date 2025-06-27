package khangmoihocit.library_manager.service.impl;

import khangmoihocit.library_manager.dto.request.AuthorRequest;
import khangmoihocit.library_manager.dto.response.AuthorResponse;
import khangmoihocit.library_manager.entity.Author;
import khangmoihocit.library_manager.entity.Categories;
import khangmoihocit.library_manager.exception.AppException;
import khangmoihocit.library_manager.exception.ErrorCode;
import khangmoihocit.library_manager.mapper.AuthorMapper;
import khangmoihocit.library_manager.repository.AuthorRepository;
import khangmoihocit.library_manager.service.AuthorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository;
    AuthorMapper authorMapper;

    @Override
    public AuthorResponse addNewAuthor(AuthorRequest request) {
        Author author = authorMapper.toAuthor(request);
        author = authorRepository.save(author);
        return authorMapper.toAuthorResponse(author);
    }

    @Override
    public AuthorResponse updateAuthor(Long id, AuthorRequest request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.AUTHOR_NOT_EXISTED));
        authorMapper.updateAuthor(author, request);
        author = authorRepository.save(author);
        return authorMapper.toAuthorResponse(author);
    }

    @Override
    public AuthorResponse getAuthor(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.AUTHOR_NOT_EXISTED));
        return authorMapper.toAuthorResponse(author);
    }

    @Override
    public List<AuthorResponse> getAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toAuthorResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        Author author = authorRepository.findById(id)
                        .orElseThrow(()-> new AppException(ErrorCode.AUTHOR_NOT_EXISTED));
        authorRepository.deleteById(id);
    }
}
