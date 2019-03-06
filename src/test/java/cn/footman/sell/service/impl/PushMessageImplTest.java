package cn.footman.sell.service.impl;

import cn.footman.sell.dto.OrderDTO;
import cn.footman.sell.service.OrderService;
import cn.footman.sell.service.PushMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author kokio
 * @create 2019-03-05 18:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageImplTest {

    @Autowired
    private PushMessage pushMessage;
    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1551277205898592876");
        pushMessage.orderStatus(orderDTO);
    }
}