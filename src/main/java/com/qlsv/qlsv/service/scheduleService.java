package com.qlsv.qlsv.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlsv.qlsv.dto.scheduleDTO;
import com.qlsv.qlsv.entity.enrollment;

import com.qlsv.qlsv.repository.scheduleRepository;
import com.qlsv.qlsv.service.imp.scheduleImp;

@Service
public class scheduleService implements scheduleImp {
    @Autowired
    scheduleRepository scheduleRepository;

    @Override
    public List<scheduleDTO> getschedule(int studentId) {
        List<enrollment> listRegisted = scheduleRepository.findByStudent_Msv(studentId);
        List<scheduleDTO> scheduleDTOs = new ArrayList<>();
        for (enrollment enrollment : listRegisted) {
            scheduleDTO scheduleDTO = new scheduleDTO();
            scheduleDTO.setThu(enrollment.getClasses1().getDay_of_the_week());
            scheduleDTO.setS_time(enrollment.getClasses1().getStart_time());
            scheduleDTO.setE_time(enrollment.getClasses1().getEnd_time());
            scheduleDTO.setRoom(enrollment.getClasses1().getRoom());
            scheduleDTO.setSubj_name(enrollment.getClasses1().getCourse().getSubjectName());
            scheduleDTO.setStudent_id(studentId);
            scheduleDTO.setClassId(enrollment.getClasses1().getId());
            scheduleDTOs.add(scheduleDTO);
        }

        return scheduleDTOs;
    }

    @Override
    public boolean cancelCourseEnrollment(int studentId, int courseId) {
        if (studentId <= 0 || courseId <= 0) {
            // Kiểm tra hợp lệ
            return false;
        }

        Optional<enrollment> enrollment = scheduleRepository.findByStudent_MsvAndClasses1_Id(studentId, courseId);

        if (enrollment.isPresent()) {
            // Xóa bản ghi nếu tìm thấy
            scheduleRepository.delete(enrollment.get());
            return true;
        }
        return false;
    }

}
