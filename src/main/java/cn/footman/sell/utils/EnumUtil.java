package cn.footman.sell.utils;

import cn.footman.sell.enums.CodeEnum;

/**
 * @author kokio
 * @create 2019-03-03 17:23
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for(T each: enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
