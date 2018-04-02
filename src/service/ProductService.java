package service;

import entity.PageBean;
import entity.Product;

import javax.servlet.http.Cookie;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siren Chen.
 */
public interface ProductService {

    /**
     * add a product
     * @param product
     * @throws SQLException
     */
    public void addProduct(Product product) throws SQLException;

    /**
     * find new added products
     * @return
     * @throws SQLException
     */
    public List<Product> findNew() throws SQLException;

    /**
     * find hot products
     * @return
     * @throws SQLException
     */
    public List<Product> findHot() throws SQLException;

    /**
     * find product by id
     * @param pid
     * @return
     * @throws SQLException
     */
    public Product findProductById(String pid) throws SQLException;

    /**
     * find products by category
     * @param curPage
     * @param cid category id
     * @return
     * @throws SQLException
     */
    public PageBean findProductsByCategory(int curPage, int cid) throws SQLException;

    /**
     * add a product to visited list
     * @param pid
     * @param cookie
     * @return
     */
    public Cookie add2VisitList(String pid, Cookie cookie);

    /**
     * get the vilisted list
     * @param cookie
     * @return
     */
    public String[] getVisitList(Cookie cookie);

}
