package bean;

//import org.example.Insurance;
//import org.example.InsuranceFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insurance/")
public class InsuranceJNDIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Context context=new InitialContext();
            //Insurance insurance = (Insurance) context.lookup("java:/Insure");
            //String str= (String) context.lookup("java:/YourStringResource");
            //System.out.println(insurance);
            //System.out.println(str);
        }
        catch(NamingException namingException){
            namingException.printStackTrace();
        }
    }
}
