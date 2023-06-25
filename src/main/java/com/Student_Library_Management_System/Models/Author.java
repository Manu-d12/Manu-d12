package com.Student_Library_Management_System.Models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author_table")
public class Author {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  int id;
   private String name;
   private int age;
   private String country;

   private double rating;

   public Author(int id, String name, int age, String country, double rating, List<Book> booksWritten) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.country = country;
      this.rating = rating;
      this.booksWritten = booksWritten;
   }
//This annotation in the parent table
   //part of the bidirectional mapping
   //this should be modified when the Book of this author will be added to the DB

   public double getRating() {
      return rating;
   }

   public void setRating(double rating) {
      this.rating = rating;
   }

   @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Book> booksWritten = new ArrayList<>();


   public Author(int id, String name, int age, String country, List<Book> booksWritten) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.country = country;
      this.booksWritten = booksWritten;
   }


   public Author() {
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
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

   public List<Book> getBooksWritten() {
      return booksWritten;
   }

   public void setBooksWritten(List<Book> booksWritten) {
      this.booksWritten = booksWritten;
   }
}
