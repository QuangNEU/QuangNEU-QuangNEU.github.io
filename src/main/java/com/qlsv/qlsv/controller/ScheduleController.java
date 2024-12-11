package com.qlsv.qlsv.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qlsv.qlsv.payload.responseData;

import com.qlsv.qlsv.service.imp.scheduleImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    scheduleImp scheduleImp;

    @GetMapping("/detail")
    public ResponseEntity<?> schedule(@RequestParam int id) {
        responseData responseData = new responseData();
        responseData.setData(scheduleImp.getschedule(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/cancel")
    public ResponseEntity<?> cancel(@RequestBody Map<String, Integer> requestData) {
        Integer studentId = requestData.get("studentId");
        Integer courseId = requestData.get("courseId");

        if (studentId == null || courseId == null) {
            return new ResponseEntity<>("Thiếu studentId hoặc courseId", HttpStatus.BAD_REQUEST);
        }

        System.out.println("Student ID: " + studentId);
        System.out.println("Course ID: " + courseId);

        responseData responseData = new responseData();
        boolean isCancelled = scheduleImp.cancelCourseEnrollment(studentId, courseId);

        if (isCancelled) {
            responseData.setData("Hủy tín thành công.");
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } else {
            responseData.setData("Không thể hủy môn học.");
            return new ResponseEntity<>(responseData, HttpStatus.BAD_REQUEST);
        }
    }

}
