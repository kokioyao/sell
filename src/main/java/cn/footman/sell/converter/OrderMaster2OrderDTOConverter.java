package cn.footman.sell.converter;

import cn.footman.sell.dataobject.OrderMaster;
import cn.footman.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kokio
 * @create 2019-02-27 23:06
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }


    public static List<OrderDTO> listConvert(List<OrderMaster> orderMasterList){
//        List<OrderDTO> orderDTOArrayList = new ArrayList<>();
//
//        for(OrderMaster orderMaster : orderMasterList){
//            orderDTOArrayList.add(convert(orderMaster));
//        }
//        return orderDTOArrayList;

        return orderMasterList.stream().map(e ->
                convert(e)).collect(Collectors.toList());

    }
}
