package cn.footman.sell.repository;

import cn.footman.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kokio
 * @create 2019-02-27 15:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailReposityTest {

    @Autowired
    private OrderDetailReposity orderDetailReposity;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345");
        orderDetail.setOrderId("545");
        orderDetail.setProductIcon("jjjjjgg.jgp");
        orderDetail.setProductId("12321");
        orderDetail.setProductName("good book");
        orderDetail.setProductPrice(new BigDecimal(9.92));
        orderDetail.setProductQuantity(1);

        OrderDetail save = orderDetailReposity.save(orderDetail);
        Assert.assertNotNull(save);
    }


    @Test
    public void findByOrderId(){

        List<OrderDetail> details = orderDetailReposity.findByOrderId("545");
        Assert.assertNotEquals(0,details.size());
    }

}