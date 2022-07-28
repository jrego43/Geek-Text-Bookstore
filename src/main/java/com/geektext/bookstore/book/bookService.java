package com.geektext.bookstore.book;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class bookService {

    private final bookRepository bRepository;

    @Autowired
    public bookService(bookRepository bRepository){
        this.bRepository = bRepository;
    }

    public List<book> getBooks(){
        return (List<book>) bRepository.findAll();
    }

    public void addNewBook(book booky){
        bRepository.save(booky);
        //System.out.println(profile);
    }

    public void deleteBook(Long id) {
    }

}