package cn.footman.sell.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 给予前端的商品详情
 * @author kokio
 * @create 2019-02-26 00:51
 */
@Data
public class ProductInfoViewObject implements Serializable {


    private static final long serialVersionUID = -4489554652998239602L;
    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
