package Chapter8;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class NewSsl {
    public static void main(String[] args) {
        SocketFactory socketFactory = SSLSocketFactory.getDefault();
        ServerSocketFactory serverSocketFactory = ServerSocketFactory.getDefault();

        try {
            SSLSocket sslSocket = (SSLSocket) socketFactory.createSocket();
//            Socket socket = socketFactory.createSocket();
//            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(3400);

            List <String> ciphers= List.of(sslSocket.getSupportedCipherSuites());
            System.out.println(ciphers);
            sslSocket.setEnabledCipherSuites(new String[]{"TLS_AES_256_GCM_SHA384", "TLS_AES_128_GCM_SHA256", "TLS_CHACHA20_POLY1305_SHA256"});
            System.out.println(List.of(sslSocket.getEnabledCipherSuites()));

            sslSocket.setEnableSessionCreation(true);
            System.out.println("Session Enabled ? " +sslSocket.getEnableSessionCreation());

            sslSocket.setNeedClientAuth(true);
            System.out.println("Client auth needed?" + sslSocket.getNeedClientAuth());


//            sslSocket.setUseClientMode(true);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
