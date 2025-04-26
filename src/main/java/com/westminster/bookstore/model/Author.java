package com.westminster.bookstore.model;

public class Author {
    private int authorId;
    private String firstName;
    private String lastName;
    private String biography;

    public Author() {
    }

    // Constructor without authorId for auto-generation
    public Author(String firstName, String lastName, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
    }

    public Author(int authorId, String firstName, String lastName, String biography) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{" + "authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", biography=" + biography + '}';
    }
}