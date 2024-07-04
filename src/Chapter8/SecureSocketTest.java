package Chapter8;

import javax.net.SocketFactory;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.Socket;

public class SecureSocketTest {
    public static void main(String[] args) {
        SocketFactory socketFactory = SSLSocketFactory.getDefault();
        try {

           Socket socket =  socketFactory.createSocket("login.ibiblio.org",3400);

           InetAddress inetAddress = InetAddress.getByName("www.google.com" );
           Socket socket1 = socketFactory.createSocket(inetAddress, 3500);

            OutputStream outputStream = socket.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(123);

            SSLSocket sslSocket = (SSLSocket) socketFactory.createSocket("login.ibiblio.org",3401);

            sslSocket.addHandshakeCompletedListener(new HandshakeCompletedListener() {
                @Override
                public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                    System.out.println("Handshake Completed");
                }
            });
            sslSocket.removeHandshakeCompletedListener(new HandshakeCompletedListener() {
                @Override
                public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                    System.out.println("Handshake Removed");
                }
            });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
