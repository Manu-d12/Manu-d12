package com.Student_Library_Management_System.Service;

import com.Student_Library_Management_System.Models.Author;
import com.Student_Library_Management_System.Models.Book;
import com.Student_Library_Management_System.Repository.AuthorRepository;
import com.Student_Library_Management_System.Repository.BookRepository;
import com.Student_Library_Management_System.dtos.BookReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String createBook(BookReqDto bookReqDto){
        //Book ka kam ho gya
        Author author = authorRepository.findById(bookReqDto.getAuthorId()).get();
        Book book = new Book();
        book.setName(bookReqDto.getName());
        book.setPages(bookReqDto.getPages());
        book.setGenre(bookReqDto.getGenre());
        book.setRating(bookReqDto.getRating());
        book.setAuthor(author);
        book.setIssued(false);

        //author ka kam bcha h
        List<Book> list = author.getBooksWritten();
        list.add(book);
        author.setBooksWritten(list);

        //Now the book is to be saved and the Author also.
        //Why we need to save --> author has been updated , we have to resave it or update it
        //Either we have to save both or only one them.
        //we don't need to save book --> because author is parent and due to cascade effect it will get automatically get saved
        //save works same for both saving and updating the entry in the table.
        authorRepository.save(author);

        return "Book is saved";
    }

    public Book findById(int id){
        return bookRepository.findById(id).get();
    }
}

