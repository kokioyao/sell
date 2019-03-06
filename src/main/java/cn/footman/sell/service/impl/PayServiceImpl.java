package cn.footman.sell.service.impl;

import cn.footman.sell.dto.OrderDTO;
import cn.footman.sell.service.PayService;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author kokio
 * @create 2019-03-03 00:39
 */
@Service
public class PayServiceImpl implements PayService {


    @Override
    public void create(OrderDTO orderDTO) {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();

    }
}
