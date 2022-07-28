package com.geektext.bookstore.book;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book WHERE genre_id = :genre_id", nativeQuery = true)
    List<Book> findBooksByGenreId(@Param("genre_id") Long genre_id);
    
    @Query(value = "SELECT * FROM book ORDER BY copies_sold DESC LIMIT 10", nativeQuery = true)
    List<Book> findTenBestSellingBooks();
    
    @Query(value = "SELECT DISTINCT b.* FROM book AS b INNER JOIN rating AS r ON b.book_id = r.book_id", nativeQuery = true)
    List<Book> findAllRatedBooks();
    
    @Query(value = "SELECT * FROM book LIMIT :page_size OFFSET :offset", nativeQuery = true)
    List<Book> findBooksByPage(@Param("page_size") int page_size, @Param("offset") int offset);
}
