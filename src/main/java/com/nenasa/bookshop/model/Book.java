/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nenasa.bookshop.model;

/**
 *
 * @author Thiwanka-Gaming
 */
public class Book {
    
    private String title;
    private int bookId;
    private String authorName;
    private int isbn;
    private int publicationYear;
    private int price;
    private int stockQuantity;

    public Book(String title, int bookId, String authorName, int isbn, int publicationYear, int price, int stockQuantity) {
        this.title = title;
        this.bookId = bookId;
        this.authorName = authorName;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    
    
    
}



