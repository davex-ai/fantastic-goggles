import Model.Database;

import java.io.*;
import java.sql.*;
public class Imageuploader {
    public static boolean addUsersWithImage(String name, String imagePath){
        String sql = "insert into userImg (name, image) values(?, ?)";

        try(Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            FileInputStream file = new FileInputStream(new File(imagePath));

            stmt.setString(1, name);
            stmt.setBinaryStream(2,file, (int) new File(imagePath).length());

        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }catch (SQLException  | FileNotFoundException e ){
            {
                e.printStackTrace();
                return false;
            }
    }
    }



    public static void main(String[] args) {
        boolean success = addUsersWithImage("school", "C:\\Users\\DELL\\Downloads\\download.jpg");
        System.out.println(success ? "Image added successfully": "Failed to add image");
    }
}