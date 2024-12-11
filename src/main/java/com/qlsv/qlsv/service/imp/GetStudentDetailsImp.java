package com.qlsv.qlsv.service.imp;
import java.util.List;

import com.qlsv.qlsv.dto.StudentDTO;

public interface GetStudentDetailsImp {
    List<StudentDTO> getStudentDetail();
    StudentDTO getStudent(int studentId);
}