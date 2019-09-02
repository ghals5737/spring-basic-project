package com.admin.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.admin.DemoApplicationTests;
import com.admin.domain.Category;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryRepositoryTest extends DemoApplicationTests{

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        String type="COMPUTER";
        String title ="컴퓨터";
        LocalDateTime createdAt=LocalDateTime.now();
        String createdBy="AdminServer";

        Category category=new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory=categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(), type);
        Assert.assertEquals(newCategory.getTitle(), title);

    }

    @Test
    public void read(){
        Optional<Category> optionalCategory=categoryRepository.findByType("COMPUTER");

        optionalCategory.ifPresent(c->{
            System.out.println(c.getId());
            System.out.println(c.getCreatedAt());
        });

    }

}