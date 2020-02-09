package pl.sdacademy.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookies/add")
public class AddCookiesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.addCookie(new Cookie("facebookLogin", "george_martin"));
		resp.addCookie(new Cookie("interests",
			"games_books_killing"));
		resp.sendRedirect("/cookies/read");
	}
}
