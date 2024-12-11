package com.qlsv.qlsv.entity;

import java.sql.Date;
import java.util.Set;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "student")
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int msv;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "dob")
    private Date dob;

    @Column(name ="student_email")
    private String student_email;

    @Column(name = "gender")
    private String gender;

    @Column(name= "specialized_class")
    private String specializedclass;

    @Column(name= "district")
    private String district;

    @Column(name= "cccd")
    private String cccd;

    @OneToOne(mappedBy = "student")
    private account account;

    @OneToMany(mappedBy = "student")
    private Set<enrollment> ListEnrollment;
    public Set<enrollment> getListEnrollment() {
        return ListEnrollment;
    }

    @OneToMany(mappedBy = "student")
    private Set<grade> ListGrade;
    public Set<grade> getListGrade() {
        return ListGrade;
    }
    
    public String getCccd() {
        return cccd;
    }
    public String getDistrict() {
        return district;
    }
    public void setCccd(String cccd) {
        this.cccd = cccd;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getStudent_email() {
        return student_email;
    }
    public Date getDob() {
        return dob;
    }
    public String getFullname() {
        return fullname;
    }
    public int getMsv() {
        return msv;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public account getAccount() {
        return account;
    }
    public void setAccount(account account) {
        this.account = account;
    }
    public void setListEnrollment(Set<enrollment> listEnrollment) {
        ListEnrollment = listEnrollment;
    }
    public void setListGrade(Set<grade> listGrade) {
        ListGrade = listGrade;
    }
    public void setMsv(int msv) {
        this.msv = msv;
    }
    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }
    public String getGender() {
        return gender;
    }
    public String getSpecializedclass() {
        return specializedclass;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setSpecializedclass(String specializedcclass) {
        this.specializedclass = specializedcclass;
    }
}
