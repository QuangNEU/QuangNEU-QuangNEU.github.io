package com.qlsv.qlsv.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qlsv.qlsv.dto.accountDTO;
import com.qlsv.qlsv.payload.responseData;

import com.qlsv.qlsv.service.imp.LoginServiceImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {

 // @Qualifier("tenBean") dung de chi cai interface goi   
    @Autowired
    LoginServiceImp LoginServiceImp;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username ,@RequestParam String passwords){
        responseData responseData=new responseData();
        accountDTO accountDTO = LoginServiceImp.checkLogin2(username, passwords);
        if(accountDTO != null){
            responseData.setData(true);
            responseData.setData(LoginServiceImp.checkLogin2(username, passwords));
        }
        else{
            responseData.setData(false);
        }
        

        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    
}
