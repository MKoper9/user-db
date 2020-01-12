package pl.sdacademy.userdb;

import java.util.List;

public class UserRepositoryFactory {
    public static UserRepository getInstance() {
        return new UserRepository() {
            @Override
            public void save(User user) {

            }

            @Override
            public List<User> getUsers() {
                return null;
            }
        };
    }
}
