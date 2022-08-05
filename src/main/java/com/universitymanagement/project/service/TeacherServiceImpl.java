package com.universitymanagement.project.service;

import com.universitymanagement.project.entitiy.Department;
import com.universitymanagement.project.entitiy.Teacher;
import com.universitymanagement.project.repository.DepartmentRepository;
import com.universitymanagement.project.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private DepartmentRepository departmentRepository;



    @Override
    public Teacher saveTeacher(Teacher teacher) {

        Department tDEP = teacher.getDepartment();

        Teacher dupTeacher = new Teacher();


        if (departmentRepository.findById(tDEP.getDepartmentId()).isEmpty()) {
            teacherRepository.save(teacher);
        }
        if (departmentRepository.findById(tDEP.getDepartmentId()).isPresent()) {

            dupTeacher.setTeacherId(teacher.getTeacherId());
            dupTeacher.setTeacherName(teacher.getTeacherName());
            dupTeacher.setTeacherSalary(teacher.getTeacherSalary());
            dupTeacher.setEmailId(teacher.getEmailId());

            dupTeacher.setDepartment(departmentRepository.findById(tDEP.getDepartmentId()).get());

            teacherRepository.save(dupTeacher);
        }
        return teacher;
    }

    @Override
    public List<Teacher> fetchTeacherList() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher fetchTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId).get();
    }

    @Override
    public void deleteTeacherById(Long teacherId) {

        teacherRepository.deleteById(teacherId);
    }


}
