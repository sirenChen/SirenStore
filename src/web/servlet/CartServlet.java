package web.servlet;

import core.BaseServlet;
import entity.Product;
import entity.cart.Cart;
import service.CartService;
import service.ProductService;
import core.MyBeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Siren Chen.
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends BaseServlet {
    @Override
    public String index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        return "/jsp/order/cart.jsp";
    }

    /**
     * add to cart
     * @param request
     * @param response
     * @return redirect to /jsp/order/cart.jsp
     */
    public String addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        ProductService pService = (ProductService) MyBeanFactory.getImplClass("ProductService");
        CartService cService = (CartService) MyBeanFactory.getImplClass("CartService");

        // get data
        String pid = request.getParameter("pid");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session = request.getSession();

        // call service
        Product product = pService.findProductById(pid);
        Cart cart = cService.getCartFrom(session);
        cart = cService.addToCart(product, quantity, cart);

        // redirect
        request.getSession().setAttribute("cart", cart);
        response.sendRedirect(request.getContextPath()+"/jsp/order/cart.jsp");

        return null;
    }

    /**
     * remove from cart
     * @param request
     * @param response
     * @return redirect to /jsp/order/cart.jsp
     */
    public String removeFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cService = (CartService) MyBeanFactory.getImplClass("CartService");

        // get data
        String pid = request.getParameter("pid");
        HttpSession session = request.getSession();

        // call service
        Cart cart = cService.getCartFrom(session);
        cart = cService.removeFromCart(pid,cart);

        // redirect
        request.getSession().setAttribute("cart", cart);
        response.sendRedirect(request.getContextPath()+"/jsp/order/cart.jsp");

        return null;
    }
}
