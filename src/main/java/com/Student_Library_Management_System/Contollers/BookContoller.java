package com.Student_Library_Management_System.Contollers;

import com.Student_Library_Management_System.Models.Book;
import com.Student_Library_Management_System.Service.BookService;
import com.Student_Library_Management_System.dtos.BookReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookContoller {

    @Autowired
    private BookService bookService;
    @PostMapping("/create/{id}")
    public String createBook(@RequestBody BookReqDto bookReqDto){
        bookService.createBook(bookReqDto);
        return "Book is saved";
    }


    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.findById(id);
    }
}

