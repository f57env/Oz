package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("email") == null) {
            response.sendRedirect("login.html");
            return;
        }

        String email = (String) session.getAttribute("email");

        UserDAO dao = new UserDAO();

        User user = dao.getUserByEmail(email);

        if (user == null) {
            session.invalidate();
            response.sendRedirect("login.html");
            return;
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Profile</title>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:#f4f4f4;}");
        out.println(".container{width:500px;margin:60px auto;background:white;padding:25px;border-radius:8px;box-shadow:0 0 10px gray;}");
        out.println("table{width:100%;border-collapse:collapse;}");
        out.println("td{padding:12px;border:1px solid #ddd;}");
        out.println(".btn{padding:10px 20px;text-decoration:none;color:white;border-radius:5px;margin-right:10px;display:inline-block;}");
        out.println(".edit{background:#28a745;}");
        out.println(".delete{background:#dc3545;}");
        out.println(".logout{background:#007bff;}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='container'>");

        out.println("<h2 align='center'>Employee Profile</h2>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<td><b>Name</b></td>");
        out.println("<td>" + user.getName() + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td><b>Email</b></td>");
        out.println("<td>" + user.getEmail() + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td><b>Phone</b></td>");
        out.println("<td>" + user.getPhone() + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td><b>Salary</b></td>");
        out.println("<td>" + user.getSalary() + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td><b>Designation</b></td>");
        out.println("<td>" + user.getDesignation() + "</td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("<br>");

        out.println("<a class='btn edit' href='edit'>Edit</a>");

        out.println("<a class='btn delete' href='delete' onclick=\"return confirm('Delete Account?');\">Delete</a>");

        out.println("<a class='btn logout' href='logout'>Logout</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}