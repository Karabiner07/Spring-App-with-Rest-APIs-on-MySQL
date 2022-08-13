package com.universitymanagement.project.controller;

import com.universitymanagement.project.entitiy.Department;
import com.universitymanagement.project.service.DepartmentSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentSerice departmentSerice;

    @PostMapping("/Departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentSerice.saveDepartment(department);
    }

    @GetMapping("/Departments")
    public List<Department> fetchDepartmentList() {
        return departmentSerice.fetchDepartmentList();
    }

    @GetMapping("/Department/Id/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentSerice.fetchDepartmentById(departmentId);
    }

    @GetMapping("/Department/Code/{code}")
    public Department getDepartmentByDepartmentCode(@PathVariable("code") String departmentCode){
        return departmentSerice.getDepartmentByDepartmentCode(departmentCode);
    }

    @GetMapping("/Department/HodId/{hodId}")
    public Department getDepartmentByHodId(@PathVariable("hodId") Long HodId){
        return  departmentSerice.getDepartmentByHodId(HodId);
    }

    @PutMapping("/Department/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,
                                           @RequestBody Department department) {
        return departmentSerice.updateDepartmentById(departmentId, department);
    }

    @DeleteMapping("/Department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentSerice.deleteDepartmentById(departmentId);
        return "Department " + departmentId + " deleted successfully";
    }
}
