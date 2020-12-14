package company.otherproject.client;

import company.otherproject.client.web.GiftVo;
import company.otherproject.outapi.GiftService;
import company.otherproject.outapi.vo.GiftInfoVo;
import company.otherproject.outapi.vo.GiftOrderInfo;
import company.otherproject.outapi.vo.GiftUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 生成订单
     * @param giftVo
     * @return
     */
    public GiftInfoVo save(GiftVo giftVo) {
        GiftUserInfo giftUserInfo = new GiftUserInfo();
        GiftOrderInfo giftOrderInfo = new GiftOrderInfo();
        // do other thing
        // tips 注意，该外不应该去使用外部api封装的对象
        GiftInfoVo giftInfoVo = giftService.makeGift(giftUserInfo, giftOrderInfo);
        return giftInfoVo;
    }

    /**
     * 批量生成
     *
     * @param giftVos
     * @return
     */
    public Boolean betchMake(List<GiftVo> giftVos) {

        // 处理业务
        List<GiftInfoVo> giftInfoVos = new ArrayList<GiftInfoVo>();
        for (GiftVo giftVo : giftVos) {
            GiftInfoVo giftInfoVo = new GiftInfoVo();
        }

        giftService.betchMake(giftInfoVos);
        return true;
    }
}
