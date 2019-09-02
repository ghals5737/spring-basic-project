package com.admin.repository;

import java.time.LocalDateTime;

import com.admin.DemoApplicationTests;
import com.admin.domain.OrderDetail;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDetailRepositoryTest extends DemoApplicationTests{

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
          OrderDetail orderDetail=new OrderDetail();

          orderDetail.setOrderAt(LocalDateTime.now());
          //orderDetail.setUserId(5L);
          //orderDetail.setItemId(1L);

          OrderDetail newOrderDetail=orderDetailRepository.save(orderDetail);

          Assert.assertNotNull(newOrderDetail);
    }

}