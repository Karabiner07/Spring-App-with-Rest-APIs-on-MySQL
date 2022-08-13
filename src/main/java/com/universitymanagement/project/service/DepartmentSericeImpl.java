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
public class DepartmentSericeImpl implements DepartmentSerice{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public Department getDepartmentByDepartmentCode(String departmentCode) {
        return departmentRepository.getDepartmentByDepartmentCode(departmentCode);
    }

    @Override
    public Department getDepartmentByHodId(Long hodId) {
        return departmentRepository.getDepartmentByHodId(hodId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {

        Teacher teacher = department.getTeacher();

        Department DEP = departmentRepository.findById(departmentId).get();

        if(departmentRepository.findById(departmentId).isEmpty()){
            departmentRepository.save(department);
        }

        if(departmentRepository.findById(departmentId).isPresent()){

            if(Objects.nonNull(department.getDepartmentId())) {
                DEP.setDepartmentId(department.getDepartmentId());
            }

            if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
                DEP.setDepartmentName(department.getDepartmentName());
            }

            if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
                DEP.setDepartmentCode(department.getDepartmentCode());
            }

            if(teacherRepository.findById(teacher.getTeacherId()).isEmpty()){
                DEP.setTeacher(teacher);
            }

            if(teacherRepository.findById(teacher.getTeacherId()).isPresent()){
                if(Objects.nonNull(department.getTeacher())){
                    DEP.setTeacher(teacher);
                }
            }
        }
        return departmentRepository.save(DEP);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

}
