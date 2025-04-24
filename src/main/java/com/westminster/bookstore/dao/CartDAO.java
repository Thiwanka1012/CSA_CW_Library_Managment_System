package com.westminster.bookstore.storage;

import com.westminster.bookstore.model.Cart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDAO {
    private static List<Cart> carts = new ArrayList<>();

    // Initialize with some sample data
    static {
        Map<Integer, Integer> items1 = new HashMap<>();
        items1.put(1, 2); // Book ID 1, Quantity 2
        items1.put(2, 1); // Book ID 2, Quantity 1
        carts.add(new Cart(1, items1));

        Map<Integer, Integer> items2 = new HashMap<>();
        items2.put(2, 3); // Book ID 2, Quantity 3
        carts.add(new Cart(2, items2));
    }

    // Get all carts
    public List<Cart> getAllCarts() {
        return new ArrayList<>(carts); // Return a copy to prevent direct modification
    }

    // Get cart by customer ID
    public Cart getCartByCustomerId(int customerId) {
        for (Cart cart : carts) {
            if (cart.getCustomerId() == customerId) {
                return cart;
            }
        }
        return null;
    }

    // Add a new cart
    public void addCart(Cart cart) {
        carts.add(cart);
    }

    // Update an existing cart
    public void updateCart(Cart updatedCart) {
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getCustomerId() == updatedCart.getCustomerId()) {
                carts.set(i, updatedCart);
                return;
            }
        }
    }

    // Delete a cart by customer ID
    public void deleteCart(int customerId) {
        carts.removeIf(cart -> cart.getCustomerId() == customerId);
    }
}