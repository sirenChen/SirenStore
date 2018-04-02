package dao.impl;

import dao.OrderDao;
import entity.Product;
import entity.User;
import entity.order.Order;
import entity.order.OrderItem;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUntil;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Siren Chen.
 */
public class OrderDaoImpl implements OrderDao {

    @Override
    public void insertOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (oid, total, orderTime, state, receiverAdd, receiverName, receiverPhone, uid) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        QueryRunner qr = new QueryRunner();
        qr.update(DataSourceUntil.getConnection(),sql, order.getOid(), order.getTotal(), order.getOrderTime(),
                order.getState(), order.getReceiverAdd(), order.getReceiverName(), order.getReceiverPhone(), order.getUser().getUid());
    }

    @Override
    public void insertOrderItem(OrderItem orderItem) throws SQLException {
        String sql = "INSERT INTO orderItem (ooid, quantity, subtotal, pid, oid) VALUES (?,?,?,?,?)";

        QueryRunner qr = new QueryRunner();
        qr.update(DataSourceUntil.getConnection(),sql, orderItem.getOoid(), orderItem.getQuantity(),
                orderItem.getSubtotal(),orderItem.getProduct().getPid(), orderItem.getOrder().getOid());
    }

    @Override
    public Order findOrderById(String oid) throws SQLException {
        String sql = "SELECT * FROM orders WHERE oid=?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        return qr.query(sql, new BeanHandler<Order>(Order.class), oid);
    }

    @Override
    public List<Order> findOrdersByUser(int curPage, int pageSize, User user) throws SQLException {
        String sql = "SELECT * FROM orders WHERE uid=? ORDER BY orderTime DESC limit ?,?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        return qr.query(sql, new BeanListHandler<Order>(Order.class),
                user.getUid(), (curPage-1)*pageSize, pageSize);
    }

    @Override
    public List<OrderItem> findOrderItemByOrder(Order order) throws SQLException, InvocationTargetException, IllegalAccessException {
        String sql = "SELECT * FROM orderItem oi, product p WHERE oi.pid = p.pid AND oi.oid=?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());

        List<Map<String, Object>> maps = qr.query(sql, new MapListHandler(), order.getOid());
        List<OrderItem> orderItems = new ArrayList<>();

        // encapsulating product and order item
        for (Map map : maps) {
            Product product = new Product();
            OrderItem orderItem = new OrderItem();

            BeanUtils.populate(product, map);
            BeanUtils.populate(orderItem, map);

            orderItem.setProduct(product);
            orderItem.setOrder(order);

            orderItems.add(orderItem);
        }

        return orderItems;
    }

    @Override
    public long countOrderByUser (User user) throws SQLException {
        String sql = "SELECT COUNT(*) FROM orders WHERE uid=?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        return (long) qr.query(sql, new ScalarHandler(), user.getUid());
    }


    public void updateOrder(Order order) throws SQLException {
        String sql = "UPDATE orders SET state=?, receiverAdd=?, receiverName=?, receiverPhone=? WHERE oid=?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        qr.update(sql, order.getState(), order.getReceiverAdd(), order.getReceiverName(), order.getReceiverPhone(), order.getOid());
    }

}
