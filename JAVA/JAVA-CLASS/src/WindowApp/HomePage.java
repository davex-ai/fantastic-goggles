package WindowApp;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {
    public HomePage(){
        setTitle("HomePage");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());// for what
        ImageIcon icon = new ImageIcon("C:\\Users\\DELL\\Downloads\\download.jpg");
        setIconImage(icon.getImage());
        setBackground(Color.PINK);

        JLabel label = new JLabel("Welcome to the Titan Website ☺️");
        add(label);

        JLabel lb = new JLabel("Terms and Conditions Apply ");
        add(lb);

        JButton reg = new JButton("Register");
        add(reg);

        JButton lo = new JButton("Login");
        add(lo);

        reg.addActionListener(e -> {
            new Register();
            setVisible(false);
        });

        lo.addActionListener(e -> {
            new Login();
            setVisible(false);
        });
        setVisible(true);



    }

}