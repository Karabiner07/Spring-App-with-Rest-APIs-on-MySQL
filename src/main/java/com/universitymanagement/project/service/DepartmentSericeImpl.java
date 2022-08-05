package com.universitymanagement.project.service;

import com.universitymanagement.project.entitiy.Department;
import com.universitymanagement.project.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;


@Service
public class DepartmentSericeImpl implements DepartmentSerice{

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
    public Department fetchDepartmentByCode(Long departmentCode) {
        return departmentRepository.findByDepartmentCode(departmentCode);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {

        if(departmentRepository.findById(departmentId).isEmpty()){
            departmentRepository.save(department);
        }

        if(departmentRepository.findById(departmentId).isPresent()){
            Department DEP = departmentRepository.findById(departmentId).get();

            if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
                DEP.setDepartmentName(department.getDepartmentName());
            }

            if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
                DEP.setDepartmentCode(department.getDepartmentCode());
            }
            departmentRepository.save(DEP);
        }
        return department;
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

}
