package com.universitymanagement.project.service;

import com.universitymanagement.project.entitiy.Department;
import com.universitymanagement.project.entitiy.Teacher;
import com.universitymanagement.project.repository.DepartmentRepository;
import com.universitymanagement.project.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
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
    public Teacher fetchTeacherByEmailId(String emailId) {
        return teacherRepository.findByEmailId(emailId);
    }

    @Override
    public Teacher getHodByDepartment(Long departmentId) {
        Department DEP =  departmentRepository.findById(departmentId).get();

        Teacher t = DEP.getTeacher();

        return teacherRepository.findById(t.getTeacherId()).get();
    }

    @Override
    public Teacher updateTeacherByTeacherId(Long teacherId, Teacher teacher) {

        Department DEP = teacher.getDepartment();

        Teacher t = teacherRepository.findById(teacherId).get();

        if(teacherRepository.findById(teacherId).isEmpty()){
            teacherRepository.save(teacher);
        }
        if(teacherRepository.findById(teacherId).isPresent()){

            if(Objects.nonNull(teacher.getTeacherId())){
                t.setTeacherId(teacher.getTeacherId());
            }
            if(Objects.nonNull(teacher.getTeacherName()) && !"".equalsIgnoreCase(teacher.getTeacherName())) {
                t.setTeacherName(teacher.getTeacherName());
            }
            if(Objects.nonNull(teacher.getTeacherSalary())) {
                t.setTeacherSalary(teacher.getTeacherSalary());
            }

            if(departmentRepository.findById(DEP.getDepartmentId()).isEmpty()){
                t.setDepartment(DEP);
            }
            if(departmentRepository.findById(DEP.getDepartmentId()).isPresent()){
                if(Objects.nonNull(teacher.getDepartment())){
                    t.setDepartment(DEP);
                }
            }
        }
        return teacherRepository.save(t);
    }


    @Override
    public void deleteTeacherById(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
