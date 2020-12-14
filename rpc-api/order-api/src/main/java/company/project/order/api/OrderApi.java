package company.project.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 订单 api
 *
 * @author huang
 * @since 1.0.0
 */
@RequestMapping("order")
@FeignClient
public interface OrderApi {

    /**
     * 订单详情
     *
     * @since 1.0.0
     * @auth huang
     * @param orderNo
     * @return
     */
    @RequestMapping(value = "find",method = RequestMethod.GET)
    OrderVo find(@RequestParam("orderNo") String orderNo);
}
