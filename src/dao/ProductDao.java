package dao;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siren Chen.
 */
public interface ProductDao {

    /**
     * add product
     * @param product
     * @throws SQLException
     */
    public void addProduct(Product product) throws SQLException;

    /**
     * find product by id
     * @param pid
     * @return Product
     * @throws SQLException
     */
    public Product findProductById(String pid) throws SQLException;

    /**
     * find products by category
     * @param curPage current page number
     * @param pageSize limit records per page
     * @param cid category id
     * @return
     * @throws SQLException
     */
    public List<Product> findProductsByCategory(int curPage, int pageSize, int cid) throws SQLException;

    /**
     * find new added products
     * @return
     * @throws SQLException
     */
    public List<Product> findNewProducts() throws SQLException;

    /**
     * find hot products
     * @return
     * @throws SQLException
     */
    public List<Product> findHotProducts() throws SQLException;

    /**
     * count product by category
     * @param cid category id
     * @return
     * @throws SQLException
     */
    public long countProduct(int cid) throws SQLException;
}
