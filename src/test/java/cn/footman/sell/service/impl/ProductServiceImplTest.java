package cn.footman.sell.service.impl;

import cn.footman.sell.dataobject.ProductInfo;
import cn.footman.sell.enums.ProductStatusEnum;
import cn.footman.sell.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kokio
 * @create 2019-02-25 23:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl service;

    @Test
    public void findOne() {
        ProductInfo result = service.findOne("9876543");
        Assert.assertEquals("9876543",result.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = service.findUpAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findAll() {
        PageRequest page = new PageRequest(0, 3);
        Page<ProductInfo> result = service.findAll(page);
//        System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0,result.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("语文书");
        productInfo.setProductPrice(new BigDecimal(9.99));
        productInfo.setProductStock(10);
        productInfo.setProductDescription("good book");
        productInfo.setProductIcon("yyyyyyy.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(99);
        ProductInfo product = service.save(productInfo);
        Assert.assertNotNull(product);
    }


    @Test
    public void onsale(){
        ProductInfo productInfo = service.onSale("123456");
        Assert.assertEquals(ProductStatusEnum.UP,productInfo.getProductStatusEnum());
    }
}