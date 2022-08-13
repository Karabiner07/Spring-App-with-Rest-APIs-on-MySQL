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

    @GetMapping("/Teacher/emailId/{email}")
    public Teacher fetchTeacherByEmailId(@PathVariable("email") String emailId){
        return  teacherService.fetchTeacherByEmailId(emailId);
    }

    @GetMapping("/Hod/Department/{departmentId}")
    public Teacher getHodByDepartmentId(@PathVariable("departmentId") Long departmentId ){
        return teacherService.getHodByDepartment(departmentId);
    }

    @PutMapping("/Teacher/{id}")
    public Teacher updateTeacherByTeacherId(@PathVariable("id") Long teacherId,
                                            @RequestBody Teacher teacher){
        return teacherService.updateTeacherByTeacherId(teacherId, teacher);
    }

    @DeleteMapping("/Teacher/{id}")
    public String deleteTeacherById(@PathVariable("id") Long teacherId){
        teacherService.deleteTeacherById(teacherId);
        return "Teacher " +teacherId +" Deleted Successfully";
    }
}
