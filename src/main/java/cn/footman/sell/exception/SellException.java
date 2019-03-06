package cn.footman.sell.exception;

import cn.footman.sell.enums.ResultEnum;
import lombok.Data;

/**
 * @author kokio
 * @create 2019-02-27 16:52
 */
@Data
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
