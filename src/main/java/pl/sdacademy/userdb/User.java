package pl.sdacademy.userdb;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String login;
    private String password;
    private String name;
    private String lastName;
    private String phoneNumber;

    public boolean credentialsMatch(String login, String password) {
        return getLogin().equals(login) && getPassword().equals(password);
    }
}
