package bean;

/*
/subsystem=naming/binding=java\:global\/simple-integer-binding:add(binding-type=simple, type=int, value=100)
 */

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ints/")
public class IntJNDIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InitialContext context=new InitialContext();
            Integer found = (Integer) context.lookup("java:/YourIntegerResource");
            System.out.println(found);
            resp.getWriter().println("Found "+found);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
