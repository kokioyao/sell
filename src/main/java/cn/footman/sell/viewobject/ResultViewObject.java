package cn.footman.sell.viewobject;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * @author kokio
 * @create 2019-02-26 00:34
 */
@Data
public class ResultViewObject<T> implements Serializable {


    private static final long serialVersionUID = 8791344590944221596L;
    /**
     * 错误码 
     */
    private Integer code;
    /**
     * 提示消息
     */
    private String msg;

    /**
     * 返回的具体内容
     */
    private T data;

}
