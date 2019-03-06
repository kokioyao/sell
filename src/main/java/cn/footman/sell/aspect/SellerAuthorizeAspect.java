package cn.footman.sell.aspect;

import cn.footman.sell.constant.CookieConstant;
import cn.footman.sell.constant.RedisConstant;
import cn.footman.sell.exception.SellException;
import cn.footman.sell.exception.SellerAuthorizeException;
import cn.footman.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author kokio
 * @create 2019-03-05 16:03
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(* cn.footman.sell.controller.Seller*.*(..))" +
    "&& !execution(* cn.footman.sell.controller.SellerUserController.*(..))")
    public void verify(){}


    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        String cookieValue = CookieUtil.get(request, CookieConstant.COOKIE_NAME);
        if(StringUtils.isEmpty(cookieValue)){
            log.info("【登陆校验】登陆时cookie中查不到token");
            throw new SellerAuthorizeException();
        }
        //到redis中查找
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookieValue));
        if(StringUtils.isEmpty(tokenValue)){
            log.info("【登陆校验】登陆时redis中查不到token");
            throw new SellerAuthorizeException();
        }


    }
}
