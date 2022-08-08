package com.universitymanagement.project.controller;

import com.universitymanagement.project.entitiy.Subject;
import com.universitymanagement.project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/Subjects")
    public Subject saveSubject(@RequestBody Subject subject) {
        return subjectService.saveSubject(subject);
    }

    @GetMapping("/Subjects")
    public List<Subject> fetchSubjectList() {
        return subjectService.fetchSubjectList();
    }

    @GetMapping("/Subjects/id/{id}")
    public Subject fetchSubjectById(@PathVariable("id") Long subjectId) {
        return subjectService.fetchSubjectById(subjectId);
    }

    @PutMapping("/Subject/id/{id}")
    public Subject updateSubjectById(@PathVariable("id") Long subjectId,
                                     @RequestBody Subject subject) {
        return subjectService.updateSubjectById(subjectId, subject);
    }

    @DeleteMapping("/Subject/{id}")
    public String deleteSubjectById(@PathVariable("id") Long subjectId) {
        subjectService.deleteSubjectByID(subjectId);
        return "Subject " + subjectId + " has been Deleted Successfully";
    }
}