package cn.footman.sell.repository;

import cn.footman.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kokio
 * @create 2019-02-25 20:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("9876543");
        productInfo.setProductName("课本");
        productInfo.setProductPrice(new BigDecimal(8.92));
        productInfo.setProductStock(98);
        productInfo.setProductDescription("watch");
        productInfo.setProductIcon("xxxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(99);
        ProductInfo info = productInfoRepository.save(productInfo);
        Assert.assertNotNull(info);
    }

    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        for(ProductInfo productInfo : productInfoList){
            System.out.println(productInfo);
        }
    }

}