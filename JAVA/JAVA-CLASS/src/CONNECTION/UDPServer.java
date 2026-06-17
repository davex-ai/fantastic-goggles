package CONNECTION;

import java.net.*;

public class UDPServer {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9876);
        byte[] buffer = new byte[1024];

        System.out.println("Server is listening on port 9876...");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + message);

        socket.close();
    }
}

