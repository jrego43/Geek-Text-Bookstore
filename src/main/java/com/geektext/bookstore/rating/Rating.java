package com.geektext.bookstore.rating;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class Rating {
    @Id
    private Long rating_id;
    private Long profile_id;
    private Long book_id;
    private Integer num_stars;
    private String datestamp;
    private String comment;
    
    public Rating() { }

    public Rating(Long profile_id, Long book_id, Integer num_stars, String datestamp, String comment) {
        this.profile_id = profile_id;
        this.book_id = book_id;
        this.num_stars = num_stars;
        this.datestamp = datestamp;
        this.comment = comment;
    }
    
    public Rating(Long rating_id, Long profile_id, Long book_id, Integer num_stars, String datestamp, String comment) {
        this.rating_id = rating_id;
        this.profile_id = profile_id;
        this.book_id = book_id;
        this.num_stars = num_stars;
        this.datestamp = datestamp;
        this.comment = comment;
    }

    public Long getRating_id() {
        return rating_id;
    }

    public void setRating_id(Long rating_id) {
        this.rating_id = rating_id;
    }

    public Long getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Long profile_id) {
        this.profile_id = profile_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Integer getNum_stars() {
        return num_stars;
    }

    public void setNum_stars(Integer num_stars) {
        this.num_stars = num_stars;
    }

    public String getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(String datestamp) {
        this.datestamp = datestamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Rating{" + "rating_id=" + rating_id 
                + ", profile_id=" + profile_id 
                + ", book_id=" + book_id 
                + ", num_stars=" + num_stars 
                + ", datestamp=" + datestamp 
                + ", comment=" + comment + '}';
    }
    
    
}
