package company.project.api.qvo;

import company.project.api.base.request.ApiRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户订单查询对象
 *
 * @author huang
 */
public class UserOrderQvo implements Serializable {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 生成日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
