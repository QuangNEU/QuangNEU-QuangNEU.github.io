package com.qlsv.qlsv.service.imp;

import java.util.List;

import com.qlsv.qlsv.dto.courseDTO;




public interface registerImp {
    List<courseDTO> getClasses(int studentId);
    public boolean registerCourse(int studentId,int classId);
}

