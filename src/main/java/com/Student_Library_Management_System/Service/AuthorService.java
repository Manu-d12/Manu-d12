package com.Student_Library_Management_System.Service;


import com.Student_Library_Management_System.Models.Author;
import com.Student_Library_Management_System.Models.Book;
import com.Student_Library_Management_System.Repository.AuthorRepository;
import com.Student_Library_Management_System.Repository.BookRepository;
import com.Student_Library_Management_System.dtos.AuthorEntryDto;
import com.Student_Library_Management_System.dtos.AuthorResponseDto;
import com.Student_Library_Management_System.dtos.BookResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;


    public boolean createAuthor(AuthorEntryDto authorEntryDto){
        //we need coversions and set the other properties which are not being send from postman
       Author author = new Author();
       author.setName(authorEntryDto.getName());
       author.setAge(authorEntryDto.getAge());
       author.setCountry(authorEntryDto.getCountry());
       author.setRating(authorEntryDto.getRating());

        authorRepository.save(author);
        return true;
    }

    public AuthorResponseDto findById(int id){
        Author author =  authorRepository.findById(id).orElse(null);
        if(author == null){
           //"Author is not there"
            return null;
        }
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        //giving a problem
        List<Book> bookList1 = author.getBooksWritten();
        List<BookResDto> bookList2 = new ArrayList<>();
        for(Book b : bookList1){
            BookResDto bdto = new BookResDto();
            bdto.setAuthorId(b.getAuthor().getId());
            bdto.setName(b.getName());
            bdto.setGenre(b.getGenre());
            bdto.setPages(b.getPages());
            bdto.setRating(b.getRating());
            bookList2.add(bdto);
        }
        authorResponseDto.setBooksWritten(bookList2);
        authorResponseDto.setRating(author.getRating());
        authorResponseDto.setCountry(author.getCountry());
        return authorResponseDto;
    }

    public AuthorResponseDto updateAge(int authorId, int age) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if(author == null){
            //author not exists
            //will handle this later by putting the exception
            return null;
        }
        author.setAge(age);
        authorRepository.save(author);
        return this.findById(authorId);
    }

}
