package Chapter9;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;

public class CharBUffer {
    public static void main(String[] args) {
        SocketAddress socketAddress = new InetSocketAddress("www.google.com", 19);
        try {
            SocketChannel socketChannel = SocketChannel.open();
            CharBuffer charBuffer = CharBuffer.allocate(10);
            charBuffer.put('a');
            charBuffer.put('b');

            System.out.println("POSITION IS :: "+charBuffer.position());
            System.out.println(charBuffer.get(charBuffer.position()));
            System.out.println(charBuffer.get());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
