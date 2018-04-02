package web.servlet;

import core.BaseServlet;
import entity.PageBean;
import entity.User;
import entity.cart.Cart;
import entity.order.Order;
import service.OrderService;
import core.MyBeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Created by Siren Chen.
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/order"})
public class OrderServlet extends BaseServlet {
    private OrderService oService = (OrderService) MyBeanFactory.getImplClass("OrderService");

    /**
     * generate order
     * @param request
     * @param response
     * @return /jsp/order/order_info.jsp
     */
    public String genOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        // get data
        User user = (User) request.getSession().getAttribute("user");
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (user == null) {
            request.setAttribute("msg", "Please login first");
            return "/jsp/msg.jsp";
        }

        // call service
        Order order = oService.genOrderFromCart(cart, user);

        // redirect
        request.getSession().removeAttribute("cart");
        request.setAttribute("order", order);
        return "/jsp/order/order_info.jsp";
    }

    /**
     * show order list
     * @param request
     * @param response
     * @return /jsp/order/order_list.jsp
     */
    public String showOrderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,
            SQLException, InvocationTargetException, IllegalAccessException {
        // get data
        int curPage = Integer.parseInt(request.getParameter("curPage"));
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            request.setAttribute("msg", "Please login first");
            return "jsp/msg.jsp";
        }

        // call service
        PageBean<Order> page = oService.showOrderList(curPage, user);

        // redirect
        request.setAttribute("page", page);
        return "/jsp/order/order_list.jsp";
    }

    /**
     * show order details
     * @param request
     * @param response
     * @return /jsp/order/order_info.jsp
     */
    public String showOrderInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,
            IllegalAccessException, SQLException, InvocationTargetException {
        String oid = request.getParameter("oid");

        Order order = oService.showOrderInfo(oid);

        request.setAttribute("order", order);
        return "/jsp/order/order_info.jsp";
    }

    /**
     *
     * @param request
     * @param response
     * @return
     */
    public String placeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String receiverAdd = request.getParameter("receiverAdd");
        String receiverName = request.getParameter("receiverName");
        String receiverPhone = request.getParameter("receiverPhone");
        String oid = request.getParameter("oid");

        oService.placeOrder(oid, receiverName, receiverAdd, receiverPhone);

        request.setAttribute("msg", "Thank you !!!");
        return "/jsp/msg.jsp";
    }

}
