package cn.footman.sell.service.impl;

import cn.footman.sell.config.WeChatAccountConfig;
import cn.footman.sell.dto.OrderDTO;
import cn.footman.sell.service.PushMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 微信消息推送
 *
 * @author kokio
 * @create 2019-03-05 18:10
 */
@Service
@Slf4j
public class PushMessageImpl implements PushMessage {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WeChatAccountConfig weChatAccountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
        wxMpTemplateMessage.setTemplateId(weChatAccountConfig.getTemplateId().get("orderStatus"));
        wxMpTemplateMessage.setToUser("oHC-S5wVALU0khYj-8PpFTzoWekQ");//openid

        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first", "订单状态变更通知"),
                new WxMpTemplateData("keyword1","购买书籍"),
                new WxMpTemplateData("keyword2","12873654831"),
                new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMsg()),
                new WxMpTemplateData("keyword5",orderDTO.getOrderAmount().toString()),
                new WxMpTemplateData("remark","谢谢惠顾")
                );



        wxMpTemplateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
        } catch (WxErrorException e) {
            log.error("【微信消息推送失败】发送消息失败 {}", e);
        }
    }
}
