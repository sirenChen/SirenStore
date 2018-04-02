package dao;

import entity.User;

import java.sql.SQLException;

/**
 * Created by Siren Chen.
 */
public interface UserDao {

    /**
     * add user
     * @param user
     * @throws SQLException
     */
    public void addUser(User user) throws SQLException;

    /**
     * update user
     * @param user
     * @throws SQLException
     */
    public void updateUser(User user) throws SQLException;

    /**
     * find user by active code
     * @param activeCode
     * @return
     * @throws SQLException
     */
    public User findUserByActiveCode(String activeCode) throws SQLException;

    /**
     * find user by username and password
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public User findUserByNameAndPassword(String username, String password) throws SQLException;

    /**
     * find user by username
     * @param username
     * @return
     * @throws SQLException
     */
    public User findUserByUsername(String username) throws SQLException;
}
