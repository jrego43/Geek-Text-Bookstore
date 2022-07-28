package com.geektext.bookstore.book;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b.* FROM book AS b INNER JOIN list_item AS li ON li.wishlist_id = :wishlist_id AND li.profile_id = :profile_id AND b.book_id = li.book_id", nativeQuery = true)
    List<Book> findBooksFromWishlist(@Param("wishlist_id") Long wishlist_id, @Param("profile_id") Long profile_id);
}
