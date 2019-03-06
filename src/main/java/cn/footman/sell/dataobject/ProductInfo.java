package cn.footman.sell.dataobject;

import cn.footman.sell.enums.ProductStatusEnum;
import cn.footman.sell.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author kokio
 * @create 2019-02-25 20:33
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
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
    private Integer productStatus ;

    /**
     * 类目编号
     */
    private Integer categoryType;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }

}
