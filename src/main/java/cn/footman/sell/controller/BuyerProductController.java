package cn.footman.sell.controller;

import cn.footman.sell.dataobject.ProductCategory;
import cn.footman.sell.dataobject.ProductInfo;
import cn.footman.sell.service.CategoryService;
import cn.footman.sell.service.ProductService;
import cn.footman.sell.utils.ResultViewObjectUtil;
import cn.footman.sell.viewobject.ProductInfoViewObject;
import cn.footman.sell.viewobject.ProductViewObject;
import cn.footman.sell.viewobject.ResultViewObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kokio
 * @create 2019-02-26 00:26
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public ResultViewObject list() {

        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();


        //2.查询类目（一次查询）
        List<Integer> categoryTypeList =
                productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductViewObject> productViewObjectList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductViewObject productViewObject = new ProductViewObject();
            productViewObject.setCategoryName(productCategory.getCategoryName());
            productViewObject.setCategoryType(productCategory.getCategoryType());


            List<ProductInfoViewObject> productInfoViewObjectList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoViewObject productInfoViewObject = new ProductInfoViewObject();
//                    productInfoViewObject.setProductId(productInfo.getProductId());
//                    productInfoViewObject.setProductPrice(productInfo.getProductPrice());
//                    productInfoViewObject.setProductName(productInfo.getProductName());
//                    productInfoViewObject.setProductDescription(productInfo.getProductDescription());
//                    productInfoViewObject.setProductIcon(productInfo.getProductIcon());
                    BeanUtils.copyProperties(productInfo, productInfoViewObject);
                    productInfoViewObjectList.add(productInfoViewObject);
                }
            }
            productViewObject.setProductInfoViewObjectList(productInfoViewObjectList);

            productViewObjectList.add(productViewObject);
        }


        return ResultViewObjectUtil.success(productViewObjectList);

    }
}
