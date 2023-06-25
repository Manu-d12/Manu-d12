package com.Student_Library_Management_System.ResponseMessage;

import com.Student_Library_Management_System.Enums.ResponseMessageStatus;

public class ResponseMessage {
    private String message;
    private ResponseMessageStatus status;

    public ResponseMessage(String message, ResponseMessageStatus status) {
        this.message = message;
        this.status = status;
    }

    public ResponseMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseMessageStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseMessageStatus status) {
        this.status = status;
    }
}
