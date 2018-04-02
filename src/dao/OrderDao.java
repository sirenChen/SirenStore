package dao;

import entity.User;
import entity.order.Order;
import entity.order.OrderItem;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siren Chen.
 */
public interface OrderDao {

    /**
     * insert an order
     * @param order
     * @throws SQLException
     */
    public void insertOrder(Order order) throws SQLException;

    /**
     * insert an order item
     * @param orderItem
     * @throws SQLException
     */
    public void insertOrderItem(OrderItem orderItem) throws SQLException;

    /**
     * fina an order by order ID
     * @param oid order id
     * @return Order
     * @throws SQLException
     */
    public Order findOrderById(String oid) throws SQLException;

    /**
     * find user's orders according to current page number
     * @param curPage
     * @param pageSize
     * @param user
     * @return List
     * @throws SQLException
     */
    public List<Order> findOrdersByUser(int curPage, int pageSize, User user) throws SQLException;

    /**
     * find order item by order
     * @param order
     * @return List
     * @throws SQLException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public List<OrderItem> findOrderItemByOrder(Order order) throws SQLException, InvocationTargetException, IllegalAccessException;

    /**
     * count orders by user
     * @param user
     * @return
     * @throws SQLException
     */
    public long countOrderByUser(User user) throws SQLException;

    /**
     * update order
     * @param order
     * @throws SQLException
     */
    public void updateOrder(Order order) throws SQLException;

}
