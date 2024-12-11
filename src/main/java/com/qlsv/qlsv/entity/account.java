package com.qlsv.qlsv.entity;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "account")
public class account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "passwords")
    private String passwords;

    @OneToOne
    @JoinColumn(name = "student_id")
    private student student;
    
    public int getId() {
        return id;
    }
    public String getPasswords() {
        return passwords;
    }
    public student getStudent() {
        return student;
    }
    public void setStudent(student student) {
        this.student = student;
    }
    public String getUsername() {
        return username;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
}
