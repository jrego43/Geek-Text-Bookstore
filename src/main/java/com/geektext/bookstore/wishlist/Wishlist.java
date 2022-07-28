
package com.geektext.bookstore.wishlist;

import java.util.ArrayList;
import java.util.List;


public class Wishlist {
    private List<ListItem> wishlist;
    private Long owner_id;
    private String wishlist_name;
    
    public Wishlist() { }
    
    public Wishlist(Long owner_id, String wishlist_name) {
        this.wishlist = new ArrayList<>();
        this.owner_id = owner_id;
        this.wishlist_name = wishlist_name;
    }

    public Wishlist(List<ListItem> wishlist, Long owner_id, String wishlist_name) {
        this.wishlist = wishlist;
        this.owner_id = owner_id;
        this.wishlist_name = wishlist_name;
    }

    public List<ListItem> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<ListItem> wishlist) {
        this.wishlist = wishlist;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public String getWishlist_name() {
        return wishlist_name;
    }

    public void setWishlist_name(String wishlist_name) {
        this.wishlist_name = wishlist_name;
    }

    @Override
    public String toString() {
        return "Wishlist{" + "wishlist=" + wishlist + 
                ", owner_id=" + owner_id 
                + ", wishlist_name=" + wishlist_name + '}';
    }
    
    
}
