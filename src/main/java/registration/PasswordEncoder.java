package registration;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordEncoder {
    public static String hash(String usersPassword) {
        return BCrypt.withDefaults().hashToString(4, usersPassword.toCharArray());
    }
}
