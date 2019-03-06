package cn.footman.sell.enums;

import lombok.Getter;

/**
 * @author kokio
 * @create 2019-02-26 21:27
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {

    NEW(0,"新订单"),
    FINISH(1,"完成"),
    CANCEL(2,"取消");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
