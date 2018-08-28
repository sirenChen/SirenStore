package controller;

import core.BaseServlet;
import entity.Category;
import entity.PageBean;
import entity.Product;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import service.CategoryService;
import service.ProductService;
import utils.CookieUtil;
import core.MyBeanFactory;
import utils.UUIDUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Siren Chen.
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends BaseServlet {
    private ProductService pService = (ProductService) MyBeanFactory.getImplClass("ProductService");
    private CategoryService cService = (CategoryService) MyBeanFactory.getImplClass("CategoryService");
    /**
     * show product information
     * @param request
     * @param response
     * @return /jsp/product/product_info.jsp
     */
    public String showProductInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Cookie visitList = CookieUtil.getCookieByName("visitList", request.getCookies());
        String pid = request.getParameter("pid");

        Product product = pService.findProductById(pid);
        visitList = pService.add2VisitList(pid, visitList);


        response.addCookie(visitList);
        request.setAttribute("product", product);
        return "/jsp/product/product_info.jsp";
    }

    /**
     * show product list by category
     * @param request
     * @param response
     * @return /jsp/product/product_list.jsp
     */
    public String showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Cookie visitList = CookieUtil.getCookieByName("visitList", request.getCookies());
        String cid = request.getParameter("cid");
        String curPage = request.getParameter("curPage");

        Category category = cService.findCategoryById(cid);
        PageBean pageBean = pService.findProductsByCategory(Integer.parseInt(curPage), Integer.parseInt(cid));
        String[] products = pService.getVisitList(visitList);

        List<Product> visited = new ArrayList<>();
        if (products != null) {
            for (String product : products) {
                visited.add(pService.findProductById(product));
            }
        }

        request.setAttribute("category", category);
        request.setAttribute("visitList", visited);
        request.setAttribute("page", pageBean);
        return "/jsp/product/product_list.jsp";
    }


    /**
     * add a product.  Still in BETA edition...
     * @param request
     * @param response
     * @return
     */
    public String addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException, InvocationTargetException, IllegalAccessException, FileUploadException {
        String id = UUIDUtil.genId();

        HashMap<String, Object> map = new HashMap<>();
        Product product = new Product();

        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);

        List<FileItem> list = upload.parseRequest(request);
        for (FileItem fileItem : list) {
            if (fileItem.isFormField()) {

                map.put(fileItem.getFieldName(), fileItem.getString("utf-8"));

            } else {

                String path = this.getServletContext().getRealPath("/img");

                InputStream is = fileItem.getInputStream();

                FileOutputStream fs = new FileOutputStream(new File(path, id+".jpg"));

                IOUtils.copy(is, fs);
                is.close();
                fs.close();
                fileItem.delete();

                map.put(fileItem.getFieldName(), "/img/"+id+".jpg");
            }
        }

        BeanUtils.populate(product, map);
        product.setPdate(new Date());
        product.setPid(id);

        pService.addProduct(product);

        return null;
    }
}
