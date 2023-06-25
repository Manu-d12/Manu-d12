package com.Student_Library_Management_System.dtos;
import com.Student_Library_Management_System.Models.Book;
import java.util.ArrayList;
import java.util.List;

public class AuthorResponseDto {
    private String name;
    private int age;
    private String country;
    private double rating;
    private List<BookResDto> booksWritten = new ArrayList<>();

    public AuthorResponseDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<BookResDto> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<BookResDto> booksWritten) {
        this.booksWritten = booksWritten;
    }

    public AuthorResponseDto(String name, int age, String country, double rating, List<BookResDto> booksWritten) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.rating = rating;
        this.booksWritten = booksWritten;
    }
}
