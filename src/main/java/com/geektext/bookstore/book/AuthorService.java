package com.geektext.bookstore.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorService {
    
    private final AuthorRepository aRepository;

    @Autowired
    public AuthorService(AuthorRepository aRepository){
        this.aRepository = aRepository;
    }

    public List<Author> getAuthors(){
        return (List<Author>) aRepository.findAll();
    }

    public void addNewAuthor(Author author){
        aRepository.save(author);
    }

    
}
