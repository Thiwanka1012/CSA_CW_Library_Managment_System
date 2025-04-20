/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nenasa.bookshop.model;

/**
 *
 * @author Thiwanka-Gaming
 */
public class Customer {
    
    //Attributes of Customer class
    private String customerName;
    private int emailAddress;
    private int password;

    //Non parameterized constructor
    public Customer() {
    }

    //Parameterized Constructor
    public Customer(String customerName, int emailAddress, int password) {
        this.customerName = customerName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    
    //Getter methods
    public String getCustomerName() {
        return customerName;
    }

    public int getEmailAddress() {
        return emailAddress;
    }

    public int getPassword() {
        return password;
    }
    
    
    //Setter Methods
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmailAddress(int emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    //To string method
    @Override
    public String toString() {
        return "Customer{" + "customerName=" + customerName + ", emailAddress=" + emailAddress + ", password=" + password + '}';
    }
    
    
    
}
