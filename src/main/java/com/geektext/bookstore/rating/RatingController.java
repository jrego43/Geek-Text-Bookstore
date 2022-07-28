package com.geektext.bookstore.rating;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "api/rating")
public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Rating> getAllRatings() {
        System.out.println("Getting all ratings...");
        return ratingRepository.findAll();
    }
    
    @GetMapping(path="/{rating_id}")
    public @ResponseBody Optional<Rating> getRatingById(@PathVariable Long rating_id) {
        return ratingRepository.findById(rating_id);
    }
    
    @GetMapping(path="/book/{book_id}")
    public @ResponseBody List<Rating> getSortedRatingsByBookId(@PathVariable Long book_id) {
        return ratingRepository.findSortedRatingsByBookId(book_id);
    }
    
    @GetMapping(path="/book/{book_id}/average")
    public @ResponseBody Double getAverageRatingByBookId(@PathVariable Long book_id) {
        List<Rating> ratings = ratingRepository.findSortedRatingsByBookId(book_id);
        
        return getAverageRatingFromRatingList(ratings);
    }
    
    @PostMapping
    public @ResponseBody Rating addRating(@RequestBody Rating rating) {
        try {
            if(rating.getRating_id() == null || 
               rating.getProfile_id() == null || 
               rating.getBook_id() == null ||  
               rating.getDatestamp() == null) {
                throw new IllegalArgumentException("One or more required fields are null... Try again!");
            }
            else {
                if(rating.getNum_stars() != null) {
                    if(rating.getNum_stars() < 1 || rating.getNum_stars() > 5) {
                        System.out.println("num_stars must be between 1 and 5.");
                        return null;
                    }
                }
                else if(rating.getNum_stars() == null && rating.getComment() == null) {
                    System.out.println("num_stars and comment cannot both be null.");
                    return null;
                }
                
                return ratingRepository.saveAndFlush(rating);
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    // helper method
    public static Double getAverageRatingFromRatingList(List<Rating> ratings) {
        if(ratings.isEmpty()) {
            return -1.0;
        }
        
        Double average = 0.0;
        for(Rating r : ratings) {
            average += r.getNum_stars();
        }
        
        average /= ratings.size();
        
        BigDecimal bd = new BigDecimal(average).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
