/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.bookstore.model;

/**
 *
 * @author Thiwanka-Gaming
 */

//Attributes of Book
public class Book {
    
    private String title;
    private int bookId;
    private String authorName;
    private String isbn;
    private int publicationYear;
    private double price;
    private int stockQuantity;

    
    //Non parameterized Constructor
    public Book() {
    }
    

    //Parameterized Constructor
    public Book(String title, int bookId, String authorName, String isbn, int publicationYear, double price, int stockQuantity) {
        this.title = title;
        this.bookId = bookId;
        this.authorName = authorName;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    //Getter Methods
    public String getTitle() {
        return title;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    
    //Setter Methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", bookId=" + bookId + ", authorName=" + authorName + ", isbn=" + isbn + ", publicationYear=" + publicationYear + ", price=" + price + ", stockQuantity=" + stockQuantity + '}';
    }
    
    
    
    
    
}



