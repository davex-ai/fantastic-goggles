package CONNECTION;
import java.net.*;

public class UDPCLIENT {

    public class UDPClient {
        public static void main(String[] args) throws Exception {
            DatagramSocket socket = new DatagramSocket();
            String message = "Hello, Server!";
            byte[] buffer = message.getBytes();

            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 9876);
            socket.send(packet);

            socket.close();

        }
    }
}
