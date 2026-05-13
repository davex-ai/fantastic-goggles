package View;

import Model.Database;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageViewer {
    public static void showUserImage(int userId){
        String sql = "SELECT name,image FROM userimg WHERE id = ?";
        try(Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                byte[] imgByte = new byte[]{rs.getByte("image")};

                if (imgByte != null) {
                    //convert byte array to image
                    InputStream is = new ByteArrayInputStream(imgByte);
                    BufferedImage img = ImageIO.read(is);
                    ImageIcon icon = new ImageIcon(img);

                    //Display in JFrame
                    JFrame frame = new JFrame("User Image");
                    frame.setLayout(new BorderLayout());

                    JLabel label = new JLabel(name, icon, JLabel.CENTER);
                    label.setHorizontalTextPosition(JLabel.CENTER);
                    label.setVerticalTextPosition(JLabel.BOTTOM);

                    frame.add(label, BorderLayout.CENTER);
                    frame.setSize(300, 400);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "No image found for this user");
                }
            }
            } catch(SQLException | IOException e) {
            e.printStackTrace();
            }
        }
        public static void main(String[] args) {
            showUserImage(2); //change to valid user id in ur database
        }

    }

