package pl.sdacademy.userdb;

public class UserValidator {

    public static void validate(User user, String confirmPassword) throws UserValidationException {
        try {
            user.getPassword().equals(confirmPassword);
        } catch (NullPointerException e) {
            throw new UserValidationException("Passwords cannot be null", e);
        }
        if (hasErrors()) {
            throw new UserValidationException("User validation failed");
        }
    }

    private static boolean hasErrors() {
        return false;
    }

}
