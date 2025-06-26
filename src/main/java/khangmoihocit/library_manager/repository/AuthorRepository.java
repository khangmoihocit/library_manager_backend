package khangmoihocit.library_manager.repository;

import khangmoihocit.library_manager.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
