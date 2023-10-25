import registration.RegistrationProcess;
import security.AuthenticationProcess;
import java.sql.SQLException;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Sign up, 2 - Log in");
        int choice = scan.nextInt();
        if (choice == 1) {
        RegistrationProcess reg = new RegistrationProcess();
        reg.run();
            try {
                if (AuthenticationProcess.isIdentified()) {
                    System.out.println("Okay");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
}
        if (choice == 2) {
            try {
                if (AuthenticationProcess.isIdentified()) {
                    System.out.println("Ok");
                } else {
                    System.out.println("failed reg");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
