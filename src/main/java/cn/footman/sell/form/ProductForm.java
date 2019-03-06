package cn.footman.sell.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author kokio
 * @create 2019-03-04 11:14
 */
@Data
public class ProductForm {

    private String productId;
    /**
     * 名字
     */
    private String productName;
    /** 单价. */
    private BigDecimal productPrice;

    /**
     *  库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 商品状态码 0正常 1下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;


}
