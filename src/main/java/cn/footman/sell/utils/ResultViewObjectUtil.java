package cn.footman.sell.utils;

import cn.footman.sell.viewobject.ResultViewObject;

import javax.xml.transform.Result;

/**
 * @author kokio
 * @create 2019-02-26 20:16
 */
public class ResultViewObjectUtil {
    public static ResultViewObject success(Object o){
        ResultViewObject<Object> resultViewObject = new ResultViewObject<>();
        resultViewObject.setCode(0);
        resultViewObject.setMsg("success");
        resultViewObject.setData(o);
        return resultViewObject;
    }

    public static ResultViewObject success(){
        return success(null);
    }


    public static ResultViewObject error(Integer code,String msg){
        ResultViewObject<Object> resultViewObject = new ResultViewObject<>();
        resultViewObject.setMsg(msg);
        resultViewObject.setCode(code);
        return resultViewObject;
    }
}
