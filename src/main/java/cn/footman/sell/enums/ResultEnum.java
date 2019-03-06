package cn.footman.sell.enums;

import lombok.Getter;

/**
 * @author kokio
 * @create 2019-02-27 16:53
 */
@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"传入参数不正确"),

    PRODUCT_NOT_EXIST(110,"商品不存在"),
    PRODUCT_STOCK_ERROR(111,"库存有误"),
    ORDER_NOT_EXIST(112,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(113,"订单详情不存在"),
    ORDER_STATUS_ERROR(114,"订单状态错误"),
    ORDER_UPDATE_FAIL(115,"订单更新失败"),
    ORDER_DETAIL_EMPTY(116,"订单中无详情"),
    ORDER_PAY_STATUS_ERROR(117,"订单支付状态有误"),
    CART_EMPTY(118,"购物车为空"),
    OPENID_EMPTY(119,"openid为空"),
    ORDER_OWNER_ERROR(120,"订单用户错误"),
    WECHAT_MP_ERROR(121,"微信公众号错误"),
    ORDER_CANCEL_SUCCESS(122,"订单取消成功"),
    ORDER_FINISH_SUCCESS(123,"订单正常完成"),
    PRODUCT_STATUS_ERROR(124,"商品状态错误"),
    LOGIN_FAIL(125,"登陆失败"),
    LOGOUT_SUCCESS(126,"登出成功")

    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
