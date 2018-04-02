package service;

import entity.Product;
import entity.cart.Cart;

import javax.servlet.http.HttpSession;

/**
 * Created by Siren Chen.
 */
public interface CartService {

    /**
     * get the shopping cart from session.
     * if shopping cart do not exist, create a new one
     * @param session
     * @return
     */
    public Cart getCartFrom(HttpSession session);

    /**
     * add a product to the cart
     * @param product
     * @param quantity
     * @param cart
     * @return
     */
    public Cart addToCart(Product product, int quantity, Cart cart);

    /**
     * remove a product from the cart
     * @param pid
     * @param cart
     * @return
     */
    public Cart removeFromCart(String pid, Cart cart);
}
