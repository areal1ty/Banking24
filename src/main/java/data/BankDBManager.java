package data;
import java.sql.*;

public abstract class BankDBManager {
    private static Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/bank_accounts";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = " ";
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD")
    public BankDBManager() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query, Object... params) {
        ResultSet res = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            res = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void executeUpdate(String query, Object... params) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void usersInsert(long userID, String password, Date registrationDate ) {
        String query = "INSERT INTO users (user_id, password_hash, role, registration_date) VALUES (?,?,?,?);";
        executeUpdate(query, userID, password, "user", registrationDate);
    }

    public void infoInsert(long userID, String holder, Date registrationDate) {
        String query = "INSERT INTO accounts_info (user_id, account_type, balance, holder, opening_date) VALUES (?, ?, ?, ?, ?);";
        executeUpdate(query, userID, "saving", 0.00, holder, registrationDate);
    }
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
