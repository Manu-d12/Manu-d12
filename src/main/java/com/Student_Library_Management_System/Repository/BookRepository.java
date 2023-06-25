package com.Student_Library_Management_System.Repository;

import com.Student_Library_Management_System.Models.Author;
import com.Student_Library_Management_System.Models.Book;
import com.Student_Library_Management_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
   //custom finderMethod
    void deleteByAuthor(Author author);
 }
