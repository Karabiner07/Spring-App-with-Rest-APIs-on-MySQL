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
public class Subject {

    @Id
    private Long subjectId;
    private String subjectName;

//    @ManyToMany
//    @JoinColumn(
//
//    )
//    private Department department;

}


