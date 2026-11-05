package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by jt on 7/3/21.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
// use @ComponentScan to scan particular packages and include the respective beans etc. In this case we include the
// DataInitializer class in the test context, so that it can populate the database with initial data for testing
@ComponentScan(basePackages = {"guru.springframework.sdjpaintro.bootstrap"})
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    // can be used to commit the transaction for a test method. It is better to use @Commit instead.
    //@Rollback(value = false)
    @Commit
    @Order(1)
    @Test
    void testJpaTestSplice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("My Book", "1235555", "Self"));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);

    }
}
