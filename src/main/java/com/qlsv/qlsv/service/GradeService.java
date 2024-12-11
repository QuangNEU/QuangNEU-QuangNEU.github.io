package com.qlsv.qlsv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlsv.qlsv.dto.gradeDTO;
import com.qlsv.qlsv.entity.grade;
import com.qlsv.qlsv.repository.gradeRepository;
import com.qlsv.qlsv.service.imp.getGradeImp;

@Service
public class GradeService implements getGradeImp {
    @Autowired
    gradeRepository gradeRepository;

    @Override
    public List<gradeDTO> getStudenGrade(int studentId) {
        List <grade> ListGrade = gradeRepository.findByStudent_Msv(studentId);
        List <gradeDTO> ListGradeDTO = new ArrayList<>();
        for (grade grade : ListGrade) {
            gradeDTO gradeDTO =new gradeDTO();
            gradeDTO.setAttendance_grade(grade.getAttendance_grade());;
            gradeDTO.setMidterm_grade(grade.getMidterm_grade());
            gradeDTO.setFinal_exam_grade(grade.getFinal_exam_grade());
            gradeDTO.setId(grade.getId());
            gradeDTO.setSubject_name(grade.getCourse1().getSubjectName());
            gradeDTO.setCredits(grade.getCourse1().getCredits());
            gradeDTO.setGetDTB(grade.getDTB());
            float GradeScale4 = convertToScale4(grade.getDTB());
            gradeDTO.setGetDTB4(GradeScale4);
            ListGradeDTO.add(gradeDTO);
        }
        return ListGradeDTO;
    }
    private float convertToScale4(float averageGrade) {
        if (averageGrade >= 8.5) return  4.0f;
        if (averageGrade >= 8) return 3.5f;
        if (averageGrade >= 7) return 3.0f;
        if (averageGrade >= 6.5) return 2.5f;
        if (averageGrade >= 5.5) return 2.0f;
        if (averageGrade >= 5.0) return 1.5f;
        if (averageGrade >= 4.5) return 1.0f;
        else return 0.0f;
    }

}
