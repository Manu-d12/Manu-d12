package com.Student_Library_Management_System.Contollers;

import com.Student_Library_Management_System.Service.TransactionService;
import com.Student_Library_Management_System.dtos.IssueBookReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionContoller {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookReqDto issueBookReqDto)throws  Exception{
        try{
            return transactionService.issueBook(issueBookReqDto);
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
