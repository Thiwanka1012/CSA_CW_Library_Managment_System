/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nenasa.bookstoremodel;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thiwanka-Gaming
 */
public class Order {
    private int orderId;
    private int customerId;
    private Map<Integer,Integer> items;
    private double totalPrice;
    private LocalDateTime orderDate;
    
}
