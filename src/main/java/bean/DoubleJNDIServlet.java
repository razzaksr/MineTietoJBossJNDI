package bean;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doubles/")
public class DoubleJNDIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InitialContext context=new InitialContext();
            Double experience = (Double) context.lookup("java:/MyExperience");
            resp.getWriter().println(experience);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }
}
