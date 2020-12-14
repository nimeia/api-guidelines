package company.otherproject.client;

import company.otherproject.outapi.GiftService;
import company.otherproject.outapi.vo.GiftInfoVo;
import company.otherproject.outapi.vo.GiftOrderInfo;
import company.otherproject.outapi.vo.GiftUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 演示业务服务
 *
 * @author huang
 */
@Component
public class BusinessService {

    @Autowired
    GiftService giftService;

    /**
     * 演示方法，
     * @return
     */
    public GiftInfoVo get() {
        GiftUserInfo giftUserInfo = new GiftUserInfo();
        GiftOrderInfo giftOrderInfo = new GiftOrderInfo();
        // do other thing
        // tips 注意，该外不应该去使用外部api封装的对象
        return giftService.makeGift(giftUserInfo, giftOrderInfo);
    }
}
