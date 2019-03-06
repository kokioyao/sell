package cn.footman.sell.repository;

import cn.footman.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kokio
 * @create 2019-02-25 01:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){
        ProductCategory categoryRepositoryOne =
                productCategoryRepository.findOne(1);

        System.out.println(categoryRepositoryOne.toString());
    }

    @Test
    @Transactional
    public void saveTest(){
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(2);
//        productCategory.setCategoryName("眼瞎过去");
//        productCategory.setCategoryType(9);

//        ProductCategory repositoryOne = productCategoryRepository.findOne(2);
//        repositoryOne.setCategoryType(99);
//        productCategoryRepository.save(repositoryOne);

        ProductCategory productCategory = new ProductCategory("无聊榜", 89);
        ProductCategory category = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(category);
//        Assert.assertNotEquals(null,category);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> lists = new ArrayList<>();
        lists.add(89);
        lists.add(99);
        List<ProductCategory> byCategoryTypeIn = productCategoryRepository.findByCategoryTypeIn(lists);
        for(ProductCategory productCategory : byCategoryTypeIn){
            System.out.println(productCategory);
        }
    }





}