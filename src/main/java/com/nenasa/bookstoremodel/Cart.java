/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nenasa.bookstoremodel;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thiwanka-Gaming
 */
public class Cart {
    
    private int customerId;
    private Map<Integer,Integer> item;

    public Cart() {
    }

    public Cart(int customerId, Map<Integer, Integer> item) {
        this.customerId = customerId;
        this.item = item;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Map<Integer, Integer> getItem() {
        return item;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setItem(Map<Integer, Integer> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Cart{" + "customerId=" + customerId + ", item=" + item + '}';
    }
    
    
    
    
    
    
}
