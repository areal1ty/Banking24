package registration;
import java.sql.Date;
import java.util.Scanner;
import format.InputValidator;
import security.AuthenticationProcess;
public class RegistrationProcess {
    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("name:");
        String name = scan.nextLine();
        System.out.println("surname:");
        String surname = scan.nextLine();
        String holder = InputValidator.nameFormatter(name,surname);
        System.out.println("password:");
        String password = scan.nextLine();
        if (InputValidator.isPINValid(password)) {
            UserRegistrationController controller = new UserRegistrationController();
            controller.saveUserData(holder,
                    PasswordEncoder.hash(password),
                    getCurrentDate());
        } else {
            System.out.println("not valid password");
            run();
        }
    }

    public static Date getCurrentDate() {
        java.util.Date date = new java.util.Date();
        return new Date(date.getTime());
    }
}
