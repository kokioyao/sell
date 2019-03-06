package cn.footman.sell.repository;

import cn.footman.sell.dataobject.SellerInfo;
import cn.footman.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author kokio
 * @create 2019-03-04 14:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("123456");
        sellerInfo.setOpenid("1234");
        SellerInfo save = sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOpenid(){
        SellerInfo sellerInfo = sellerInfoRepository.findByOpenid("1234");
        Assert.assertEquals("1234",sellerInfo.getOpenid());
    }
}