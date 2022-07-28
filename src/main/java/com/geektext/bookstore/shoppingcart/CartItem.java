package com.geektext.bookstore.shoppingcart;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class CartItem {
    @Id
    private Long item_id;
    private Long profile_id;
    private Long book_id;
    
    public CartItem() { }

    public CartItem(Long item_id, Long profile_id, Long book_id) {
        this.item_id = item_id;
        this.profile_id = profile_id;
        this.book_id = book_id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
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

    @Override
    public String toString() {
        return "CartItem{" + "item_id=" + item_id 
                + ", profile_id=" + profile_id 
                + ", book_id=" + book_id + '}';
    }

    
}
