package com.admin.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.admin.DemoApplicationTests;
import com.admin.domain.Item;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class ItemRepositoryTest extends DemoApplicationTests{

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item=new Item();
        item.setStatus("UNREGISTERED");
        item.setName("삼성 노트북");
        item.setTitle("삼성 노트북 A100");
        item.setPrice(1000000);
        item.setContent("2019년형 삼성 노트북");
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setPartnerId(1L);

        Item newItem=itemRepository.save(item);
        
        Assert.assertNotNull(newItem);       

    }

    @Test
    public void read(){
        Long id=1L;

        Optional<Item> item=itemRepository.findById(id);

       Assert.assertTrue(item.isPresent());

    }
    @Test
    public void update(){

    }
    @Test
    public void delete(){

    }

}