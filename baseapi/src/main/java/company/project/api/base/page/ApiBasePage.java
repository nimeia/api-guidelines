package company.project.api.base.page;

import java.io.Serializable;

/**
 * 基础的page
 *
 * @author huang
 */
public class ApiBasePage implements Serializable {

    /**
     * 默认分页大小
     */
    public static Integer DEFAULT_PAGE_SIZE = 20;
    /**
     * 当前页码
     */
    protected Integer page;
    /**
     * 每页大小
     */
    protected Integer pageSize;

    public ApiBasePage() {
    }

    public ApiBasePage(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public static ApiBasePage simple() {
        return new ApiBasePage(0, DEFAULT_PAGE_SIZE);
    }

    public static ApiBasePage simple(Integer page) {
        return new ApiBasePage(page, DEFAULT_PAGE_SIZE);
    }

    public static ApiBasePage simple(Integer page, Integer pageSize) {
        return new ApiBasePage(page, pageSize);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
