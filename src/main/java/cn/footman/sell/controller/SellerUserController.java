package cn.footman.sell.controller;

import cn.footman.sell.config.ProjectUrlConfig;
import cn.footman.sell.constant.CookieConstant;
import cn.footman.sell.constant.RedisConstant;
import cn.footman.sell.dataobject.SellerInfo;
import cn.footman.sell.enums.ResultEnum;
import cn.footman.sell.service.SellerService;
import cn.footman.sell.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author kokio
 * @create 2019-03-05 13:53
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              Map<String, Object> map,
                              HttpServletResponse response) {
        //openid与数据库中的数据进行比对
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMsg());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        //设置到redis中
        String token = UUID.randomUUID().toString().replace("-", "");
        Integer expire = RedisConstant.EXPIRE;
        String formatKey = String.format(RedisConstant.TOKEN_PREFIX, token);

        redisTemplate.opsForValue().set(formatKey, openid, expire, TimeUnit.SECONDS);
        //设置到cookie中
        CookieUtil.set(response, CookieConstant.COOKIE_NAME, token, expire);

        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");
    }


    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response
                        ,Map<String,Object> map) {
        //从cookie中查询token
        String tokenValue = CookieUtil.get(request, CookieConstant.COOKIE_NAME);
        //清除redis
        if(!StringUtils.isEmpty(tokenValue)){
            String formatKey = String.format(RedisConstant.TOKEN_PREFIX, tokenValue);

            redisTemplate.delete(formatKey);
//        清除cookie
            CookieUtil.set(response,CookieConstant.COOKIE_NAME,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMsg());
        map.put("url","/sell/seller/order/list");

        return new ModelAndView("common/success",map);

    }
}
