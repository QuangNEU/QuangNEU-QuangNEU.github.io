package com.qlsv.qlsv.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlsv.qlsv.entity.course;

@Repository
public interface courseRepository extends JpaRepository<course,Integer> {
    
}
