package com.Student_Library_Management_System.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "Student_Table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "contact")
    private String mobNo;

    @Column(name = "country")
    private String country;

    //Plain Syntax for bidirectional mapping
    //name of the variable of the parent entity that you have written in child class foriegen attribute
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Student(int id, String name, String email, int age, String mobNo, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.mobNo = mobNo;
        this.country = country;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", mobNo='" + mobNo + '\'' +
                ", country='" + country + '\'' +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
