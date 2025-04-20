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
    
    private String customerName;
    private int emailAddress;
    private int password;

    public Customer() {
    }

    public Customer(String customerName, int emailAddress, int password) {
        this.customerName = customerName;
        this.emailAddress = emailAddress;
        this.password = password;
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

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmailAddress(int emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerName=" + customerName + ", emailAddress=" + emailAddress + ", password=" + password + '}';
    }
    
    
    
}
