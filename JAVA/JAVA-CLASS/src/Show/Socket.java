//package Show;
//import java.net.*;
//import java.io.*;
//import java.net.ServerSocket;
//
//public class Socket {
//    public static void main(String[] args) {
//        try (ServerSocket serverSocket = new ServerSocket(300)){
//            System.out.println("Server Started");
//
//            while (true){
//                Socket clientSocket = ServerSocket.accept();
//                System.out.println("Client connected " + clientSocket.getInetAddress());
//                //Set up input and output streams for communication
//                BufferedReader input = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
//                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),true);
//                serverSocket.close();
//
//            }
//
//        }
//    catch(IOException e){
//            //System.out.println(e);
//        }
//
//    }
//}
//
