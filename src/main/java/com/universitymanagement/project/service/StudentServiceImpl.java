package com.universitymanagement.project.service;

import com.universitymanagement.project.entitiy.Department;
import com.universitymanagement.project.entitiy.Gaurdian;
import com.universitymanagement.project.entitiy.Student;
import com.universitymanagement.project.repository.DepartmentRepository;
import com.universitymanagement.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudentById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student fetchStudentByEmailId(String emailId) {
        return studentRepository.findByEmailId(emailId);
    }

    @Override
    public Student updateStudentById(Long studentId, Student student) {

        Department DEP = student.getDepartment();

        Gaurdian GAR = student.getGaurdian();

        Student s = studentRepository.findById(studentId).get();


        if(studentRepository.findById(studentId).isEmpty()) {
            studentRepository.save(student);
        }
        if(studentRepository.findById(studentId).isPresent()){
            if(Objects.nonNull(student.getEmailId()) &&
                    !"".equalsIgnoreCase(student.getEmailId())) {
                s.setEmailId(student.getEmailId());
            }

            if(Objects.nonNull(student.getFirstName()) &&
                    !"".equalsIgnoreCase(student.getFirstName())) {
                s.setFirstName(student.getFirstName());
            }

            if(Objects.nonNull(student.getLastName()) &&
                    !"".equalsIgnoreCase(student.getLastName())) {
                s.setLastName(student.getLastName());
            }

            if(Objects.nonNull(student.getGaurdian())){
                s.setGaurdian(GAR);
            }
            if(Objects.nonNull(student.getDepartment())){
                if(departmentRepository.findById(DEP.getDepartmentId()).isPresent()){
                    s.setDepartment(DEP);
                }
            }
        }
        return studentRepository.save(s);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
