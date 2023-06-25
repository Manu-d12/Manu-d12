package com.Student_Library_Management_System.Models;
import com.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Card_Table")
public class Card {

    //Plan is to save card in DB
    //Before saving i have to set its attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //auto generated

    @CreationTimestamp //time when an entry is created on
    private Date createdON;  //auto generated

    @UpdateTimestamp//set time when an entry is updated on
    private Date updatedOn;  //auto generated

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus; // i have set this manually

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student; //must have to set

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> booksIssued = new ArrayList<>();

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Transactions> transactionsList = new ArrayList<>();

    public Card(int id, Date createdON, Date updatedOn, CardStatus cardStatus) {
        this.id = id;
        this.createdON = createdON;
        this.updatedOn = updatedOn;
        this.cardStatus = cardStatus;
    }


    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }



    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public Card(int id, Date createdON, Date updatedOn, CardStatus cardStatus, Student student, List<Book> booksIssued, List<Transactions> transactionsList) {
        this.id = id;
        this.createdON = createdON;
        this.updatedOn = updatedOn;
        this.cardStatus = cardStatus;
        this.student = student;
        this.booksIssued = booksIssued;
        this.transactionsList = transactionsList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Card() {
    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }

    public Card(int id, Date createdON, Date updatedOn, CardStatus cardStatus, Student student, List<Book> booksIssued) {
        this.id = id;
        this.createdON = createdON;
        this.updatedOn = updatedOn;
        this.cardStatus = cardStatus;
        this.student = student;
        this.booksIssued = booksIssued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedON() {
        return createdON;
    }

    public void setCreatedON(Date createdON) {
        this.createdON = createdON;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}
