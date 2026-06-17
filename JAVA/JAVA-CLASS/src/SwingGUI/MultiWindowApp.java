package SwingGUI;
import javax.swing.*;

public class MultiWindowApp {
    public static void main(String[] args) {
 //Swing utilities have package named invoke later it is used to move from one page to another
        SwingUtilities.invokeLater(() -> new FirstFrame());  //line 9 lambda helping to  target new class
    }
}
//