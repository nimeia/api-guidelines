package company.project.order.api;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单详情
 *
 * @author huang
 * @version 1.0.0
 */
public class OrderVo implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 订单id
     */
    private String orderNo;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 有效状态
     */
    private Boolean valid;

    /**
     * 支付状态
     */
    private String paymentStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
