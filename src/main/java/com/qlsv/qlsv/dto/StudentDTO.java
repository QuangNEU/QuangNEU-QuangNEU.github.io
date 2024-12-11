package com.qlsv.qlsv.dto;


import java.sql.Date;
public class StudentDTO {
    private int msv;
    private String fullname;
    private Date dob;
    private String student_email;
    private String gender;
    private String specialized_class;
    private String district;
    private String cccd;
    public String getCccd() {
        return cccd;
    }public String getDistrict() {
        return district;
    }public void setCccd(String cccd) {
        this.cccd = cccd;
    }public void setDistrict(String district) {
        this.district = district;
    }
    public Date getDob() {
        return dob;
    }
    public String getFullname() {
        return fullname;
    }
    public String getGender() {
        return gender;
    }
    public int getMsv() {
        return msv;
    }
    public String getStudent_email() {
        return student_email;
    }
    public String getSpecialized_class() {
        return specialized_class;
    }
    public void setSpecialized_class(String specialized_class) {
        this.specialized_class = specialized_class;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setMsv(int msv) {
        this.msv = msv;
    }
    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }
}
