/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.bookstore.model;



/**
 *
 * @author Thiwanka-Gaming
 */
public class Customer {
    
    //Attributes of Customer class
    private int customerId;
    private String customerFirstName;
    private String customerLastName;
    private String emailAddress;
    private int password;

    //Non parameterized constructor
    public Customer() {
    }

    //Parameterized Constructor
    public Customer(int customerId,String customerFirstName,String customerLastName,String emailAddress, int password) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName=customerLastName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    
    //Getter methods

    public int getCustomerId() {
        return customerId;
    }
    
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }
    
    

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getPassword() {
        return password;
    }
    
    
    //Setter Methods
    
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }
    

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    //To String method
    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName + ", emailAddress=" + emailAddress + ", password=" + password + '}';
    }


    
    
}
