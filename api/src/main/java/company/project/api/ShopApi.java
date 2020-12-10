package company.project.api;

import company.project.api.base.request.ApiRequest;
import company.project.api.base.response.ApiResponse;
import company.project.api.base.request.ApiSimpleRequest;
import company.project.api.base.response.ApiSimpleResponse;
import company.project.api.qvo.UserOrderQvo;
import company.project.api.vo.Order;
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
    ApiResponse<String> makeOrder(@RequestBody ApiRequest<Order> orderVo);

    /**
     * 查询订单信息
     *
     * @param orderNo 订单号
     * @return 订单信息
     */
    @RequestMapping(value = "order/find",method = RequestMethod.POST)
    ApiSimpleResponse<Order> findOrder(@RequestBody ApiSimpleRequest<String> orderNo);

    /**
     * 按用户信息查询订单
     * @param userOrderQvo
     * @return
     * @tips 当某些查询需要一些子集参数，建议新建一个 queryVo 处理
     */
    @RequestMapping(value = "order/findByUser",method = RequestMethod.POST)
    ApiResponse<Order> findUserOrder(@RequestBody ApiRequest<UserOrderQvo> userOrderQvo);
}
