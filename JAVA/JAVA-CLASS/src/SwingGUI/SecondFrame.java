package SwingGUI;
import javax.swing.*;
import java.awt.FlowLayout;
public class SecondFrame extends JFrame {
    public SecondFrame() {
        setTitle("SecondFrame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnSecond = new JButton("Go to thirdframe");
        add(btnSecond);

        btnSecond.addActionListener(e -> {
            new ThirdFrame();
            setVisible(false);
        });
        setVisible(true);


    }
}