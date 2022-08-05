package com.universitymanagement.project.controller;


import com.universitymanagement.project.entitiy.Teacher;
import com.universitymanagement.project.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/Teachers")
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("/Teachers")
    public List<Teacher> fetchTeacherList(){
        return teacherService.fetchTeacherList();
    }

    @GetMapping("/Teacher/Id/{id}")
    public Teacher fetchTeacherById(@PathVariable("id") Long teacherId){
        return teacherService.fetchTeacherById(teacherId);
    }

    @DeleteMapping("/Teacher/{id}")
    public String deleteTeacherById(@PathVariable("id") Long teacherId){
        teacherService.deleteTeacherById(teacherId);
        return "Teacher " +teacherId +" Deleted Successfully";
    }



}
