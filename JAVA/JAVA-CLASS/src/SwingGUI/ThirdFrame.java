package SwingGUI;

import javax.swing.*;
import java.awt.*;

public class ThirdFrame extends JFrame {
    public ThirdFrame() {
        setTitle("ThirdFrame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnThird = new JButton("Goto Fist Frame");
        add(btnThird);

        btnThird.addActionListener(e -> {
            new FirstFrame();//Open Second framework
            setVisible(false);
        });
        setVisible(true);
    }
}