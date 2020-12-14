package company.project.api.base.response;

import java.io.Serializable;

/**
 * 基础返回对象
 *
 * @param <T>
 * @author huang
 */
public class ApiSimpleResponse<T extends Serializable> implements Serializable {

    public static final String RESPONSE_CODE_SUCCESS = "2000";
    public static final String RESPONSE_CODE_ERROR = "5000";

    /**
     * 标志某一个请求,可以按其跟踪一个接口的请求
     */
    protected String requestId;

    /**
     * 系统识别号
     */
    protected String system;

    /**
     * 返回结果码
     */
    protected String code;

    /**
     * 业务上是否成功
     */
    protected Boolean success;

    /**
     * 调用结果信息
     */
    protected String message;

    /**
     * 业务返回信息描述
     */
    protected String businessMessage;

    /**
     * the business data
     *
     * @see T
     */
    protected T data;


    public ApiSimpleResponse<T> data(T data) {
        this.data = data;
        return this;
    }

    public ApiSimpleResponse<T> code(String code) {
        this.code = code;
        return this;
    }

    public ApiSimpleResponse<T> requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public ApiSimpleResponse<T> message(String message) {
        this.message = message;
        return this;
    }

    public ApiSimpleResponse<T> system(String system) {
        this.system = system;
        return this;
    }

    public ApiSimpleResponse<T> businessMessage(String businessMessage) {
        this.businessMessage = businessMessage;
        return this;
    }


    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBusinessMessage() {
        return businessMessage;
    }

    public void setBusinessMessage(String businessMessage) {
        this.businessMessage = businessMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
