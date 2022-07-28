package com.geektext.bookstore.book;

import com.geektext.bookstore.rating.Rating;
import com.geektext.bookstore.rating.RatingController;
import com.geektext.bookstore.rating.RatingRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "api/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RatingRepository ratingRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks() {
        System.out.println("Getting all books...");
        return bookRepository.findAll();
    }
    
    @GetMapping(path="/{book_id}")
    public @ResponseBody Optional<Book> getBookById(@PathVariable Long book_id) {
        return bookRepository.findById(book_id);
    }
    
    // FEATURE 1
    @GetMapping(path="/genre/{genre_id}")
    public @ResponseBody List<Book> getBooksByGenreId(@PathVariable Long genre_id) {
        return bookRepository.findBooksByGenreId(genre_id);
    }
    
    @GetMapping(path="/best-sellers")
    public @ResponseBody List<Book> getBestSellers() {
        return bookRepository.findTenBestSellingBooks();
    }
    
    @GetMapping(path="/rating-or-higher/{avg_rating}")
    public @ResponseBody List<Book> getBooksByAverageRatingOrHigher(@PathVariable Double avg_rating) {
        List<Book> books = bookRepository.findAllRatedBooks();
        List<Book> newBooks = new ArrayList<>();
        
        for(Book b : books) {
            Double this_rating = RatingController.getAverageRatingFromRatingList(ratingRepository.findSortedRatingsByBookId(b.getBook_id()));
            
            if(this_rating >= avg_rating) {
                newBooks.add(b);
            }
        }
        
        return newBooks;
    }
    
    @GetMapping(path="/page/{page_size}/{page}")
    public @ResponseBody List<Book> getBooksByPage(@PathVariable int page_size, @PathVariable int page) {
        return bookRepository.findBooksByPage(page_size, page * page_size);
    }
    
}
