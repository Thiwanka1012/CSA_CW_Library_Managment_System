/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.bookstore.model;

/**
 *
 * @author Thiwanka-Gaming
 */

//Add other Attributes
public class Author {
    
    private int authorId;
    private String authorFirstName;
    private String authorLastName;
    private String biography;

    
    //Non parameterized constructor
    public Author() {
    }

    //Parameterized Constructor
    public Author(int authorId, String authorFirstName,String authorLastName,String biography) {
        this.authorId = authorId;
        this.authorFirstName = authorFirstName;
        this.authorLastName=authorLastName;
        this.biography = biography;
    }

    //Getter methods
    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }
    
    

    public String getBiography() {
        return biography;
    }
    
    
    //Setter Methods
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }
    

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{" + "authorId=" + authorId + ", authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName + ", biography=" + biography + '}';
    }


    
    
    
    
    
    
    
}
