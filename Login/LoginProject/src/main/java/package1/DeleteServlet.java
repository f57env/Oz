package package1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    UserDAO dao = new UserDAO();

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

        User user = dao.getUserByEmail(email);

        if (user != null) {

            dao.deleteUser(user.getId());

        }

        session.invalidate();

        response.sendRedirect("index.html");

    }

}