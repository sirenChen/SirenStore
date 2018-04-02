package dao.impl;

import dao.ProductDao;
import entity.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUntil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siren Chen.
 */
public class ProductDaoImpl implements ProductDao {

    @Override
    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO product (pid, pname, price, pimage, pdate, pdesc, pflag, isHot, cid) " +
                "VALUES (?,?,?,?,?,?,1,?,?)";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        qr.update(sql, product.getPid(), product.getPname(), product.getPrice(), product.getPimage(),
                product.getPdate(), product.getPdesc(), product.getIsHot(), product.getCid());
    }

    @Override
    public Product findProductById(String pid) throws SQLException {
        String sql = "SELECT * FROM product WHERE pid=?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        return qr.query(sql, new BeanHandler<Product>(Product.class), pid);
    }

    @Override
    public List<Product> findProductsByCategory(int page, int limit, int cid) throws SQLException {
        String sql = "SELECT * FROM product WHERE cid=? limit ?,?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        return qr.query(sql, new BeanListHandler<Product>(Product.class), cid, (page-1)*limit, limit);
    }

    @Override
    public List<Product> findNewProducts() throws SQLException {
        String sql = "SELECT * FROM product ORDER BY pdate limit 3";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        return qr.query(sql, new BeanListHandler<Product>(Product.class));
    }

    @Override
    public List<Product> findHotProducts () throws SQLException {
        String sql = "SELECT * FROM product WHERE isHot = 1";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        return qr.query(sql, new BeanListHandler<Product>(Product.class));
    }

    public long countProduct(int cid) throws SQLException {
        String sql = "SELECT COUNT(*) FROM product WHERE cid=?";

        QueryRunner qr = new QueryRunner(DataSourceUntil.getDataSource());
        return (long) qr.query(sql, new ScalarHandler(), cid);
    }



}
