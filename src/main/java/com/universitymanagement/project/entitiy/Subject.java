package com.universitymanagement.project.entitiy;

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
public class Subject {

    @Id
    private Long subjectId;
    private String subjectName;

    @ManyToMany
    @JoinTable(
        name = "department_subject_map",
        joinColumns = @JoinColumn(
                name = "subject_id",
                referencedColumnName = "subjectId"
        ),
        inverseJoinColumns = @JoinColumn(
                name = "department_id",
                referencedColumnName = "departmentId"
        )
    )
    private List<Department> departmentList;

}


