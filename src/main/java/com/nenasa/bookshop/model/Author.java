/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nenasa.bookshop.model;

/**
 *
 * @author Thiwanka-Gaming
 */
public class Author {
    
    private int authorId;
    private String authorName;
    private String biography;

    public Author() {
    }

    public Author(int authorId, String authorName, String biography) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.biography = biography;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getBiography() {
        return biography;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{" + "authorId=" + authorId + ", authorName=" + authorName + ", biography=" + biography + '}';
    }
    
    
    
    
    
    
    
}
