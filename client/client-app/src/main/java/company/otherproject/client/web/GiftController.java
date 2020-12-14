package company.otherproject.client.web;


import company.otherproject.client.BusinessService;
import company.otherproject.outapi.GiftService;
import company.otherproject.outapi.vo.GiftInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * gift web api
 *
 * @author huang
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("gift")
public class GiftController {

    @Autowired
    BusinessService businessService;

    /**
     * 生成礼物订单
     * @param giftVo
     * @return
     */
    @RequestMapping(value = "make",method = RequestMethod.POST)
    public Boolean make(@RequestBody GiftVo giftVo){

        // tip 这只做调用演示，按本规范不能直接返回Boolean，返回应该用Response 对象包裹 ,同时入参应该用Request 对象包裹
        GiftInfoVo giftInfoVo =  businessService.save(giftVo);

        return true;
    }

    /**
     * 批量生成礼物订单
     * @param giftVos
     * @return
     */
    public Boolean betchMake(@RequestBody List<GiftVo> giftVos){

        // 检查相关参数

        // tips 该处不应该循环调用接口
        for (GiftVo giftVo : giftVos) {
            businessService.save(giftVo);
        }

        // tips 应该一次传递所有参数处理
        businessService.betchMake(giftVos);
        return true;
    }
}
