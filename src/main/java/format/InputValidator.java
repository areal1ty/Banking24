package format;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static boolean isPINValid(String pin) {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pin);
        return m.matches();
    }

    public static String nameFormatter(String name, String surname) {
        if (name.length() <= 1 || surname.length() <= 1 ||
                !name.matches("^[a-zA-Z]*$") || !surname.matches("^[a-zA-Z]*$"))
        {
            return "Error! Please enter a valid name.";
        }

        StringBuilder formattedName = new StringBuilder();
        surname = surname.toUpperCase();
        formattedName.append(Character.toUpperCase(name.charAt(0)))
                .append(name.substring(1).toLowerCase()).append(" ");
        name = formattedName.toString().trim();
        return surname + " " + name;
    }
}
