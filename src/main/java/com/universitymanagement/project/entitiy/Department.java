package com.universitymanagement.project.entitiy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
    private Long departmentId;
    private String departmentName;
    private String departmentCode;

    @OneToOne
    @JoinColumn(
            name = "hod_id",
            referencedColumnName = "teacherId"
    )
    @JsonIgnoreProperties("department")
    @JsonIncludeProperties("teacherId")
    @JsonBackReference
    private Teacher teacher;

    @JsonIgnore
    @ManyToMany(mappedBy = "departmentList")
    private List<Subject> subjectList;

}
