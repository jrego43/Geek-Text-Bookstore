package com.geektext.bookstore.book;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b.* FROM book AS b INNER JOIN cart_item AS ci ON ci.profile_id = :profile_id AND b.book_id = ci.book_id", nativeQuery = true)
    List<Book> findBooksFromShoppingCart(@Param("profile_id") Long profile_id);
}
