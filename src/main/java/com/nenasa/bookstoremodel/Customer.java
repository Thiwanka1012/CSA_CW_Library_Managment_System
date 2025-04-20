/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nenasa.bookstoremodel;

/**
 *
 * @author Thiwanka-Gaming
 */
public class Customer {
    
    //Attributes of Customer class
    private int customerId;
    private String customerName;
    private int emailAddress;
    private int password;

    //Non parameterized constructor
    public Customer() {
    }

    //Parameterized Constructor
    public Customer(int customerId,String customerName, int emailAddress, int password) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    
    //Getter methods

    public int getCustomerId() {
        return customerId;
    }
    
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
    
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

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
