package com.Student_Library_Management_System.Contollers;
import com.Student_Library_Management_System.Models.Student;
import com.Student_Library_Management_System.Service.StudentService;
import com.Student_Library_Management_System.dtos.StudentUpdateMobReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentContoller {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
         studentService.createStudent(student);
         return "Student is created";
    }
    @GetMapping("/get")
    public String getNameByEmail(@RequestParam("email") String email){
        return studentService.findNameByEmail(email);
    }

    @PutMapping("/upd_mob")
    public String updateMobile(@RequestBody StudentUpdateMobReqDto studentUpdateMobReqDto){
        return studentService.updateMob(studentUpdateMobReqDto);
    }
}

