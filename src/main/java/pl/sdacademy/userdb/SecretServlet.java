package pl.sdacademy.userdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/secured/secret")
public class SecretServlet extends HttpServlet {

//    private SessionService sessionService = SessionService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/secretWeb.jsp").forward(req, resp);

  /*      String token = req.getParameter("token");
        User user = sessionService.getUser(token);

        if (user != null) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("secretWeb.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login");
        }*/
    }
}
