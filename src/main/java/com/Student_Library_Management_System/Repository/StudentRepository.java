package com.Student_Library_Management_System.Repository;

import com.Student_Library_Management_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

   //custom finder methods in order to fetch entities
    Student findByEmail(String email);

    //select * from student where country = "country"
    List<Student> findByCountry(String country);
}
