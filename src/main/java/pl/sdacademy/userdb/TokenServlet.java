package pl.sdacademy.userdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/token-web")
public class TokenServlet extends HttpServlet {

    private SessionService sessionService = SessionService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("token");
        req.setAttribute("token", token);
        req.setAttribute("user", sessionService.getUser(token));
        req.getRequestDispatcher("token-web.jsp").forward(req, resp);
    }

}
