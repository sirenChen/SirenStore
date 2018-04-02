package entity.order;

import entity.User;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Siren Chen.
 * this class is map to the orders table
 */
public class Order implements Serializable {
    private String oid;
    private double total;
    private Date orderTime;
    private int state = 0;     // 0: not paid, 1:paid

    private String receiverAdd;
    private String receiverName;
    private String receiverPhone;

    // belong to which user
    private User user;
    // contain what order item
    private List<OrderItem> orderItems = new LinkedList<>();

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getReceiverAdd() {
        return receiverAdd;
    }

    public void setReceiverAdd(String receiverAdd) {
        this.receiverAdd = receiverAdd;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
