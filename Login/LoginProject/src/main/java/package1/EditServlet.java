package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    UserDAO dao = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session==null || session.getAttribute("email")==null){
            response.sendRedirect("login");
            return;
        }

        String email=(String)session.getAttribute("email");

        User user=dao.getUserByEmail(email);

        response.setContentType("text/html");

        PrintWriter out=response.getWriter();

        out.println("<html><head><title>Edit Profile</title>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:#f2f2f2;}");
        out.println(".box{width:450px;margin:40px auto;background:white;padding:20px;border-radius:8px;}");
        out.println("input{width:100%;padding:10px;margin:10px 0;}");
        out.println("button{width:100%;padding:10px;background:green;color:white;border:none;}");
        out.println("</style>");

        out.println("</head><body>");

        out.println("<div class='box'>");

        out.println("<h2>Edit Profile</h2>");

        out.println("<form method='post'>");

        out.println("<input type='hidden' name='id' value='"+user.getId()+"'>");

        out.println("<label>Name</label>");
        out.println("<input type='text' name='name' value='"+user.getName()+"'>");

        out.println("<label>Email</label>");
        out.println("<input type='email' name='email' value='"+user.getEmail()+"'>");

        out.println("<label>Phone</label>");
        out.println("<input type='text' name='phone' value='"+user.getPhone()+"'>");

        out.println("<label>Salary</label>");
        out.println("<input type='text' value='"+user.getSalary()+"' readonly>");

        out.println("<label>Designation</label>");
        out.println("<input type='text' value='"+user.getDesignation()+"' readonly>");

        out.println("<button>Update</button>");

        out.println("</form>");

        out.println("</div>");

        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        User user=new User();

        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));

        dao.updateUser(user);

        HttpSession session=request.getSession();

        session.setAttribute("email", user.getEmail());

        response.sendRedirect("profile");

    }

}