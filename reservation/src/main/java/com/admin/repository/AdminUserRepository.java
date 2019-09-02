package com.admin.repository;

import com.admin.domain.AdminUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser,Long>{

}