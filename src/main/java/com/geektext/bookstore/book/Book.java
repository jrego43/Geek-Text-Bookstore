package com.geektext.bookstore.book;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long book_id;
    private String isbn;
    private String book_name;
    private String description;
    private Long author_id;
    private Long genre_id;
    private Long publisher_id;
    private String date_published;
    private Double price;
    private Integer copies_sold;

    public Book() { }
    
    public Book(String isbn, String book_name, String description, Long author_id, Long genre_id, Long publisher_id, String date_published, Double price, Integer copies_sold) {
        this.isbn = isbn;
        this.book_name = book_name;
        this.description = description;
        this.author_id = author_id;
        this.genre_id = genre_id;
        this.publisher_id = publisher_id;
        this.date_published = date_published;
        this.price = price;
        this.copies_sold = copies_sold;
    }
    
    public Book(Long book_id, String isbn, String book_name, String description, Long author_id, Long genre_id, Long publisher_id, String date_published, Double price, Integer copies_sold) {
        this.book_id = book_id;
        this.isbn = isbn;
        this.book_name = book_name;
        this.description = description;
        this.author_id = author_id;
        this.genre_id = genre_id;
        this.publisher_id = publisher_id;
        this.date_published = date_published;
        this.price = price;
        this.copies_sold = copies_sold;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public Long getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Long publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCopies_sold() {
        return copies_sold;
    }

    public void setCopies_sold(Integer copies_sold) {
        this.copies_sold = copies_sold;
    }

    @Override
    public String toString() {
        return "Book{" 
                + "book_id=" + book_id 
                + ", isbn=" + isbn 
                + ", book_name=" + book_name 
                + ", description=" + description 
                + ", author_id=" + author_id 
                + ", genre_id=" + genre_id 
                + ", publisher_id=" + publisher_id 
                + ", date_published=" + date_published 
                + ", price=" + price 
                + ", copies_sold=" + copies_sold + '}';
    }
    
    
}
