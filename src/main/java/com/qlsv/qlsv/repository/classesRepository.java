package com.qlsv.qlsv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.qlsv.qlsv.entity.classes;


@Repository
public interface classesRepository extends JpaRepository<classes,Integer> {
    List<classes> findByCourse_Id(int course_id);
}
