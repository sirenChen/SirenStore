package service;

import entity.PageBean;
import entity.User;
import entity.cart.Cart;
import entity.order.Order;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Created by Siren Chen.
 */
public interface OrderService {

    /**
     * generate order from shpping cart
     * @param cart
     * @param user
     * @return
     * @throws SQLException
     */
    public Order genOrderFromCart(Cart cart, User user) throws SQLException;

    /**
     * show all order
     * @param curPage
     * @param user
     * @return
     * @throws SQLException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public PageBean<Order> showOrderList(int curPage, User user) throws SQLException, InvocationTargetException, IllegalAccessException;

    /**
     * show order information
     * @param oid
     * @return
     * @throws SQLException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Order showOrderInfo(String oid) throws SQLException, InvocationTargetException, IllegalAccessException;


    /**
     * place order
     * @param oid
     * @param receiverName
     * @param receiverAdd
     * @param receiverPhone
     * @throws SQLException
     */
    public void placeOrder(String oid, String receiverName, String receiverAdd, String receiverPhone) throws SQLException;
}
