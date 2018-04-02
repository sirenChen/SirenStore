package entity.cart;

import entity.Product;

import java.io.Serializable;

/**
 * Created by Siren Chen.
 * Shopping cart item
 */
public class CartItem implements Serializable{
    private Product product;
    private int quantity;
    private double subtotal;

    public CartItem() {
    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * this.getQuantity();
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
