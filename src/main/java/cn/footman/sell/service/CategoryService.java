package cn.footman.sell.service;

import cn.footman.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author kokio
 * @create 2019-02-25 20:15
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
