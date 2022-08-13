package com.universitymanagement.project.service;

import com.universitymanagement.project.entitiy.Teacher;

import java.util.List;

public interface TeacherService {

   public Teacher saveTeacher(Teacher teacher);

   public List<Teacher> fetchTeacherList();

   public Teacher fetchTeacherById(Long teacherId);

   public Teacher fetchTeacherByEmailId(String emailId);

   public Teacher getHodByDepartment(Long departmentId);

   public Teacher updateTeacherByTeacherId(Long teacherId, Teacher teacher);

   public void deleteTeacherById(Long teacherId);
}
