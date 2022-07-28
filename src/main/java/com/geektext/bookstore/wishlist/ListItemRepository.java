package com.geektext.bookstore.wishlist;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ListItemRepository extends JpaRepository<ListItem, Long> {
    @Query(value = "SELECT * FROM list_item WHERE wishlist_id = :wishlist_id AND profile_id = :profile_id", nativeQuery = true)
    List<ListItem> findListItemsByWishlistAndProfileId(@Param("wishlist_id") Long wishlist_id, @Param("profile_id") Long profile_id);
}
