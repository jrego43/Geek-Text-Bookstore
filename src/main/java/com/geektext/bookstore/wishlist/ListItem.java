package com.geektext.bookstore.wishlist;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class ListItem {
    @Id
    private Long item_id;
    private Long wishlist_id;
    private Long profile_id;
    private Long book_id;
    private String wishlist_name;
    
    public ListItem() { }

    public ListItem(Long item_id, Long wishlist_id, Long profile_id, Long book_id, String wishlist_name) {
        this.item_id = item_id;
        this.wishlist_id = wishlist_id;
        this.profile_id = profile_id;
        this.book_id = book_id;
        this.wishlist_name = wishlist_name;
    }
    
    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(Long wishlist_id) {
        this.wishlist_id = wishlist_id;
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

    public String getWishlist_name() {
        return wishlist_name;
    }

    public void setWishlist(String wishlist_name) {
        this.wishlist_name = wishlist_name;
    }

    @Override
    public String toString() {
        return "ListItem{" + "item_id=" + item_id 
                + "wishlist_id=" + wishlist_id 
                + ", profile_id=" + profile_id 
                + ", book_id=" + book_id 
                + ", wishlist_name=" + wishlist_name + '}';
    }
    
    
}
