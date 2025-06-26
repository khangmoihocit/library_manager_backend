package khangmoihocit.library_manager.repository;


import khangmoihocit.library_manager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
