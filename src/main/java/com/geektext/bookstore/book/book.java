package com.geektext.bookstore.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long book_id;
    private String isbn;
    private String bookName;
    private String bookDescription;
    private Double price;
    private String author;
    private Long genre_id;
    private Long publisher_id;
    private String yearPublished;
    private Integer copiesSold;
    
    

    public book() { }
    
    public book(String isbn, String bookName, String bookDescription, Double price,
        String author, Long genre_id, Long publisher_id, String yearPublished, Integer copiesSold){
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.price = price;
        this.author = author;
        this.genre_id = genre_id;
        this.publisher_id = publisher_id;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public book(Long book_id, String isbn, String bookName, String bookDescription, Double price,
        String author, Long genre_id, Long publisher_id, String yearPublished, Integer copiesSold){
        this.book_id = book_id;
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.price = price;
        this.author = author;
        this.genre_id = genre_id;
        this.publisher_id = publisher_id;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }


    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public Long getgenre_id() {
        return genre_id;
    }

    public void setgenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public Long getpublisher_id() {
        return publisher_id;
    }

    public void setpublisher_id(Long publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Integer getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(Integer copiesSold) {
        this.copiesSold = copiesSold;
    }
    
    @Override
    public String toString(){
        return "Book{"
            + "book_id=" + book_id
            + ", isbn=" + isbn
            + ", bookName=" + bookName
            + ", bookDescription=" + bookDescription
            + ", price=" + price
            + ", author=" + author
            + ", genre_id=" + genre_id
            + ", publisher_id=" + publisher_id
            + ", yearPublished=" + yearPublished
            + ", copiesSold=" + copiesSold + '}';
    }
    
    
}
