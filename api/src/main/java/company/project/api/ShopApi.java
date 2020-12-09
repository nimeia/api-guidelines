package company.project.api;

import company.project.api.base.ApiRequest;
import company.project.api.base.ApiResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 购物API
 *
 * @author huang
 * @since v1.0.0
 * @restApi
 */
@RequestMapping("/shop")
public interface ShopApi {

    /**
     * 生成对应的订单
     *
     * @since v1.0.0
     * @param orderVo 订单的基础信息
     * @return 新生成的订单号
     */
    @RequestMapping(value = "/order/make" ,method = RequestMethod.POST)
    ApiResponse<String> makeOrder(@RequestBody ApiRequest<OrderVo> orderVo);

    /**
     * 查询订单信息
     *
     * @param orderNo 订单号
     * @return 订单信息
     */
    @RequestMapping(value = "order/find",method = RequestMethod.POST)
    ApiResponse<OrderVo> findOrder(@RequestBody ApiRequest<String> orderNo);
}
