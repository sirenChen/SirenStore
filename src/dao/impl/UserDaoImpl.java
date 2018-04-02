package dao.impl;

import dao.UserDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUntil;

import java.sql.SQLException;

/**
 * Created by Siren Chen.
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser (User user) throws SQLException {
        String sql = "INSERT INTO user (uid, username, password, gender, email, phone, activeCode, state, birthday, registerTime) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        qr.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getGender(), user.getEmail(), user.getPhone(),
                user.getActiveCode(), user.getState(), user.getBirthday(),user.getRegisterTime());

    }

    @Override
    public void updateUser (User user) throws SQLException {
        String sql = "UPDATE user SET username=?,password=?,gender=?,email=?,phone=?,activeCode=null, state=? WHERE uid=?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        qr.update(sql, user.getUsername(), user.getPassword(),user.getGender(),user.getEmail(), user.getPhone(),
                user.getState(), user.getUid());
    }

    @Override
    public User findUserByActiveCode (String activeCode) throws SQLException {
        String sql = "SELECT * FROM user WHERE activeCode=?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        return qr.query(sql, new BeanHandler<User>(User.class), new Object[]{activeCode});
    }

    @Override
    public User findUserByNameAndPassword (String username, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE username=? and password=?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        return qr.query(sql, new BeanHandler<User>(User.class), new Object[]{username, password});
    }

    @Override
    public User findUserByUsername (String username) throws SQLException {
        String sql = "SELECT * FROM user WHERE username=?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        return qr.query(sql, new BeanHandler<User>(User.class), username);
    }

}
