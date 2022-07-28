package com.geektext.bookstore.book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface bookRepository extends JpaRepository<book,Long>{
    
    //search by genre_id
    @Query(value = "SELECT * FROM book WHERE genre_id = :genre_id", nativeQuery = true)
    List<book> findBooksByGenreId(@Param("genre_id") Long genre_id);

    //search by isbn
    @Query(value = "SELECT * FROM book WHERE isbn = :isbn LIMIT 1", nativeQuery = true)
    Optional<book> findBookByIsbn(String isbn);           
    
    //search by author
    @Query(value = "SELECT * FROM book WHERE author = :author", nativeQuery = true)
    List<book> findBooksByAuthor(@Param("author") String author);
}
    

