package com.universitymanagement.project.service;

import com.universitymanagement.project.entitiy.Teacher;

import java.util.List;

public interface TeacherService {

   public Teacher saveTeacher(Teacher teacher);

   public List<Teacher> fetchTeacherList();

   public Teacher fetchTeacherById(Long teacherId);

   public void deleteTeacherById(Long teacherId);
}
