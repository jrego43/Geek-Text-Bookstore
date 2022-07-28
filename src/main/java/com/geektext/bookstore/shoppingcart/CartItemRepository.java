package com.geektext.bookstore.shoppingcart;

import com.geektext.bookstore.book.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query(value = "SELECT * FROM cart_item WHERE profile_id = :profile_id", nativeQuery = true)
    List<CartItem> findCartItemsByProfileId(@Param("profile_id") Long profile_id);
}
