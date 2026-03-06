package CONNECTION;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6789);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello, Server!");
        socket.close();
    }
}

