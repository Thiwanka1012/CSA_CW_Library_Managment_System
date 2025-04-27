package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Cart;
import com.westminster.bookstore.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    private static List<Cart> carts = new ArrayList<>();

    public Cart getCartByCustomerId(int customerId) {
        for (Cart cart : carts) {
            if (cart.getCustomerId() == customerId) {
                return cart;
            }
        }
        Cart newCart = new Cart(customerId, new ArrayList<>());
        carts.add(newCart);
        return newCart;
    }

    public void addItemToCart(int customerId, CartItem cartItem) {
        Cart cart = getCartByCustomerId(customerId);
        List<CartItem> items = cart.getItems();

        // Check if the book is already in the cart
        for (CartItem item : items) {
            if (item.getBookId() == cartItem.getBookId()) {
                item.setQuantity(item.getQuantity() + cartItem.getQuantity());
                return;
            }
        }
        items.add(cartItem);
    }

    public void updateCartItem(int customerId, CartItem updatedItem) {
        Cart cart = getCartByCustomerId(customerId);
        List<CartItem> items = cart.getItems();

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getBookId() == updatedItem.getBookId()) {
                items.set(i, updatedItem);
                return;
            }
        }
        items.add(updatedItem);
    }

    public void removeItemFromCart(int customerId, int bookId) {
        Cart cart = getCartByCustomerId(customerId);
        List<CartItem> items = cart.getItems();
        items.removeIf(item -> item.getBookId() == bookId);
    }

    public void removeAllItemsFromCart(int customerId) {
        Cart cart = getCartByCustomerId(customerId);
        cart.getItems().clear();
    }

    public void clearCarts() {
        carts.clear();
    }
}