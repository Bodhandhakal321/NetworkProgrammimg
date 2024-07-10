package Chapter9;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class Chapter9 {
    public static void main(String[] args) {
        SocketAddress socketAddress = new InetSocketAddress("www.google.com", 19);

        try {
            //client side
            SocketChannel socketChannel = SocketChannel.open();

//            ByteBuffer byteBuffer = ByteBuffer.allocate(74);

            CharBuffer byteBuffer = CharBuffer.allocate(74);

//            int socketRead = socketChannel.read(byteBuffer);

//            WritableByteChannel output = Channels.newChannel(System.out);
//            byteBuffer.flip();
////            output.write(byteBuffer);
////            byteBuffer.clear();
//
////            server side
//            ServerSocketChannel serverSocketChannelServer = ServerSocketChannel.open();
//            ServerSocket ss = serverSocketChannelServer.socket();
//            ss.bind(new InetSocketAddress(19));
//
//            //accepting incoming request from the client
//            SocketChannel clientChannel = serverSocketChannelServer.accept();
//            clientChannel.configureBlocking(false);

            //bugffers properties

            System.out.println("Position is" + byteBuffer.position());
            byteBuffer.position(25);

            //capacity
            System.out.println("Capacity is" + byteBuffer.capacity());

            //limit
            System.out.println(" Limit is" + byteBuffer.limit());

            //mark
            System.out.println( "mark is" +byteBuffer.mark());




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }}


