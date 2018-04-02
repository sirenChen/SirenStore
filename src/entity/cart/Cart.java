package entity.cart;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Siren Chen.
 *
 * Shopping cart object
 */
public class Cart implements Serializable {
    private Map<String, CartItem> cartItems = new LinkedHashMap<>();
    private double total = 0;
    private int totalQuantity = 0;

    /**
     * add a cart item to cart
     * @param newItem
     * @return
     */
    public Cart add2Cart(CartItem newItem) {
        String pid = newItem.getProduct().getPid();

        // if this item is already in the cart
        if (cartItems.containsKey(pid)) {
            CartItem oldItem = cartItems.get(pid);
            oldItem.setQuantity(oldItem.getQuantity() + newItem.getQuantity());

        } else {
            cartItems.put(pid,newItem);
        }

        // update total amount and quantity
        this.total = this.total + newItem.getSubtotal();
        this.totalQuantity = this.totalQuantity + newItem.getQuantity();

        return this;
    }

    /**
     * remove from cart
     * @param pid
     * @return
     */
    public Cart removeFromCart(String pid) {
        CartItem cartItem = cartItems.remove(pid);
        total = total - cartItem.getSubtotal();
        totalQuantity = totalQuantity - cartItem.getQuantity();

        return this;
    }

    /**
     * clear cart
     */
    public void clearCart() {
        cartItems.clear();
        total = 0;
        totalQuantity = 0;
    }

    public Collection<CartItem> getCartItems() {
        return cartItems.values();
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
