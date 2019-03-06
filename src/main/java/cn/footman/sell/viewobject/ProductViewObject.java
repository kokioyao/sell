package cn.footman.sell.viewobject;

import cn.footman.sell.dataobject.ProductInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品
 * @author kokio
 * @create 2019-02-26 00:46
 */
@Data
public class ProductViewObject implements Serializable {

    private static final long serialVersionUID = -181957690479731133L;
    /**
     * 类目名字
     */
    @JsonProperty("name")
    private String categoryName;

    /**
     * 类目类型
     */
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoViewObject> productInfoViewObjectList;
}
