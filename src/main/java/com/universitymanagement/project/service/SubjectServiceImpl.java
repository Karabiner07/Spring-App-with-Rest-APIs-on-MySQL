package com.universitymanagement.project.service;

import com.universitymanagement.project.entitiy.Department;
import com.universitymanagement.project.entitiy.Subject;
import com.universitymanagement.project.repository.DepartmentRepository;
import com.universitymanagement.project.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<com.universitymanagement.project.entitiy.Subject> fetchSubjectList() {
        return subjectRepository.findAll();
    }

    @Override
    public com.universitymanagement.project.entitiy.Subject fetchSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).get();
    }

    @Override
    public Subject updateSubjectById(Long subjectId, Subject subject) {

        Subject subj = subjectRepository.findById(subjectId).get();

        if(subjectRepository.findById(subjectId).isEmpty()){
            subjectRepository.save(subject);
        }
        if(subjectRepository.findById(subjectId).isPresent()){
            if(Objects.nonNull(subject.getSubjectId())){
                subj.setSubjectId(subject.getSubjectId());
            }
            if(Objects.nonNull(subject.getSubjectName()) && !"".equalsIgnoreCase(subject.getSubjectName())) {
                subj.setSubjectName(subject.getSubjectName());
            }
            if(Objects.nonNull(subject.getDepartmentList())){
                subj.setDepartmentList(subject.getDepartmentList());
            }
        }
    return subjectRepository.save(subj);
    }

    @Override
    public Subject assignDepartmentToSubject(Long subjectId, Long departmentId) {

        Subject subject = subjectRepository.findById(subjectId).get();
        Department department = departmentRepository.findById(departmentId).get();
        List<Department> departmentList = subject.getDepartmentList();

        departmentList.add(department);
        subject.setDepartmentList(departmentList);
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubjectByID(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }


}
