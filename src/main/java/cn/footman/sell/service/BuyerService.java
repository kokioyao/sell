package cn.footman.sell.service;

import cn.footman.sell.dto.OrderDTO;

/**
 * 买家
 * @author kokio
 * @create 2019-03-01 12:38
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);


    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);


}
