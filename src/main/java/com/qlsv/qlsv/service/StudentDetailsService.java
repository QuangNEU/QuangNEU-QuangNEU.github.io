package com.qlsv.qlsv.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import com.qlsv.qlsv.dto.StudentDTO;
import com.qlsv.qlsv.entity.student;
import com.qlsv.qlsv.repository.studentRepository;
import com.qlsv.qlsv.service.imp.GetStudentDetailsImp;



@Service
public class StudentDetailsService implements GetStudentDetailsImp {
    @Autowired
    studentRepository studentRepository;

    @Override
    public List<StudentDTO> getStudentDetail(){
        List<student> listStudents = studentRepository.findAll();
        List<StudentDTO> listStudentsDTO = new ArrayList<>() ;
        for (student student : listStudents) {
            StudentDTO studentDTO =new StudentDTO();
            studentDTO.setMsv(student.getMsv());
            studentDTO.setDob(student.getDob());
            studentDTO.setFullname(student.getFullname());
            studentDTO.setGender(student.getGender());
            studentDTO.setSpecialized_class(student.getSpecializedclass());
            studentDTO.setStudent_email(student.getStudent_email());
        }
        return listStudentsDTO;
    }
    @Override
    public StudentDTO getStudent(int studentId){
        Optional <student> student = studentRepository.findById(studentId);
        StudentDTO studentDTO= new StudentDTO();
        if (student.isPresent()){
            studentDTO.setDob(student.get().getDob());
            studentDTO.setMsv(student.get().getMsv());
            studentDTO.setFullname(student.get().getFullname());
            studentDTO.setGender(student.get().getGender());
            studentDTO.setSpecialized_class(student.get().getSpecializedclass());
            studentDTO.setStudent_email(student.get().getStudent_email());
            studentDTO.setCccd(student.get().getCccd());
            studentDTO.setDistrict(student.get().getDistrict());
        }
        return studentDTO;
    }
    
}
