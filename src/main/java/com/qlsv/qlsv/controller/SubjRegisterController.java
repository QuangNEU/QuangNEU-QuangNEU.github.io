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

import com.qlsv.qlsv.service.registerService;
import com.qlsv.qlsv.service.imp.getGradeImp;
import com.qlsv.qlsv.service.imp.registerImp;

@CrossOrigin("*")
@RequestMapping("/subject")
@RestController
public class SubjRegisterController {
    @Autowired
    getGradeImp getGradeImp;
    @Autowired
    registerImp registerImp;
    @Autowired
    registerService registerService;
    @GetMapping("/grade")
    public ResponseEntity<?> getScore(@RequestParam int id){
        responseData responseData = new responseData();
        responseData.setData(getGradeImp.getStudenGrade(id));
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    
    @GetMapping("/getlist")
    public ResponseEntity<?> getListAvailableSubj(@RequestParam int id){
        responseData responseData = new responseData();
        responseData.setData(registerImp.getClasses(id));
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    @PostMapping("/register")
public ResponseEntity<?> register(@RequestBody Map<String, Integer> requestData) {
    int studentId = requestData.get("studentId");
    int classId = requestData.get("classId");

    // Log để kiểm tra giá trị nhận được
    System.out.println("studentId nhận được từ yêu cầu: " + studentId);

    responseData responseData = new responseData();
    responseData.setData(registerImp.registerCourse(studentId, classId));
    return new ResponseEntity<>(responseData, HttpStatus.OK);
}
}
