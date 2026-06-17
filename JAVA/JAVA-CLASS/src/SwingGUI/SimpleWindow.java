package SwingGUI;
////importing required libraries
import javax.swing.*; //Provides GUI components like JFrame, JPanel, JLabel, JButton, etc.
import java.awt.*;//Provides layout managers like GridLayout.
import java.awt.event.ActionEvent;//Handles user interactions (e.g., button clicks).
import java.awt.event.ActionListener;
// javax.swing is the library (x refers to gui) j frame represent the main window
//java swing is a part of java library used for creating gui application.it is built on the absrct window toolkit
public class SimpleWindow {
        public static void main(String[] args) {
            JFrame frame = new JFrame("My First Swing App");//create  a frame
            frame.setSize(400, 300);//setting size for app/website
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ensures the program terminates when the window is closed.


         //jPanel is used to group components together
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(6, 1));
            frame.add(panel);


            // Set background color
            panel.setBackground(Color.PINK);


            //is used to tell a user where to insert info and what kind of info e.g "firstname imprinted on a column where user ought to insert his firstname"
            JLabel lb = new JLabel("What's your Gender☺️");
            panel.add(lb);

            // jradiobutton is used to give options it allows flexibility for user experience
            JRadioButton man = new JRadioButton("Male");
            JRadioButton nman = new JRadioButton("Female");
            ButtonGroup gender = new ButtonGroup();//A ButtonGroup (gender) ensures only one of the radio buttons can be selected at a time.
            gender.add(man);
            gender.add(nman);
            panel.add(man);
            panel.add(nman);

            JCheckBox Box = new JCheckBox("Rather not say");
            panel.add(Box);

            JLabel s = new JLabel("If you answered, thank you☺️! If not, please select an option.");
            panel.add(s);

            // Text field for user input
            JLabel nameLabel = new JLabel("Enter your name:");
            JTextField nameField = new JTextField(10);
            panel.add(nameLabel);
            panel.add(nameField);

            JButton bun = new JButton("Submit");
            panel.add(bun);

            //Handling Button Clicks with ActionListener
            bun.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!man.isSelected() && !nman.isSelected() && !Box.isSelected()) {
                        JOptionPane.showMessageDialog(frame, "Error: Please select a gender option!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String userName = nameField.getText().trim();
                        if (userName.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Error: Please enter your name!", "Input Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Thank you, " + userName + "! Your response has been recorded.");
                        }
                    }
                }
            });
            ;
            frame.add(panel);
            frame.setVisible(true); //Ensures the window is displayed when the program runs.
            String[][] data = {{"1","ken","20"},{"2","pint","13"}};
            String [] columns = {"ID","Name","Age"};

            JTable tbl = new JTable(data,columns);
            JScrollPane sp = new JScrollPane(tbl);
            frame.add(sp);
            // changing the icon
            ImageIcon icon = new ImageIcon("C:\\Users\\DELL\\Downloads\\download.jpg");
            frame.setIconImage(icon.getImage());
//            // Set Background colour
//            panel.setBackground(Color.LIGHT_GRAY);


            frame.setVisible(true);
        }
    }


