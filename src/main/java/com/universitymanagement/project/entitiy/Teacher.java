package com.universitymanagement.project.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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


    @OneToOne(
            fetch = FetchType.EAGER,
            //cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "departmentId",
            nullable = false
    )
    private Department department;




}
