package com.universitymanagement.project.repository;

import com.universitymanagement.project.entitiy.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentCode(Long departmentCode);
}
