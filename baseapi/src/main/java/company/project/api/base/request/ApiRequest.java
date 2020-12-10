/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package company.project.api.base.request;

import company.project.api.base.page.ApiRequestPage;

import java.io.Serializable;

/**
 * 请求接口定义
 *
 * @param <T extends Serializable>
 * @author huang
 */
public class ApiRequest<T extends Serializable> extends ApiSimpleRequest<T> implements Serializable {

    /**
     * 分页信息
     */
    private ApiRequestPage page;

    /**
     * 快速构建方法
     *
     * @return
     */
    public static <T extends Serializable> ApiRequest<T> simple(T t) {
        ApiRequest<T> r = new ApiRequest<>();
        r.setData(t);
        r.setRequestId(String.valueOf(System.nanoTime()));
        r.setTimeOut(60 * 1000L);
        r.setToken("simple");
        return r;
    }

    public ApiRequest<T> page(Integer page, Integer size) {
        this.page = ApiRequestPage.simple(page, size);
        return this;
    }

    public ApiRequest<T> token(String token) {
        this.token = token;
        return this;
    }

    public ApiRequest<T> requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public ApiRequest<T> timeOut(Long timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    public ApiRequest<T> data(T data) {
        this.data = data;
        return this;
    }

    public ApiRequestPage getPage() {
        return page;
    }

    public void setPage(ApiRequestPage page) {
        this.page = page;
    }

}
