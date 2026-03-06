package WindowApp;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    public Login(){
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("C:\\Users\\DELL\\Pictures\\Screenshots\\Screenshot 2025-03-01 132517.png");
        setIconImage(icon.getImage());
        setBackground(Color.GREEN);

        JLabel email = new JLabel("Enter your Email");
        JTextField emil = new JTextField(10);
        add(emil);
        add(email);

        setBackground(Color.DARK_GRAY);

        JLabel pass = new JLabel("Enter your Password");
        JTextField word = new JTextField(10);
        add(pass);
        add(word);


        JButton next = new JButton("Next");
        add(next);

       next.addActionListener(e -> {
            new HomePage();//Open Second framework
            setVisible(false);
        });
        setVisible(true);
    }
}
