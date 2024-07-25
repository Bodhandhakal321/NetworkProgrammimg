package Chapter10;

import java.io.IOException;
import java.net.*;

public class UdpUnit10 {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(0);
            datagramSocket.setSoTimeout(10000);
            DatagramPacket request = new DatagramPacket( new byte[1], 1 , InetAddress.getByName("time.nist.gov"),13);
            datagramSocket.send(request);

             byte [] bytes = new byte[1024];
             DatagramPacket response = new DatagramPacket(bytes, bytes.length);
             datagramSocket.receive(response);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
