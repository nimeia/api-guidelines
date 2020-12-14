package company.project.api.base.request;

import java.io.Serializable;
import java.util.Date;

/**
 * api 基础查询对象
 *
 * @author huang
 */
public class ApiSimpleRequest<T extends Serializable> implements Serializable {

    /**
     * 标志某一个请求,可以按其跟踪一个接口的请求
     *
     */
    protected String requestId;

    /**
     * 请求时间
     */
    protected Date requestDate;

    /**
     * 一些接口可能需要定义较长的超时时间,通过该属性修改处理
     *
     * @ignore
     */
    protected Long timeOut;

    /**
     * 标记一个用户的信息,在从报文体中分开
     * @ignore
     */
    protected String token;

    /**
     * the business data
     *
     * @see T
     */
    protected T data;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
}
