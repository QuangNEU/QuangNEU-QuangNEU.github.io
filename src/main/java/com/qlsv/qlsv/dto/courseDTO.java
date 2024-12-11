package com.qlsv.qlsv.dto;

import java.util.List;
import java.util.Set;

import com.qlsv.qlsv.entity.grade;

public class courseDTO {
    private int course_id;
    private String subjectName;
    private int credits;
    private Set<grade> ListGrade;
    private List<classesDTO> ListClasses;

  

    public Set<grade> getListGrade() {
        return ListGrade;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getCredits() {
        return credits;
    }

    public List<classesDTO> getListClasses() {
        return ListClasses;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setListClasses(List<classesDTO> listClasses) {
        ListClasses = listClasses;
    }

    public void setListGrade(Set<grade> listGrade) {
        ListGrade = listGrade;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
