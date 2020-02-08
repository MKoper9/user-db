package pl.sdacademy.userdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserRepository userRepository;
    private SessionService sessionService;

    public LoginServlet() {
        userRepository = UserRepositoryFactory.getInstance();
        sessionService = SessionService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        List<User> users = userRepository.getUsers();

        User matchingUser = null;
        for (User user : users) {
            if (user.credentialsMatch(login, password)) {
                matchingUser = user;
                break;
            }
        }
        if (matchingUser != null) {
            String token = createSession(matchingUser);
            resp.sendRedirect("token-web?token=" + token);
        } else {
            resp.sendRedirect("login?error=true");
        }

        /*userRepository.getUsers()
                .stream()
                .filter(user -> user.credentialsMatch(login, password))
                .findAny().ifPresentOrElse(user ->
                createSession(), () -> handleError(resp));*/
    }

    /*private void handleError(HttpServletResponse resp) {
        try {
            resp.sendRedirect("login?error=true");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    private String createSession(User user) {
        return sessionService.createUserSession(user);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
