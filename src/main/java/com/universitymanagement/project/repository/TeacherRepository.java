package com.universitymanagement.project.repository;

import com.universitymanagement.project.entitiy.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    public Teacher findByEmailId(String emailId);

}
