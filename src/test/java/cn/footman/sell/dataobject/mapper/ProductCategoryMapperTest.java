package cn.footman.sell.dataobject.mapper;

import cn.footman.sell.SellApplication;
import cn.footman.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author kokio
 * @create 2019-03-05 23:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SellApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("category_name","xixi");
        map.put("category_type","23");
        int i = mapper.insertByMap(map);
        Assert.assertEquals(1,i);
    }


    @Test
    public void insertByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("dongdong");
        productCategory.setCategoryType(89);
        int i = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,i);

    }

    @Test
    public void selectByType(){
        ProductCategory productCategory = mapper.selectByType(89);
        Assert.assertEquals(9,productCategory.getCategoryId().longValue());
    }

    @Test
    public void updateByCategoryType(){
        int i = mapper.updateByCategoryType( "linchong",23);
        Assert.assertEquals(1,i);
    }

    @Test
    public void updateByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(23);
        productCategory.setCategoryName("linlin");
        int i = mapper.updateByObject(productCategory);
        Assert.assertEquals(1,i);
    }


    @Test
    public void deleteByType(){
        int i = mapper.deleteByCategoryType(23);
        Assert.assertEquals(1,i);
    }


    @Test
    public void selectByCategoryType(){
        ProductCategory productCategory = mapper.selectByCategoryType(89);
        Assert.assertEquals(9,productCategory.getCategoryId().longValue());
//        System.out.println(productCategory.toString());
    }
}