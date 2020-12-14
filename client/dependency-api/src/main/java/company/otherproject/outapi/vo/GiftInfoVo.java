package company.otherproject.outapi.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 礼物清单
 */
public class GiftInfoVo implements Serializable {

    public String outerUserId;

    private String orderId;

    private Date createDate;


    public String getOuterUserId() {
        return outerUserId;
    }

    public void setOuterUserId(String outerUserId) {
        this.outerUserId = outerUserId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
