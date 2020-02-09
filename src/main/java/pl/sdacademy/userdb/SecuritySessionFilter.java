package pl.sdacademy.userdb;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Predicate;

public class SecuritySessionFilter extends HttpFilter {
    private SessionService sessionService = SessionService.getInstance();
    private Predicate<HttpServletRequest> predicate = FilterPredicates.predicateFor(SecuritySessionFilter.class);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (predicate.test(req)) {
            checkSecurity(req, res, chain);
        } else
            chain.doFilter(req, res);
    }

    private void checkSecurity(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String token = req.getParameter("token");
        User user = sessionService.getUser(token);

        if (user == null) {
            res.sendRedirect("/login");
        } else {
            req.setAttribute("user", user);
            chain.doFilter(req, res);
        }
    }
}
