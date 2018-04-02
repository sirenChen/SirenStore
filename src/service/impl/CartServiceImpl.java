package service.impl;

import entity.Product;
import entity.cart.Cart;
import entity.cart.CartItem;
import service.CartService;

import javax.servlet.http.HttpSession;

/**
 * Created by Siren Chen.
 */
public class CartServiceImpl implements CartService {

    @Override
    public Cart getCartFrom(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            return new Cart();
        }

        return cart;
    }

    @Override
    public Cart addToCart(Product product, int quantity, Cart cart) {
        CartItem cartItem = new CartItem(product, quantity);

        return cart.add2Cart(cartItem);
    }

    @Override
    public Cart removeFromCart(String pid, Cart cart) {
        return cart.removeFromCart(pid);
    }

}
