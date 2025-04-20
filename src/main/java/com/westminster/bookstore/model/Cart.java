/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.bookstore.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thiwanka-Gaming
 */
public class Cart {
    
    //Attributes
    private int customerId;
    private Map<Integer,Integer> item;

    //Non parameterized constructor
    public Cart() {
    }

    //Parameterized constructor
    public Cart(int customerId, Map<Integer, Integer> item) {
        this.customerId = customerId;
        this.item = item;
    }

   //Getter methods
    public int getCustomerId() {
        return customerId;
    }

    public Map<Integer, Integer> getItem() {
        return item;
    }

    //Setter methods
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setItem(Map<Integer, Integer> item) {
        this.item = item;
    }

    //To string method
    @Override
    public String toString() {
        return "Cart{" + "customerId=" + customerId + ", item=" + item + '}';
    }
    
    
    
    
    
    
}
