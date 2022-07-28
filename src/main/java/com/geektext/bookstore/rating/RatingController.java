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
