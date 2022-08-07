package com.universitymanagement.project.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    private Long teacherId;
    private String teacherName;
    private Long teacherSalary;
    private String emailId;


    @ManyToOne(
            optional = false
    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "departmentId",
            nullable = false
    )
    @JsonIgnoreProperties("teacher")
    private Department department;




}
