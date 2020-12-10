package company.project.api.base.page;

import java.io.Serializable;

/**
 * 带排序的分页
 *
 * @author huang
 */
public class ApiRequestPage extends ApiBasePage implements Serializable {

    /**
     * 排序参数，orderBy=name desc,hireDate
     *
     * @mock orderBy=name desc,hireDate
     */
    private String orderBy;

    /**
     * 过滤条件，filter=(name eq 'Milk' or name eq 'Eggs') and price lt 2.55
     *
     * @mock filter=(name eq 'Milk' or name eq 'Eggs') and price lt 2.55
     */
    private String filter;

    public ApiRequestPage() {
    }

    public ApiRequestPage(Integer page, Integer pageSize) {
        super(page, pageSize);
    }

    public static ApiRequestPage simple() {
        return new ApiRequestPage(0, DEFAULT_PAGE_SIZE);
    }

    public static ApiRequestPage simple(Integer page) {
        return new ApiRequestPage(page, DEFAULT_PAGE_SIZE);
    }

    public static ApiRequestPage simple(Integer page, Integer pageSize) {
        return new ApiRequestPage(page, pageSize);
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
