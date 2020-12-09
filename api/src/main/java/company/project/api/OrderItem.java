package company.project.api;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单明细项
 *
 * @author huang
 * @since v1.0.0
 */
public class OrderItem implements Serializable {

    /**
     * 商品id
     * @required
     */
    private Long id;

    /**
     * 商品名称
     * @required
     */
    private String name;

    /**
     * 商品价格
     * @required
     */
    private BigDecimal price;

    /**
     * 商品名称
     * @required
     */
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
