package pl.sdacademy.userdb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepositoryFactory {

    private static List<User> users = defaultUsers();

    private static List<User> defaultUsers() {
        return Arrays.asList(new User("user", "user", "George", "Martin", "+1666666666"));
    }

    public static UserRepository getInstance() {
        return new UserRepository() {
            @Override
            public void save(User user) {
                users.add(user);
            }

            @Override
            public List<User> getUsers() {
                return users;
            }
        };
    }
}
