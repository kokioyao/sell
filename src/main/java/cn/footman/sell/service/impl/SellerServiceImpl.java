package cn.footman.sell.service.impl;

import cn.footman.sell.dataobject.SellerInfo;
import cn.footman.sell.repository.SellerInfoRepository;
import cn.footman.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kokio
 * @create 2019-03-04 14:52
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
