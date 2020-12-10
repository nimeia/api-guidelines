/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package company.project.api.base.page;

import java.io.Serializable;

/**
 * API 查询分页对象
 *
 * @author huang
 */
public class ApiResponsePage extends ApiBasePage implements Serializable {

    /**
     * 总记录数,请求时不需要，结果返回
     */
    protected Integer totalSize;

    public ApiResponsePage() {
    }

    public ApiResponsePage(Integer page, Integer pageSize) {
        super(page, pageSize);
    }

    public ApiResponsePage(Integer page, Integer pageSize, Integer totalSize) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
    }

    public static ApiResponsePage simple() {
        return new ApiResponsePage(0, DEFAULT_PAGE_SIZE);
    }

    public static ApiResponsePage simple(Integer page) {
        return new ApiResponsePage(page, DEFAULT_PAGE_SIZE);
    }

    public static ApiResponsePage simple(Integer page, Integer size) {
        return new ApiResponsePage(page, size);
    }

    public static ApiResponsePage simple(Integer page, Integer size, Integer total) {
        return new ApiResponsePage(page, size, total);
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }
}
