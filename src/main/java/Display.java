import javax.swing.*;
import java.awt.*;

public class Display {
    public static void run() {
        JFrame frame =  createFrame(1000, 540);
        JLabel title = createLabel("Welcome to ATM!", 46);
        JFrame frame2 = createFrame(1000, 540);
        JPanel panel = new JPanel(new GridLayout(2,2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20, 20, 20));

        JLabel label1 = createLabel("Account id", 50);
        JTextField id = createTextField(50);
        JLabel label2 = createLabel("Password", 50);
        JTextField password = createTextField(50);

        panel.add(label1);
        panel.add(id);

  /* panel.add(label2);
  panel.add(password);

   */

        JPanel panel2 = new JPanel(new GridLayout(1, 2, 10, 10));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JButton login = createButton("Login", 48);
        // JButton createAccount = createButton("Create Account", 48);
        panel2.add(login);
        /* panel2.add(createAccount);

         */

        frame.add(title, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setVisible(true);



    }



    public static JFrame createFrame(int width, int height) {
        JFrame frame = new JFrame("ATM");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.DARK_GRAY);
        return frame;
    }

    public static JLabel createLabel(String text, int size) {
        JLabel title1 = new JLabel(text);
        title1.setFont(new Font("Times New Roman", Font.BOLD, size));
        title1.setBackground(null);
        title1.setOpaque(false);
        title1.setForeground(Color.DARK_GRAY);
        title1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        return title1;
    }

    public static JTextField createTextField(int size) {
        JTextField tField = new JTextField();
        tField.setFont(new Font("Times New Roman", Font.BOLD, size));
        tField.setForeground(Color.DARK_GRAY);
        tField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tField.setHorizontalAlignment(SwingConstants.CENTER);
        return tField;

    }

    public static JButton createButton(String text, int size) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.BOLD, size));
        button.setForeground(Color.darkGray);
        button.setBackground(Color.white);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }
}

