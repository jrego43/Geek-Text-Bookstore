package com.geektext.bookstore.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long author_id;
    private String firstName;
    private String lastName;
    private String bio;
    private String authorPublisher;

    public Author(){
    }

    public Author(String firstName, String lastName, String bio, String authorPublisher){
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.authorPublisher = authorPublisher;
    }

    public Author(Long author_id, String firstName, String lastName, String bio, String authorPublisher){
        this.author_id = author_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.authorPublisher = authorPublisher;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAuthorPublisher() {
        return authorPublisher;
    }

    public void setAuthorPublisher(String authorPublisher) {
        this.authorPublisher = authorPublisher;
    }
}
