package com.qlsv.qlsv.dto;

import com.qlsv.qlsv.entity.course;
import com.qlsv.qlsv.entity.student;


public class gradeDTO {
    private int id;
    private float attendance_grade;
    private float midterm_grade;
    private float final_exam_grade;
    private student student;
    private course course1;
    private String subject_name;
    private int credits;
    private float getDTB =0.1f*attendance_grade+0.4f*midterm_grade+0.5f*final_exam_grade;
    private float getDTB4;
    public float getGetDTB4() {
        return getDTB4;
    }
    public void setGetDTB4(float getDTB4) {
        this.getDTB4 = getDTB4;
    }
    public void setGetDTB(float getDTB) {
        this.getDTB = getDTB;
    }
    public float getGetDTB() {
        return getDTB;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public String getSubject_name() {
        return subject_name;
    }
    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
    public float getAttendance_grade() {
        return attendance_grade;
    }public course getCourse1() {
        return course1;
    }public float getFinal_exam_grade() {
        return final_exam_grade;
    }public int getId() {
        return id;
    }public float getMidterm_grade() {
        return midterm_grade;
    }public student getStudent() {
        return student;
    }
    public void setCourse1(course course1) {
        this.course1 = course1;
    }public void setAttendance_grade(float attendance_grade) {
        this.attendance_grade = attendance_grade;
    }public void setFinal_exam_grade(float final_exam_grade) {
        this.final_exam_grade = final_exam_grade;
    }public void setId(int id) {
        this.id = id;
    }public void setMidterm_grade(float midterm_grade) {
        this.midterm_grade = midterm_grade;
    }public void setStudent(student student) {
        this.student = student;
    }
}
