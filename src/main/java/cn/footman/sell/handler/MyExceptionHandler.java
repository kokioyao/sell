package cn.footman.sell.handler;

import cn.footman.sell.config.ProjectUrlConfig;
import cn.footman.sell.exception.ResponseBankException;
import cn.footman.sell.exception.SellException;
import cn.footman.sell.exception.SellerAuthorizeException;
import cn.footman.sell.utils.ResultViewObjectUtil;
import cn.footman.sell.viewobject.ResultViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author kokio
 * @create 2019-03-05 16:34
 */
@ControllerAdvice
public class MyExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登陆异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerSellerAuthorizeException(){
        return new ModelAndView("login/login");
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultViewObject handlerSellException(SellException e){
        return ResultViewObjectUtil.error(e.getCode(),e.getMessage());
    }


    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankException(){

    }
}
