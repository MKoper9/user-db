package pl.sdacademy.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet("/cookies/read")
public class UserInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CookieKeyValue> cookiesFromRequest = Stream
			.of(req.getCookies())
			.map(cookie -> new CookieKeyValue(cookie
				.getName(), cookie.getValue()))
			.collect(Collectors.toList());
		req.setAttribute("cookies", cookiesFromRequest);
		req.getRequestDispatcher("/userInfo.jsp").forward(req, resp);
	}

}
