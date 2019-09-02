package com.admin.repository;

import java.util.Optional;

import com.admin.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
      
    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
}