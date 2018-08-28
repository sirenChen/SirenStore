package controller;

import core.BaseServlet;
import core.MyBeanFactory;
import entity.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.String2DateConvert;
import utils.UUIDUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Siren Chen.
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends BaseServlet {
    private UserService uService = (UserService) MyBeanFactory.getImplClass("UserService");

    /**
     * forward to register page
     * @param request
     * @param response
     * @return
     */
    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/jsp/user/register.jsp";
    }

    /**
     * forward to login page
     * @param request
     * @param response
     * @return
     */
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/jsp/user/login.jsp";
    }

    /**
     * do register
     * @param request
     * @param response
     * @return
     */
    public String doRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, InvocationTargetException, IllegalAccessException {
        String username = request.getParameter("username");

        if (! uService.isUsernameOK(username)) {

            request.setAttribute("registerMsg", "username is taken, please choose another username");
            return "/jsp/user/register.jsp";
        }


        User user = new User();

        ConvertUtils.register(new String2DateConvert(), Date.class); // register convert,
        BeanUtils.populate(user, request.getParameterMap());  // get data
        user.setUid(UUIDUtil.genId());
        user.setActiveCode(UUIDUtil.genCode());
        ConvertUtils.deregister(Date.class);

        uService.register(user);

        request.setAttribute("msg", "Thanks...");
        return "/jsp/msg.jsp";
    }

    /**
     * do login
     * @param request
     * @param response
     * @return
     */
    public String doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = uService.login(username, password);

        if (user == null) {
            request.setAttribute("loginMsg", "wrong username or password");
            return "/jsp/user/login.jsp";
        }

        request.getSession().setAttribute("user", user);
        request.setAttribute("msg", "Login Success");
        return "/jsp/msg.jsp";
    }

    /**
     * do logout
     * @param request
     * @param response
     * @return
     */
    public String doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();

        request.setAttribute("msg", "Logout success");
        return "/jsp/msg.jsp";
    }

    /**
     * do active
     * @param request
     * @param response
     * @return
     */
    public String doActive (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String activeCode = request.getParameter("activeCode");

        User user = uService.activeUser(activeCode);

        if (user == null) {
            request.setAttribute("msg", "Wrong active code");
        } else {
            request.setAttribute("msg", "active done");
        }

        return "/jsp/msg.jsp";
    }
}
