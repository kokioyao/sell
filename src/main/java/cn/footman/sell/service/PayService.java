package cn.footman.sell.service;

import cn.footman.sell.dto.OrderDTO;

/**
 * @author kokio
 * @create 2019-03-03 00:38
 */
public interface PayService {

    void create(OrderDTO orderDTO);
}
