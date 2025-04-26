package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Cart;
import com.westminster.bookstore.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    private static List<Cart> carts = new ArrayList<>();

//    static {
//        List<CartItem> items1 = new ArrayList<>();
//        items1.add(new CartItem(1, 2)); // Book ID 1, Quantity 2
//        items1.add(new CartItem(2, 1)); // Book ID 2, Quantity 1
//        carts.add(new Cart(1, items1));
//
//        List<CartItem> items2 = new ArrayList<>();
//        items2.add(new CartItem(2, 3)); // Book ID 2, Quantity 3
//        carts.add(new Cart(2, items2));
//    }

    public List<Cart> getAllCarts() {
        return new ArrayList<>(carts);
    }

    public Cart getCartByCustomerId(int customerId) {
        for (Cart cart : carts) {
            if (cart.getCustomerId() == customerId) {
                return cart;
            }
        }
        return null;
    }

    public void addCart(Cart cart) {
        carts.add(cart);
    }

    public void updateCart(Cart updatedCart) {
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getCustomerId() == updatedCart.getCustomerId()) {
                carts.set(i, updatedCart);
                return;
            }
        }
    }

    public void deleteCart(int customerId) {
        carts.removeIf(cart -> cart.getCustomerId() == customerId);
    }

    public void addItemToCart(int customerId, CartItem cartItem) {
        Cart cart = getCartByCustomerId(customerId);
        if (cart == null) {
            cart = new Cart(customerId, new ArrayList<>());
            cart.getItems().add(cartItem);
            addCart(cart);
        } else {
            boolean itemExists = false;
            for (CartItem item : cart.getItems()) {
                if (item.getBookId() == cartItem.getBookId()) {
                    item.setQuantity(item.getQuantity() + cartItem.getQuantity());
                    itemExists = true;
                    break;
                }
            }
            if (!itemExists) {
                cart.getItems().add(cartItem);
            }
        }
    }

    public void updateCartItem(int customerId, CartItem updatedItem) {
        Cart cart = getCartByCustomerId(customerId);
        if (cart != null) {
            for (CartItem item : cart.getItems()) {
                if (item.getBookId() == updatedItem.getBookId()) {
                    item.setQuantity(updatedItem.getQuantity());
                    return;
                }
            }
        }
    }

    public void removeItemFromCart(int customerId, int bookId) {
        Cart cart = getCartByCustomerId(customerId);
        if (cart != null) {
            cart.getItems().removeIf(item -> item.getBookId() == bookId);
        }
    }
}