package WindowApp;

import javax.swing.*;
import java.awt.*;

public class Register extends JFrame{
    public Register(){
        setTitle("Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("C:\\Users\\DELL\\Pictures\\Screenshots\\Screenshot 2025-03-01 103806.png");
        setIconImage(icon.getImage());
        setBackground(Color.CYAN);

        JLabel name = new JLabel("What is your name");
        JTextField eld = new JTextField(10);
        add(name);
        add(eld);

        JLabel eLabel = new JLabel("Enter your Email");
        JTextField text = new JTextField(10);
        add(eLabel);
        add(text);

        JLabel nameLabel = new JLabel("How did you hear about us");
        JTextField nameField = new JTextField(10);
        add(nameLabel);
        add(nameField);

        JLabel address = new JLabel("May we know your address");
        JTextField adress = new JTextField(10);
        add(adress);
        add(address);

        JLabel abel = new JLabel("We need to know your Age");
        add(abel);
        JRadioButton adult = new JRadioButton("Yes, I'm 18+");
        JRadioButton child = new JRadioButton("No , I'm not up to 18");
        ButtonGroup age = new ButtonGroup();//A ButtonGroup (gender) ensures only one of the radio buttons can be selected at a time.
        age.add(child);
        age.add(adult);
        add(child);
        add(adult);

        JButton bun = new JButton("Next");
        add(bun);
        bun.addActionListener(e -> {
            new HomePage();
            setVisible(false);
        });

        JButton btnSecond = new JButton("Login");
        add(btnSecond);

        btnSecond.addActionListener(e -> {
            new Login();
            setVisible(false);
        });
        setVisible(true);
    }
}
