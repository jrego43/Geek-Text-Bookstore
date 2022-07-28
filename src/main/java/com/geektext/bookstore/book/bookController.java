package com.geektext.bookstore.book;

import java.lang.StackWalker.Option;
import java.text.BreakIterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/book")
public class bookController {
    private final bookService bService;

    @Autowired
    public bookController(bookService bService){
        this.bService = bService;
    }

    @Autowired
    private bookRepository bRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<book> getAllBooks() {
        System.out.println("Getting all books...");
        return bRepository.findAll();
    }

    @GetMapping(path="/{book_id}")
    public @ResponseBody Optional<book> getBookById(@PathVariable Long book_id){
        System.out.println("Getting book...");
        return bRepository.findById(book_id);
    }

    @GetMapping(path="/isbn/{isbn}")
    public @ResponseBody Optional<book> getBookByIsbn(@PathVariable String isbn){
        return bRepository.findBookByIsbn(isbn);
    }
    @GetMapping(path="/genre/{genre_id}")
        public @ResponseBody List<book> getBooksByGenreId(@PathVariable Long genre_id) {
            return bRepository.findBooksByGenreId(genre_id);
    }
    
    @GetMapping(path="/author/{author}")
    public @ResponseBody List<book> getBooksByAuthorId(@PathVariable String author) {
        return bRepository.findBooksByAuthor(author);
    }

    @DeleteMapping(path = "/{book_id}")
    public void deleteBook(@PathVariable("book_id") Long id){
        bService.deleteBook(id);
    }

    @GetMapping
    public List<book> getBooks(){
        return bService.getBooks();
    }

    @PostMapping
    public void registerNewBook(@RequestBody book booky){
        bService.addNewBook(booky);
    }

}
