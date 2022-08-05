package com.universitymanagement.project.controller;

import com.universitymanagement.project.entitiy.Student;
import com.universitymanagement.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentservice;

    @PostMapping("/Students")
    public Student saveStudent(@Valid @RequestBody Student student){
        return studentservice.saveStudent(student);
    }

    @GetMapping("/Students")
    public List<Student> fetchStudentList(){
        return studentservice.fetchStudentList();
    }

    @GetMapping("/Student/{id}")
    public Student fetchStudentById(@PathVariable("id") Long studentId){
        return studentservice.fetchStudentById(studentId);
    }

    @GetMapping("/Student/email/{email}")
    public Student fetchStudentByEmailId(@PathVariable("email") String emailId){
        return studentservice.fetchStudentByEmailId(emailId);
    }

    @PutMapping("/Student/{id}")
    public Student updateStudentById(@PathVariable("id") Long studentId,
                                     @RequestBody Student student){
        return studentservice.updateStudentById(studentId, student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId){
        studentservice.deleteStudentById(studentId);
        return "Student " +studentId +" data deleted successfully";
    }


}
