package cn.footman.sell.form;

import lombok.Data;

/**
 * @author kokio
 * @create 2019-03-04 12:59
 */
@Data
public class CategoryForm {
    private Integer categoryId;
    /**
     * 类目名字
     */
    private String categoryName;
    /**
     * 类目类型
     */
    private Integer categoryType;
}
