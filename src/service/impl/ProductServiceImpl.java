package service.impl;

import dao.ProductDao;
import entity.PageBean;
import entity.Product;
import org.apache.commons.lang.StringUtils;
import service.ProductService;
import core.MyBeanFactory;

import javax.servlet.http.Cookie;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siren Chen.
 */
public class ProductServiceImpl implements ProductService {
    private ProductDao pdao = (ProductDao) MyBeanFactory.getImplClass("ProductDao");

    private static final int PAGE_SIZE = 4;

    @Override
    public void addProduct(Product product) throws SQLException {
        pdao.addProduct(product);
    }

    @Override
    public List<Product> findNew() throws SQLException {
        return pdao.findNewProducts();
    }

    @Override
    public List<Product> findHot() throws SQLException {
        return pdao.findHotProducts();
    }

    @Override
    public Product findProductById(String pid) throws SQLException {
        return pdao.findProductById(pid);
    }

    @Override
    public PageBean<Product> findProductsByCategory(int curPage, int cid) throws SQLException {
        PageBean<Product> pageBean = new PageBean();

        pageBean.setPageSize(PAGE_SIZE);
        pageBean.setTotalSize(pdao.countProduct(cid));

        pageBean.setCurPage(curPage);
        pageBean.setList(pdao.findProductsByCategory(curPage, PAGE_SIZE, cid));

        return pageBean;
    }

    @Override
    public Cookie add2VisitList (String pid, Cookie cookie) {
        Cookie visitList = null;

        if (cookie == null) {
            visitList = new Cookie("visitList", pid + "-");
        } else {
            visitList = cookie;
            String value = visitList.getValue();

            // if product is already in visited list
            if (value.contains(pid)) {
                value = value.replace(pid + "-", "");
            }
            String newValue = pid + "-" + value;

            // always keep 5 products in the visited list
            int pos = StringUtils.ordinalIndexOf(newValue, "-", 5);
            if (pos == -1) {
                visitList.setValue(newValue);
            } else {
                visitList.setValue(newValue.substring(0, pos));
            }
        }

        return visitList;
    }

    @Override
    public String[] getVisitList(Cookie cookie) {
        String[] products = null;

        if (cookie != null) {
            String visitList = cookie.getValue();
            products = visitList.split("-");
        }

        return products;
    }

}
