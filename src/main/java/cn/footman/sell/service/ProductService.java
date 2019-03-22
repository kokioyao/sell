package cn.footman.sell.service;

import cn.footman.sell.dataobject.OrderDetail;
import cn.footman.sell.dataobject.ProductInfo;
import cn.footman.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author kokio
 * @create 2019-02-25 23:32
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查找所有上架的商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查找所有商品，分页
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 添加库存
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);


    /**
     * 减库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 上架商品
     * @param productId
     * @return
     */
    ProductInfo onSale(String productId);


    /**
     * 下架
     * @param productId
     * @return
     */
    ProductInfo offSale(String productId);


}
