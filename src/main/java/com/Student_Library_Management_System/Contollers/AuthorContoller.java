package com.Student_Library_Management_System.Contollers;
import com.Student_Library_Management_System.Enums.ResponseMessageStatus;
import com.Student_Library_Management_System.Models.Author;
import com.Student_Library_Management_System.Models.Book;
import com.Student_Library_Management_System.ResponseMessage.ResponseMessage;
import com.Student_Library_Management_System.Service.AuthorService;
import com.Student_Library_Management_System.dtos.AuthorEntryDto;
import com.Student_Library_Management_System.dtos.AuthorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/author")
public class AuthorContoller {
    @Autowired
    private AuthorService authorService;
    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> createAuthor(@RequestBody AuthorEntryDto authorEntryDto){
        boolean flag = authorService.createAuthor(authorEntryDto);
        ResponseMessage message = new ResponseMessage();
        if(flag == true){
            message.setStatus(ResponseMessageStatus.SUCCESS);
            message.setMessage("Author added Succesfully");
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }else{
            message.setStatus(ResponseMessageStatus.FAILED);
            message.setMessage("Something went wrong");
            return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthor(@PathVariable int id){
        AuthorResponseDto authorResponseDto =  authorService.findById(id);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.FOUND);
    }
    @PutMapping("/update")
    public ResponseEntity<AuthorResponseDto> updateAge(@RequestParam("id") int authorId, @RequestParam("age") int age){
        AuthorResponseDto authorResponseDto = authorService.updateAge(authorId, age);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }
}
