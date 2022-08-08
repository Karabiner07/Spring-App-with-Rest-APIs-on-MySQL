package com.universitymanagement.project.service;


import com.universitymanagement.project.entitiy.Subject;

import java.util.List;

public interface SubjectService {

    public Subject saveSubject(Subject subject);

    public List<com.universitymanagement.project.entitiy.Subject> fetchSubjectList();

    public com.universitymanagement.project.entitiy.Subject fetchSubjectById(Long subjectId);

    public Subject updateSubjectById(Long subjectId, Subject subject);

    public void deleteSubjectByID(Long subjectId);
}
