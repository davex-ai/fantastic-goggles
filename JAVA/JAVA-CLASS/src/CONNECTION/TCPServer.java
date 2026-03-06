package CONNECTION;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server is listening on port 6789...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = in.readLine();
        System.out.println("Received: " + message);

        socket.close();
        serverSocket.close();
    }
}


