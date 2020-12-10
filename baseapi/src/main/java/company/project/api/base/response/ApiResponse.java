/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package company.project.api.base.response;

import company.project.api.base.page.ApiResponsePage;

import java.io.Serializable;

/**
 * 接口请求返回
 *
 * @param <T extends Serializable>
 * @author huang
 */
public class ApiResponse<T extends Serializable> extends ApiSimpleResponse<T> implements Serializable {

    /**
     * 分页信息
     */
    private ApiResponsePage page;

    public static <T extends Serializable> ApiResponse<T> simple(T data) {
        ApiResponse<T> r = new ApiResponse();
        r.data = data;
        r.code = RESPONSE_CODE_SUCCESS;
        return r;
    }

    public ApiResponse<T> page(Integer page, Integer size) {
        this.page = ApiResponsePage.simple(page, size);
        return this;
    }

    public ApiResponse<T> page(Integer page, Integer size, Integer total) {
        this.page = ApiResponsePage.simple(page, size, total);
        return this;
    }

    public ApiResponse<T> data(T data) {
        super.data(data);
        return this;
    }

    public ApiResponse<T> code(String code) {
        super.code(code);
        return this;
    }

    public ApiResponse<T> requestId(String requestId) {
        super.requestId(requestId);
        return this;
    }

    public ApiResponse<T> message(String message) {
        super.message(message);
        return this;
    }

    public ApiResponse<T> system(String system) {
        super.system(system);
        return this;
    }

    public ApiResponse<T> businessMessage(String businessMessage) {
        super.businessMessage(businessMessage);
        return this;
    }

    public ApiResponsePage getPage() {
        return page;
    }

    public void setPage(ApiResponsePage page) {
        this.page = page;
    }

}
