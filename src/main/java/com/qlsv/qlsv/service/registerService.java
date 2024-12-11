package com.qlsv.qlsv.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlsv.qlsv.dto.classesDTO;
import com.qlsv.qlsv.dto.courseDTO;
import com.qlsv.qlsv.entity.classes;
import com.qlsv.qlsv.entity.enrollment;
import com.qlsv.qlsv.entity.grade;
import com.qlsv.qlsv.entity.student;
import com.qlsv.qlsv.repository.classesRepository;
import com.qlsv.qlsv.repository.courseRepository;
import com.qlsv.qlsv.repository.gradeRepository;
import com.qlsv.qlsv.repository.registerRepository;
import com.qlsv.qlsv.repository.studentRepository;
import com.qlsv.qlsv.service.imp.registerImp;

@Service
public class registerService implements registerImp{
    @Autowired
    classesRepository classesRepository;
    @Autowired
    courseRepository courseRepository;
    @Autowired
    registerRepository registerRepository;
    @Autowired
    gradeRepository gradeRepository;
    @Autowired
    studentRepository studentRepository;
    @Override
public List<courseDTO> getClasses(int studentId) {
    List<classes> listClasses = classesRepository.findAll();
    List<grade> listCourses = gradeRepository.findByStudent_Msv(studentId);
    List<enrollment> listEnrollments = registerRepository.findByStudent_Msv(studentId);
    List<courseDTO> availableClasses = new ArrayList<>();

    // Lặp qua tất cả các lớp học
    // Tạo danh sách các course_id đã hoàn thành
Set<Integer> completedCourseIds = listCourses.stream()
.filter(course -> course.getCourse() != null)
.map(course -> course.getCourse().getCourse_id())
.collect(Collectors.toSet());

// Tạo danh sách các course_id đã đăng ký
Set<Integer> enrolledCourseIds = listEnrollments.stream()
.filter(enrollment -> enrollment.getClasses1() != null && enrollment.getClasses1().getCourse() != null)
.map(enrollment -> enrollment.getClasses1().getCourse().getCourse_id())
.collect(Collectors.toSet());

for (classes singleClass : listClasses) {
if (singleClass.getCourse() == null) {
    continue;  // Bỏ qua nếu course là null
}

int courseId = singleClass.getCourse().getCourse_id();
boolean canEnroll = true;

// Kiểm tra nếu môn học đã hoàn thành hoặc đã đăng ký
if (completedCourseIds.contains(courseId) || enrolledCourseIds.contains(courseId)) {
    canEnroll = false;
} else {
    // Kiểm tra xung đột lịch học
    for (enrollment enrolled : listEnrollments) {
        if (singleClass.getDay_of_the_week().equals(enrolled.getClasses1().getDay_of_the_week()) &&
            singleClass.getStart_time().equals(enrolled.getClasses1().getStart_time()) &&
            courseId == enrolled.getClasses1().getCourse().getCourse_id()) {
            canEnroll = false;
            break;
        }
    }
}

// Nếu không có xung đột và chưa hoàn thành hoặc đăng ký, thêm vào danh sách có thể đăng ký
if (canEnroll) {
    courseDTO classDTO = new courseDTO();
    classDTO.setSubjectName(singleClass.getCourse().getSubjectName());
    classDTO.setCourse_id(courseId);
    classDTO.setCredits(singleClass.getCourse().getCredits());

    // Lấy danh sách các lớp học cho course hiện tại
    List<classes> listClassesForCourse = classesRepository.findByCourse_Id(courseId);
    List<classesDTO> listClassesDTOs = new ArrayList<>();
    for (classes classItem : listClassesForCourse) {
        if (classItem.getCourse() == null) {
            continue;
        }

        classesDTO classDTOItem = new classesDTO();
        classDTOItem.setId(classItem.getId());
        classDTOItem.setDay_of_the_week(classItem.getDay_of_the_week());
        classDTOItem.setStart_time(classItem.getStart_time());
        classDTOItem.setEnd_time(classItem.getEnd_time());
        classDTOItem.setRoom(classItem.getRoom());
        listClassesDTOs.add(classDTOItem);
    }

    classDTO.setListClasses(listClassesDTOs);
    availableClasses.add(classDTO);
}
}

return availableClasses;
}

@Override
public boolean registerCourse(int studentId, int classId) {
    try {
        // Kiểm tra và lấy sinh viên từ cơ sở dữ liệu
        student student = studentRepository.findByMsv(studentId).orElse(null);
        if (student == null) {
            // Nếu không tìm thấy sinh viên, không thực hiện đăng ký
            System.out.println("Sinh viên với ID " + studentId + " không tồn tại!"); // Debug
            return false; // Hoặc có thể ném ngoại lệ nếu cần thiết
        }

        // Kiểm tra và lấy lớp học từ cơ sở dữ liệu
        classes classes = classesRepository.findById(classId).orElse(null);
        if (classes == null) {
            // Nếu không tìm thấy lớp học, không thực hiện đăng ký
            System.out.println("Lớp học không tồn tại!");
            return false; // Hoặc có thể ném ngoại lệ nếu cần thiết
        }

        // Kiểm tra nếu sinh viên đã đăng ký lớp này
        enrollment existingEnrollment = registerRepository.findByStudent_MsvAndClasses1_Id(studentId, classId);
        if (existingEnrollment != null) {
            // Sinh viên đã đăng ký lớp này rồi
            System.out.println("Sinh viên đã đăng ký lớp này.");
            return false;
        }

        // Tạo mới đối tượng enrollment và lưu vào cơ sở dữ liệu
        enrollment enrollment = new enrollment();
        enrollment.setStudent(student);
        enrollment.setClasses1(classes);
        registerRepository.save(enrollment);

        return true; // Đăng ký thành công
    } catch (Exception e) {
        e.printStackTrace();
        return false; // Đăng ký thất bại
    }
}
}




