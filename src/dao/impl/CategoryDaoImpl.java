package dao.impl;

import dao.CategoryDao;
import entity.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import utils.DataSourceUntil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siren Chen.
 */
public class CategoryDaoImpl implements CategoryDao {

    @Override
    public List<Category> queryAll() throws SQLException {
        String sql = "SELECT * FROM category";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());

        return qr.query(sql, new BeanListHandler<Category>(Category.class));
    }

    @Override
    public Category findCategoryById (int cid) throws SQLException {
        String sql = "SELECT * FROM category WHERE cid=?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());

        return qr.query(sql, new BeanHandler<Category>(Category.class), cid);
    }


    /**
     * use to test update a record with Chinese
     */
    @Test
    public void update() {
        String sql = "UPDATE category SET cdesc='我擦' WHERE cid=1";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        try {
            qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * use to test a select statement
     */
    @Test
    public void select() {
        String sql = "SELECT * FROM category WHERE cid=1";
        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());

        try {
            Category c = qr.query(sql, new BeanHandler<Category>(Category.class));
            System.out.println(c.getCdesc());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
