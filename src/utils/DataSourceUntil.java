package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Siren Chen on 2017/1/12.
 * Utils for database connection pool
 */
public class DataSourceUntil {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    /**
     * get connection from thread
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = threadLocal.get();

        if (conn == null) {
            conn = dataSource.getConnection();
            threadLocal.set(conn);
        }

        return conn;
    }

    /**
     * get data source
     * @return
     */
    public static DataSource getDataSource () {
        return dataSource;
    }

    /**
     * start transaction
     * @throws SQLException
     */
    public static void startTransaction() throws SQLException {
        getConnection().setAutoCommit(false);
    }

    /**
     * transaction commit and close connection
     * @throws SQLException
     */
    public static void commitAndClose() throws SQLException {
        Connection conn = getConnection();

        //commit
        conn.commit();
        //close
        conn.close();
        //remove from thread
        threadLocal.remove();
    }

    /**
     * transaction roll back and close connection
     * @throws SQLException
     */
    public static void rollbackAndClose() throws SQLException {
        Connection conn = getConnection();

        //roll back
        conn.rollback();
        //close
        conn.close();
        //remove from thread
        threadLocal.remove();

    }

    /**
     * close resource
     * @param stmt
     * @param rs
     */
    public static void closeResource( Statement stmt, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(stmt);
    }

    /**
     * close resource
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void closeResource(Connection conn, Statement stmt, ResultSet rs) {
        closeResource(stmt, rs);
        closeConn(conn);
    }

    // close connection
    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                threadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    // close statement
    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
    }

    // close result set
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
    }


}
