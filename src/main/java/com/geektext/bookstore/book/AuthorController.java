package com.geektext.bookstore.book;

import java.lang.StackWalker.Option;
import java.text.BreakIterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @Autowired
    public AuthorRepository authorRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping(path="/{author_id}")
    public @ResponseBody Optional<Author> getAuthorById(@PathVariable Long author_id){
        System.out.println("Getting all authors...");
        return authorRepository.findById(author_id);
    }

    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping
    public void registerNewAuthor(@RequestBody Author author){
        authorService.addNewAuthor(author);
    }
}