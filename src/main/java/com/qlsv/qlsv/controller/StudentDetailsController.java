package com.qlsv.qlsv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qlsv.qlsv.payload.responseData;
import com.qlsv.qlsv.service.imp.GetStudentDetailsImp;


@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentDetailsController {
    @Autowired
    GetStudentDetailsImp getStudentDetailsImp;

    @GetMapping("/detail")
    public ResponseEntity<?> getStudentDetail(@RequestParam int id){
        responseData responseData=new responseData();
        responseData.setData(getStudentDetailsImp.getStudent(id));
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
}
