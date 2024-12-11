package com.qlsv.qlsv.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlsv.qlsv.entity.enrollment;

@Repository
public interface scheduleRepository extends JpaRepository<enrollment,Integer>{
    Optional <enrollment>findByStudent_MsvAndClasses1_Id(int studentId,int classId);
List<enrollment> findByStudent_Msv(int studentId);
}
