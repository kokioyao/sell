package cn.footman.sell.controller;

import cn.footman.sell.converter.OrderForm2OrderDTOConverter;
import cn.footman.sell.dto.OrderDTO;
import cn.footman.sell.enums.ResultEnum;
import cn.footman.sell.exception.SellException;
import cn.footman.sell.form.OrderForm;
import cn.footman.sell.service.BuyerService;
import cn.footman.sell.service.OrderService;
import cn.footman.sell.utils.ResultViewObjectUtil;
import cn.footman.sell.viewobject.ResultViewObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kokio
 * @create 2019-02-28 22:59
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultViewObject<Map<String, String>> createOrder(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultViewObjectUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    @Cacheable(cacheNames = "product",key = "111")
    public ResultViewObject<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                                 @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】 openid为空");
            throw new SellException(ResultEnum.OPENID_EMPTY);
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultViewObjectUtil.success(orderDTOPage.getContent());
    }
    //订单详情

    @GetMapping("/detail")
    public ResultViewObject<OrderDTO> detail(@RequestParam("openid") String openid,
                                             @RequestParam("orderId") String orderId) {

        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);

        return ResultViewObjectUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultViewObject cancel(@RequestParam("openid") String openid,
                                   @RequestParam("orderId") String orderId) {

        buyerService.cancelOrder(openid, orderId);
        return ResultViewObjectUtil.success();
    }

}
