package com.universitymanagement.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.universitymanagement.project.entitiy.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {


}
