package pl.sdacademy.userdb;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class SessionService {

    private static SessionService instance;
    private HashMap<String, User> session;

    private SessionService() {
        session = new HashMap();
    }

    public static synchronized SessionService getInstance() {
        if (instance == null)
            instance = new SessionService();
        return instance;
    }

    public String createUserSession(User user) {
        String sessionId = generateSessionId();
        session.put(sessionId, user);
        return sessionId;
    }

    private String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    public User getUser(String token) {
        return session.get(token);
    }
}
