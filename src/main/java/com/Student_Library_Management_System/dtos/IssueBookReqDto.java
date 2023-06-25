package com.Student_Library_Management_System.dtos;

public class IssueBookReqDto {
    private int bookId;
    private int cardId;

    public IssueBookReqDto(int bookId, int cardId) {
        this.bookId = bookId;
        this.cardId = cardId;
    }

    public IssueBookReqDto() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
