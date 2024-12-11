package com.qlsv.qlsv.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlsv.qlsv.entity.account;

@Repository
public interface accountRepository extends JpaRepository<account,Integer> {
    Optional<account> findByUsernameAndPasswords(String username, String passwords);
    
    account findByUsername(String username);
}
