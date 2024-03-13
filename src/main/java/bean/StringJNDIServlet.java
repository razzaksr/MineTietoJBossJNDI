package bean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
the following command has executed in terminal of jboss via ./jboss-cli.sh then, connect,
before all run script shell standalone in bin folder of jboss

/subsystem=naming/binding=java\:\/YourStringResource:add(binding-type=simple, type=java.lang.String, value="YourStringValue")

 */

@WebServlet("/str/")
public class StringJNDIServlet extends HttpServlet {

//    @Resource(name = "java:/custom/MyCustomResource")
//    private String reference;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(reference);
//        resp.getWriter().println(reference);
        Context ctx = null;
        try {
//            ctx = new InitialContext();
//            Context context1 = (Context)ctx.lookup("java:comp/env");
//            MyPOJO simplePOJO = (MyPOJO) context1.lookup("jdbc/MyPOJO");
//            resp.getWriter().println(simplePOJO.getMessage());
            ctx = new InitialContext();
//            String customResource = (String) ctx.lookup("java:/YourStringResource");
            //String customResource = (String) ctx.lookup(getInitParameter("custom"));
//            String customResource = (String) ctx.lookup("java:/OurStringResource");
            String customResource = (String) ctx.lookup("java:/GuiBasedString");
            System.out.println(customResource);
            resp.getWriter().println(customResource);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }


    }
}
