package web.servlet;

import core.BaseServlet;
import core.MyBeanFactory;
import entity.Product;
import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;
import utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siren Chen.
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends BaseServlet {
    private ProductService pService = (ProductService) MyBeanFactory.getImplClass("ProductService");
    private CategoryService cService = (CategoryService) MyBeanFactory.getImplClass("CategoryService");


    /**
     *
     * @param request
     * @param response
     * @return /jsp/index.jsp
     */
    public String index (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Product> hotList = pService.findHot();

        request.setAttribute("hotList", hotList);
        return "/jsp/index.jsp";
    }

    /**
     * find all category
     * @param request
     * @param response
     * @return null
     */
    public String showCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List cList = cService.showAllCategory();

        String json = JsonUtil.list2json(cList);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(json);

        return null;
    }

}
