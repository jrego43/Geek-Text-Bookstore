package com.geektext.bookstore.shoppingcart;

import com.geektext.bookstore.shoppingcart.CartItem;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> cart;
    private Long owner_id;
    
    public ShoppingCart() { }
    
    public ShoppingCart(Long owner_id) {
        this.cart = new ArrayList<>();
        this.owner_id = owner_id;
    }
    
    public ShoppingCart(List<CartItem> cart, Long owner_id) {
        this.cart = cart;
        this.owner_id = owner_id;
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "cart=" + cart + ", owner_id=" + owner_id + '}';
    }
    
}
