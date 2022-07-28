package com.geektext.bookstore.rating;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query(value = "SELECT * FROM rating WHERE book_id = :book_id AND num_stars IS NOT NULL", nativeQuery = true)
    List<Rating> findSortedRatingsByBookId(@Param("book_id") Long book_id);
}
