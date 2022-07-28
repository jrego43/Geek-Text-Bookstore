package com.geektext.bookstore.shoppingcart;

import com.geektext.bookstore.book.Book;
import com.geektext.bookstore.book.BookRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "api/cart")
public class CartItemController {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private BookRepository bookRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<CartItem> getAllCartItems() {
        System.out.println("Getting all cart items...");
        return cartItemRepository.findAll();
    }
    
    @GetMapping(path="/{item_id}")
    public @ResponseBody Optional<CartItem> getCartItemById(@PathVariable Long item_id) {
        return cartItemRepository.findById(item_id);
    }
    
    @GetMapping(path="/profile/{profile_id}/instantiate")
    public @ResponseBody ShoppingCart createShoppingCartInstance(@PathVariable Long profile_id) {
        List<CartItem> cart = cartItemRepository.findCartItemsByProfileId(profile_id);
        
        return new ShoppingCart(cart, profile_id);
    }
    
    @PostMapping
    public @ResponseBody CartItem addBookToShoppingCart(@RequestBody CartItem cartItem) {
        if(cartItem.getItem_id() == null || cartItem.getProfile_id() == null || cartItem.getBook_id() == null) {
            throw new IllegalArgumentException("One or more fields are null... Try again!");
        }
        else {
            return cartItemRepository.saveAndFlush(cartItem);
        }
    }
    
    @GetMapping(path="/profile/{profile_id}")
    public @ResponseBody List<Book> getBooksFromShoppingCart(@PathVariable Long profile_id) {
        return bookRepository.findBooksFromShoppingCart(profile_id);
    }
    
    @DeleteMapping(path="{item_id}")
    public @ResponseBody CartItem deleteItemFromShoppingCart(@PathVariable Long item_id) {
        CartItem item;
        
        try {
            item = getCartItemById(item_id).orElseThrow();
        }
        catch(NoSuchElementException e) {
            System.out.println("Cart item does not exist");
            item = null;
        }
        
        cartItemRepository.deleteById(item_id);
        
        return item;
    }
}
