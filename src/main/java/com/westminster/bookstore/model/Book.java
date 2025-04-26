package com.westminster.bookstore.model;

public class Book {
    private int bookId;
    private String title;
    private int authorId;
    private String isbn;
    private int publicationYear;
    private double price;
    private int stockQuantity;

    public Book() {
    }

    // Constructor without bookId for auto-generation
    public Book(String title, int authorId, String isbn, int publicationYear, double price, int stockQuantity) {
        this.title = title;
        this.authorId = authorId;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Book(String title, int bookId, int authorId, String isbn, int publicationYear, double price, int stockQuantity) {
        this.title = title;
        this.bookId = bookId;
        this.authorId = authorId;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", title=" + title + ", authorId=" + authorId + ", isbn=" + isbn + ", publicationYear=" + publicationYear + ", price=" + price + ", stockQuantity=" + stockQuantity + '}';
    }
}