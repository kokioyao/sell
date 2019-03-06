package cn.footman.sell.enums;

import cn.footman.sell.utils.EnumUtil;
import lombok.Getter;

/**
 * 商品状态
 *
 * @author kokio
 * @create 2019-02-25 23:38
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    UP(0,"正常"),
    DOWN(1,"下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

}
