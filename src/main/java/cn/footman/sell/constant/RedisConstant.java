package cn.footman.sell.constant;

/**
 * @author kokio
 * @create 2019-03-05 14:11
 */
public interface RedisConstant {
    //过期时间
    Integer EXPIRE = 6000;

    //前缀
    String TOKEN_PREFIX="token_%s";
}
