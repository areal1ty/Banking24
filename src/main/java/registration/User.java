package registration;
import java.math.BigDecimal;
import java.sql.Date;

public class User {
    private final String userID;
    private String password;
    private String salt;
    private String role;
    private String accountType;
    private String holder;
    private Date registrationDate;
    private BigDecimal balance;

    public User(String ID, String passwordHash, String salt, String role, String accountType, String holderName, Date registrationDate, BigDecimal balance) {
        this.userID = ID;
        this.password = passwordHash;
        this.salt = salt;
        this.role = role;
        this.accountType = accountType;
        this.holder = holderName;
        this.registrationDate = registrationDate;
        this.balance = balance;
    }

    /*
    private final String UUID;
    private static byte[] PIN;
    private final ArrayList<Account> accounts;

    public User(String firstName, String lastName, String PIN, Bank theBank) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            User.PIN = md.digest(PIN.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error, NoSuchAlgorithmException");
            throw new RuntimeException(e);
        }

        this.UUID = theBank.getNewUUID();
        this.accounts = new ArrayList<>();
        System.out.printf("New user %s %s with ID %s is created", lastName, firstName, this.UUID);
    }

    /**
     * Add an account for the user
     *
     * @param account the account to add
     */

    /*
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public String getUUID() {
        return this.UUID;
    }

    public static boolean isPINValid(String PINCode) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(PINCode.getBytes()), PIN);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }
}
     */
}
