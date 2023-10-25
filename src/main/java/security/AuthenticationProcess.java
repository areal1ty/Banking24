package security;
import java.sql.SQLException;
import java.util.Scanner;

public class AuthenticationProcess {
    public static boolean isIdentified() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bank account:");
        long id = scan.nextLong();
        boolean idExist = CardReader.isExist(id);
        if (idExist) {
            PasswordVerifier verifier = new PasswordVerifier();
            System.out.println("Password:");
            String pin = scan.nextLine();
            return verifier.isVerified(pin, id);
        } else {
            System.out.println("Please try again, acc don't exits");
            isIdentified();
        } return false;
    }
}
