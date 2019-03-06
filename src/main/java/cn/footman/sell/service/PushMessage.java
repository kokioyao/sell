package cn.footman.sell.service;

import cn.footman.sell.dto.OrderDTO;

/**
 * 消息推送
 * @author kokio
 * @create 2019-03-05 18:09
 */
public interface PushMessage {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
