package data.feedback.util;

import java.util.regex.Pattern;

public class ValidatorUtil {

    // Email regex
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    // Password regex
    // Minimum 8 chars
    // 1 uppercase
    // 1 lowercase
    // 1 digit
    // 1 special character
    private static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&^#()_\\-+=])[A-Za-z\\d@$!%*?&^#()_\\-+=]{8,}$";

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile(EMAIL_REGEX);

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(PASSWORD_REGEX);

    // Validate email
    public static boolean isValidEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        return EMAIL_PATTERN.matcher(email).matches();
    }

    // Validate password
    public static boolean isValidPassword(String password) {

        if (password == null || password.trim().isEmpty()) {
            return false;
        }

        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
