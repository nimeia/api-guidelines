package company.otherproject.outapi;

import company.otherproject.outapi.vo.GiftInfoVo;
import company.otherproject.outapi.vo.GiftOrderInfo;
import company.otherproject.outapi.vo.GiftUserInfo;
import company.project.api.ShopApi;
import company.project.api.base.request.ApiRequest;
import company.project.api.base.response.ApiResponse;
import company.project.api.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GiftService {

    @Autowired(required = false)
    ShopApi shopApi;

    /**
     * 创建礼物，并生成新订单
     *
     * @param userInfo
     * @param orderInfo
     * @return
     */
    public GiftInfoVo makeGift(GiftUserInfo userInfo, GiftOrderInfo orderInfo) {

        Order order = new Order();
        order.setCreateDate(new Date());
        // order.setCustomer(userInfo);
        // do anything you need ....
        ApiResponse<String> orderApiResponse = shopApi.makeOrder(ApiRequest.simple(order));

        GiftInfoVo giftInfoVo = new GiftInfoVo();
        if (orderApiResponse.getSuccess()) {
            //处理成功逻辑
        } else {
            //处理失败逻辑
        }

        return giftInfoVo;
    }

}
