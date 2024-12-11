package com.qlsv.qlsv.repository;

import java.util.List;
import java.util.Optional;
import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlsv.qlsv.entity.student;

@Repository
public interface studentRepository extends JpaRepository<student,Integer> {
    List<student> findByMsvAndFullnameAndDobAndGenderAndSpecializedclass(int msv, String fullname, Date dob, String gender, String specializedclass);
    Optional<student> findByMsv(int student_id);
}
