package cn.footman.sell.enums;

import lombok.Getter;

/**
 * @author kokio
 * @create 2019-02-26 21:32
 */
@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0, "等待支付"),
    PAYSUCCESS(1, "完成支付"),
    PAYFAIL(2,"支付失败");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
