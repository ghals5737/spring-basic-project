package com.admin.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import com.admin.DemoApplicationTests;
import com.admin.domain.Item;
import com.admin.domain.User;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends DemoApplicationTests{

    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void create(){
          //String sql = insert into user (%s,%d....) value (account,.email....);
          String account="Test01";
          String password="Test01";
          String status="REGISTERED";
          String email="Test01@gmail.com";
          String phoneNumber="010-1111-2222";
          LocalDateTime registeredAt=LocalDateTime.now();
          LocalDateTime createdAt=LocalDateTime.now();
          String createdBy="AdminServer";

          User user=new User();
          user.setAccount(account);
          user.setPassword(password);
          user.setStatus(status);
          user.setEmail(email);
          user.setPhoneNumber(phoneNumber);
          user.setRegisteredAt(registeredAt);
          user.setCreatedAt(createdAt);
          user.setCreatedBy(createdBy);

          User newUser=userRepository.save(user);
          Assert.assertNotNull(user);

    }
    @Test
    @Transactional
    public void read(){
        //Optional<User> user=userRepository.findByAccount("TestUser03");

        /*user.ifPresent(selectUser->{
            selectUser.getOrderDetailList().stream().forEach(detail->{
                Item itme=detail.getItem();
                System.out.println(itme);
            });
        });*/
       User user =userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
       Assert.assertNotNull(user);

    }
    @Test
    public void update(){

        Optional<User> user=userRepository.findById(2L);

        user.ifPresent(selectUser->{
            selectUser.setAccount("ppppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    
    }

    @Test
    @Transactional //테스트를 완료후 다시 롤백
    public void delete(){
        Optional<User> user=userRepository.findById(1L);

        Assert.assertTrue(user.isPresent()); //true

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });
        
        Optional<User> deleteUser=userRepository.findById(2L);

        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : "+deleteUser.get());
        }else{
            System.out.println("데이터 삭제 데이터 없음");
        }
       
    

    }

}