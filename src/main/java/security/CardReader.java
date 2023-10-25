package security;
import data.BankDBManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardReader extends BankDBManager {
    static ResultSet result;
    public static boolean isExist(long userID){
        String query = "SELECT COUNT(*) FROM users WHERE user_id = ?";
        result = executeQuery(query, userID);
        try {
            if (result.next()) {
                int count = result.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeConnection();
        return false;
    }
}
