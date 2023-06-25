package com.Student_Library_Management_System.Models;

import com.Student_Library_Management_System.Enums.TransactionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions_table")
public class Transactions {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Enumerated(value = EnumType.STRING)
   private TransactionStatus transactionStatus;

   private int fine;

   private String transcationID = UUID.randomUUID().toString();

   @CreationTimestamp
   private Date trasactionDate;

   private boolean isIssuedOperation;

   @ManyToOne
   @JoinColumn
   private Book book;

   @ManyToOne
   @JoinColumn
   private Card card;

   public Transactions() {
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public TransactionStatus getTransactionStatus() {
      return transactionStatus;
   }

   public void setTransactionStatus(TransactionStatus transactionStatus) {
      this.transactionStatus = transactionStatus;
   }

   public int getFine() {
      return fine;
   }

   public void setFine(int fine) {
      this.fine = fine;
   }

   public String getTranscationID() {
      return transcationID;
   }

   public void setTranscationID(String transcationID) {
      this.transcationID = transcationID;
   }

   public Date getTrasactionDate() {
      return trasactionDate;
   }

   public void setTrasactionDate(Date trasactionDate) {
      this.trasactionDate = trasactionDate;
   }

   public boolean isIssuedOperation() {
      return isIssuedOperation;
   }

   public void setIssuedOperation(boolean issuedOperation) {
      isIssuedOperation = issuedOperation;
   }

   public Book getBook() {
      return book;
   }

   public void setBook(Book book) {
      this.book = book;
   }

   public Card getCard() {
      return card;
   }

   public void setCard(Card card) {
      this.card = card;
   }

   public Transactions(int id, TransactionStatus transactionStatus, int fine, String transcationID, Date trasactionDate, boolean isIssuedOperation, Book book, Card card) {
      this.id = id;
      this.transactionStatus = transactionStatus;
      this.fine = fine;
      this.transcationID = transcationID;
      this.trasactionDate = trasactionDate;
      this.isIssuedOperation = isIssuedOperation;
      this.book = book;
      this.card = card;
   }
}
