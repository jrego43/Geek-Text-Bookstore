package com.geektext.bookstore.wishlist;

import com.geektext.bookstore.book.Book;
import com.geektext.bookstore.book.BookRepository;
import com.geektext.bookstore.shoppingcart.CartItem;
import com.geektext.bookstore.shoppingcart.CartItemRepository;
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
@RequestMapping(path = "api/list")
public class ListItemController {
    @Autowired
    private ListItemRepository listItemRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<ListItem> getAllListItems() {
        System.out.println("Getting all list items...");
        return listItemRepository.findAll();
    }
    
    @GetMapping(path="/{item_id}")
    public @ResponseBody Optional<ListItem> getListItemById(@PathVariable Long item_id) {
        return listItemRepository.findById(item_id);
    }
    
    @GetMapping(path="/profile/{profile_id}/{wishlist_id}/instantiate")
    public @ResponseBody Wishlist createWishlistInstance(@PathVariable Long wishlist_id, @PathVariable Long profile_id) {
        List<ListItem> list = listItemRepository.findListItemsByWishlistAndProfileId(wishlist_id, profile_id);
        
        return new Wishlist(list, profile_id, list.get(0).getWishlist_name());
    }
    
    @PostMapping
    public @ResponseBody ListItem addBookToWishlist(@RequestBody ListItem listItem) {
        try {
            if(listItem.getItem_id() == null || 
                listItem.getWishlist_id() == null ||
                listItem.getProfile_id() == null || 
                listItem.getBook_id() == null ||
                listItem.getWishlist_name() == null) 
            {
                throw new IllegalArgumentException("One or more fields are null... Try again!");
            }
            else {
                System.out.println(listItem.getWishlist_id());
                
                if(listItem.getWishlist_id() != 1 && 
                    listItem.getWishlist_id() != 2 &&
                    listItem.getWishlist_id() != 3) 
                {
                    System.out.println("wishlist_id must be 1, 2 or 3.");
                    return null;
                }
                
                return listItemRepository.saveAndFlush(listItem);
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @GetMapping(path="/profile/{profile_id}/{wishlist_id}")
    public @ResponseBody List<Book> getBooksFromWishlist(@PathVariable Long wishlist_id, @PathVariable Long profile_id) {
        return bookRepository.findBooksFromWishlist(wishlist_id, profile_id);
    }
    
    @DeleteMapping(path="/{item_id}/move-to-cart")
    public @ResponseBody ListItem deleteItemFromWishlist(@PathVariable Long item_id) {
        ListItem listItem;
        
        try {
            listItem = getListItemById(item_id).orElseThrow();
        }
        catch(NoSuchElementException e) {
            System.out.println("List item does not exist");
            return null;
        }
        
        CartItem cartItem = new CartItem(cartItemRepository.count() + 1, listItem.getProfile_id(), listItem.getBook_id());
        cartItemRepository.saveAndFlush(cartItem);
        
        listItemRepository.deleteById(item_id);
        
        return listItem;
    }
}
