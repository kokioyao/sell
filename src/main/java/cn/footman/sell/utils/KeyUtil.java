package cn.footman.sell.utils;

import java.util.Random;

/**
 * @author kokio
 * @create 2019-02-27 20:32
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 时间+随机数
     * @return
     */
     public static synchronized String genUniqueKey(){

         Random random = new Random();
         int num = random.nextInt(900000) + 100000;//生成6位随机数

         return System.currentTimeMillis() + String.valueOf(num);
     }
}
