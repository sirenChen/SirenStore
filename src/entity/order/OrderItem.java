package entity.order;

import entity.Product;

import java.io.Serializable;

/**
 * Created by Siren Chen.
 * this class is map to the orderItem table
 */
public class OrderItem implements Serializable {
    private String ooid;
    private Integer quantity;
    private Double subtotal;

    // contain what product
    private Product product;
    // belong to which order
    private Order order;

    public String getOoid() {
        return ooid;
    }

    public void setOoid(String ooid) {
        this.ooid = ooid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
