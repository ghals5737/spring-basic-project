package com.admin.repository;

import java.util.Optional;

import com.admin.domain.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>{
   
    Optional<Category> findByType(String type);
}