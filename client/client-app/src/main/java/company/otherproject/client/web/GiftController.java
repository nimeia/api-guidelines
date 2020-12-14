package company.otherproject.client.web;


import company.otherproject.client.BusinessService;
import company.otherproject.outapi.GiftService;
import company.otherproject.outapi.vo.GiftInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        GiftInfoVo giftInfoVo =  businessService.get();

        return true;
    }
}
