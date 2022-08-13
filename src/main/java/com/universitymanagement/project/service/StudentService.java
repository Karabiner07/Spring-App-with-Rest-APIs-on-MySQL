package com.universitymanagement.project.service;

import com.universitymanagement.project.entitiy.Student;

import java.util.List;

public interface StudentService {
   public Student saveStudent(Student student);

   public List<Student> fetchStudentList();

   public Student fetchStudentById(Long studentId);

   public Student fetchStudentByEmailId(String emailId);

   public Student updateStudentById(Long studentId, Student student);

   public void deleteStudentById(Long studentId);
}
