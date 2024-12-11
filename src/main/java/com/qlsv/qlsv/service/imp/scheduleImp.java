package com.qlsv.qlsv.service.imp;

import java.util.List;


import com.qlsv.qlsv.dto.scheduleDTO;


public interface scheduleImp {
    List<scheduleDTO> getschedule(int studentId);
    public boolean cancelCourseEnrollment(int studentId, int classId);
}
