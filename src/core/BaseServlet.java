package core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * Created by Siren Chen.
 * My base servlet, all other servlet should extends this servlet.
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // get sub class
            Class clazz = this.getClass();

            // get method
            String m = req.getParameter("method");
            if (m == null) {
                m = "index";
            }

            // get method object
            Method method = clazz.getMethod(m, HttpServletRequest.class, HttpServletResponse.class);

            // execute method
            String path = (String) method.invoke(this, req, resp);

            // determine if need redirect
            if (path != null) {
                req.getRequestDispatcher(path).forward(req,resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public String index (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        return null;
    }

}
