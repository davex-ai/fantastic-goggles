package SwingGUI;

import javax.swing.*;
import java.awt.*;

 class FirstFrame extends JFrame {
    public FirstFrame(){
        // frame properties include title an example of title is line 7
        setTitle("FirstFrame");
        //we are setting the size in line 9
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());// for what

        JButton btnSecond = new JButton("Goto SecondFrame Frame");
        add(btnSecond);

        JButton btnThird = new JButton("Goto SecondFrame Frame");
        add(btnThird);
        //Performing event handling on the button
        // move from one page to another
        btnSecond.addActionListener(e -> {
            new SecondFrame();//Open second framework
            setVisible(false);
        });

        btnThird.addActionListener(e -> {
            new SecondFrame();//Open second framework
            setVisible(false);
        });
        setVisible(true);
    }
}