package security;
import at.favre.lib.crypto.bcrypt.BCrypt;
import data.BankDBManager;
import java.sql.ResultSet;

public class PasswordVerifier extends BankDBManager{
    private char[] getPassword(long id) {
        String query = "SELECT password_hash FROM users WHERE user_id = ?";
        ResultSet res = executeQuery(query, id);
        return res.toString().toCharArray();
    }

    public boolean isVerified(String userPassword, long id) {
        char[] password = userPassword.toCharArray();
        char[] realPassword = getPassword(id);
        BCrypt.Result result = BCrypt.verifyer().verify(password,realPassword);
        return result.verified;
    }
}
