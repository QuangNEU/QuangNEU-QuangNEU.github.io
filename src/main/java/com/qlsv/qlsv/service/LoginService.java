package com.qlsv.qlsv.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlsv.qlsv.dto.accountDTO;
import com.qlsv.qlsv.entity.account;
import com.qlsv.qlsv.repository.accountRepository;
import com.qlsv.qlsv.service.imp.LoginServiceImp;

@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    accountRepository accountRepository;
    @Override
public accountDTO checkLogin2(String username, String passwords) {
    // Sử dụng Optional để tránh NullPointerException nếu không tìm thấy account
    Optional<account> optionalAccount = accountRepository.findByUsernameAndPasswords(username, passwords);

    // Nếu tài khoản tồn tại, chuyển thông tin tài khoản thành accountDTO
    if (optionalAccount.isPresent()) {
        account account = optionalAccount.get();  // Lấy tài khoản từ Optional
        accountDTO accountDTO = new accountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setUsername(account.getUsername());
        accountDTO.setPasswords(account.getPasswords());

        // Kiểm tra xem 'account' có student không để tránh NullPointerException
        accountDTO.setStudentid(account.getStudent().getMsv()); // Đặt 'msv' của sinh viên
        

        return accountDTO; // Trả về accountDTO nếu đăng nhập thành công
    }

    return null;  // Nếu không tìm thấy tài khoản, trả về null
}

    

    
    
}