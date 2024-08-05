package Chapter10;

import java.io.IOException;
import java.net.*;
import java.util.Date;

public class Chapter10Server {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(13);
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
            datagramSocket.receive(datagramPacket);
            byte [] data = new Date().toString().getBytes();

            DatagramPacket response = new DatagramPacket(data, data.length, datagramPacket.getAddress(),datagramPacket.getPort());
            datagramSocket.send(response);


            SocketAddress socketAddress =  new InetSocketAddress(InetAddress.getByName("localhost"),80);
            DatagramPacket datagramPacket1 =  new DatagramPacket(data, data.length,socketAddress);

            DatagramPacket datagramPacket2 =  new DatagramPacket(data, 1, data.length, socketAddress);
            

        } catch (SocketException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
