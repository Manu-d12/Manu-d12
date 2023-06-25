package com.Student_Library_Management_System.dtos;

import com.Student_Library_Management_System.Enums.Genre;

public class BookResDto {
    private String name;
    private int pages;
    private double rating;
    private Genre genre;

    private int authorId;

    public BookResDto(String name, int pages, double rating, Genre genre, int authorId) {
        this.name = name;
        this.pages = pages;
        this.rating = rating;
        this.genre = genre;
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public BookResDto() {

    }
}
