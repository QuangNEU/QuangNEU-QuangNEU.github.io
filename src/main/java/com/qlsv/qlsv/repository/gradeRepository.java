package com.qlsv.qlsv.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.qlsv.qlsv.entity.grade;

@Repository
public interface gradeRepository extends JpaRepository<grade, Integer> {
    List<grade> findByStudent_Msv (int studentId);
} 


