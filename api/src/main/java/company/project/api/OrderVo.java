package company.project.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单相关信息
 * 描述主订单信息
 *
 * @author huang
 * @since 1.0.0
 */
public class OrderVo implements Serializable {

    /**
     * 订单id
     *
     */
    private Long id;

    /**
     * 订单号
     * @required
     */
    private String orderNo;

    /**
     * 订单总金额
     * @required
     * @since v1.0.1
     */
    private BigDecimal total;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 客户信息
     * @required
     */
    private Customer customer;

    /**
     * 订单商品明细
     * @required
     */
    private List<OrderItem> items;

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
