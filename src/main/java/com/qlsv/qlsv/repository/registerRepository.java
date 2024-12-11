package com.qlsv.qlsv.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlsv.qlsv.entity.enrollment;

@Repository
public interface registerRepository extends JpaRepository<enrollment,Integer>{
    List<enrollment> findByStudent_Msv(int studentId);
    enrollment findByStudent_MsvAndClasses1_Id(int studentId,int classId);
    
}
