package cn.footman.sell.service;

import cn.footman.sell.dataobject.SellerInfo;

/**
 * @author kokio
 * @create 2019-03-04 14:51
 */
public interface SellerService {
    /**
     * 通过openid查询卖家信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
