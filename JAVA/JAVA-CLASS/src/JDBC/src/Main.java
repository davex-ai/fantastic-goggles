import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school";
        String username = "root";
        String password = "";
        System.out.println("Connection Succesful");
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            //step 3 :CREATE CONNECTION STATEMENT
            Statement statement = conn.createStatement();
            //Our query
            String getrecords = "Select * FROM record";
            //Select query
            //Step 4

            ResultSet allrecord = statement.executeQuery("Select * FROM record");
            while (allrecord.next()) {
                String myExam = allrecord.getString("Exam");
                int myscore = allrecord.getInt("Score");
                System.out.println(myExam);
                System.out.println(myscore);
            }
            //inser query
            // statement.executeUpdate("INSERT INTO `record` (`_id`, `Exam`, `Score`) VALUES (NULL, 'MONGODB', '83')");
     //        statement.executeUpdate("DELETE FROM record WHERE record._id = 9");
             //  statement.executeUpdate("Insert INTO record(EXAM,SCORE) VALUE(70)");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}