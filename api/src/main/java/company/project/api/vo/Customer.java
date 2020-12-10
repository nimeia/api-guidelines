package company.project.api.vo;

import java.io.Serializable;

/**
 * 顾客信息
 * 下单时的顾客信息
 *
 * @author huang
 * @since 1.0.0
 */
public class Customer implements Serializable {

    /**
     * 客户id
     * @required
     */
    private Long id;

    /**
     * 客户名称
     * @required
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
