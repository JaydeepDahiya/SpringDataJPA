package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 6/12/21.
 */
/*
Note: Spring Data JPA discovers BookRepository because it extends JpaRepository and registers it as a repository bean
(assuming repository scanning is enabled, which Spring Boot configures automatically in the usual setup).
Adding @Repository is unnecessary.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
