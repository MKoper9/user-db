package pl.sdacademy.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	public static final String NAME_FROM_SESSION = "nameFromSession";

	@Override
	protected void doPost(HttpServletRequest req,
			      HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		session.setAttribute(NAME_FROM_SESSION, name);
		resp.sendRedirect("session");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("nameSessionForm.jsp")
			.forward(req, resp);
	}
}
