package registration;
import data.BankDBManager;
import security.CardReader;
import java.security.SecureRandom;
import java.sql.Date;
import java.time.Instant;

public class UserRegistrationController extends BankDBManager {

    public static long generateID() {
        SecureRandom random = new SecureRandom();
        long currentTimeMillis = Instant.now().toEpochMilli();
        long randomV = random.nextInt(90000000) + 11111111;
        long result = (currentTimeMillis << 32) | (randomV & 0xFFFFFFFFL);
        return result % 100000000L;
    }

    public void saveUserData(String holder, String password, Date registrationDate) {
        long userID = generateID();
        usersInsert(userID, password, registrationDate);
        infoInsert(userID, holder, registrationDate);
        if (!CardReader.isExist(userID)) {
            System.out.println("error");
        } else System.out.println("ok");
    }



    /*
     public boolean registerUser(UserModel user) {
        // Validate user input
        // Insert user data into the database using DatabaseConnection
        // Return success or failure status
    }


// UserModel.java
public class UserModel {
    private String username;
    private String password;
    // Other user attributes and getters/setters
}

// DatabaseConnection.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

     */
}
