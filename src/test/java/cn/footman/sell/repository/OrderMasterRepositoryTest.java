package cn.footman.sell.repository;

import cn.footman.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author kokio
 * @create 2019-02-26 21:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("5453");
        orderMaster.setBuyerAddress("everywhere");
        orderMaster.setBuyerName("tom");
        orderMaster.setBuyerPhone("13456789023");
        orderMaster.setBuyerOpenid("999999");
        orderMaster.setOrderAmount(new BigDecimal(7.77));

        OrderMaster save = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(save);
    }


    @Test
    public void findByBuyerOpenid(){
        PageRequest request = new PageRequest(0,3);
        Page<OrderMaster> result = orderMasterRepository.findByBuyerOpenid("999999", request);
        Assert.assertNotEquals(0,result.getTotalElements());
//        System.out.println(result.getTotalElements());
    }


}