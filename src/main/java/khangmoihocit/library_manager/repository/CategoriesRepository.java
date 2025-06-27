package khangmoihocit.library_manager.repository;

import khangmoihocit.library_manager.entity.Author;
import khangmoihocit.library_manager.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    List<Categories> findAllByNameContaining(String name);
}
