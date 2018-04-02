package service;

import entity.User;

import java.sql.SQLException;

/**
 * Created by Siren Chen.
 */
public interface UserService {

    /**
     * register the user
     * @param user User entity
     * @throws SQLException
     */
    public void register(User user) throws SQLException;

    /**
     * login
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public User login(String username, String password) throws SQLException;

    /**
     * active the user
     * @param activeCode
     * @return
     * @throws SQLException
     */
    public User activeUser(String activeCode) throws SQLException;

    /**
     * check if the username is available
     * @return
     * @throws SQLException
     */
    public boolean isUsernameOK(String username) throws SQLException;

}
