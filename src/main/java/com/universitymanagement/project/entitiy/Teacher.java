package com.universitymanagement.project.entitiy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
