package com.universitymanagement.project.service;

import com.universitymanagement.project.entitiy.Department;

import java.util.List;

public interface DepartmentSerice {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);

    public Department getDepartmentByDepartmentCode(String departmentCode);

    public Department getDepartmentByHodId(Long hodId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public void deleteDepartmentById(Long departmentId);

}
