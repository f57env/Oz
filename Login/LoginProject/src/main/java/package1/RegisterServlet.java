package package1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

    private static final long serialVersionUID=1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,IOException{

        UserDAO dao=new UserDAO();

        String email=request.getParameter("email");

        if(dao.emailExists(email)){

            response.sendRedirect("login.html");

            return;

        }

        User user=new User();

        user.setName(request.getParameter("name"));
        user.setEmail(email);
        user.setPassword(request.getParameter("password"));
        user.setPhone(request.getParameter("phone"));
        user.setSalary(Double.parseDouble(request.getParameter("salary")));
        user.setDesignation(request.getParameter("designation"));

        dao.register(user);

        response.sendRedirect("login.html");

    }

}