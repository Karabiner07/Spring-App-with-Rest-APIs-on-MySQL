package com.universitymanagement.project.repository;

import com.universitymanagement.project.entitiy.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("select d from Department d where d.departmentCode = ?1")
    Department getDepartmentByDepartmentCode(String departmentCode);

    @Query(
            value = "select * from department d where d.hod_id = ?1",
            nativeQuery = true
    )
    Department getDepartmentByHodId(Long HodId);
}

