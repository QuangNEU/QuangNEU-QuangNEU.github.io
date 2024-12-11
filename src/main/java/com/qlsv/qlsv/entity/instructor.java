package com.qlsv.qlsv.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "intructor")
public class instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name = "intructor_name")
    private String instructor_name;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "intructor_email")
    private String intructor_email;

    @OneToMany(mappedBy = "instructor")
    private Set<classes> ListClasses;
    
    public Set<classes> getListClasses() {
        return ListClasses;
    }


    public int getId() {
        return id;
    }
    public String getInstructor_name() {
        return instructor_name;
    }
    public String getIntructor_email() {
        return intructor_email;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }
    public void setIntructor_email(String intructor_email) {
        this.intructor_email = intructor_email;
    }
    public void setListClasses(Set<classes> listClasses) {
        ListClasses = listClasses;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    
}
