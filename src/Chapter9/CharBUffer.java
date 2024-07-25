package Chapter9;

import java.io.DataOutput;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;

public class CharBUffer {
    public static void main(String[] args) {
        SocketAddress socketAddress = new InetSocketAddress("www.google.com", 19);
        try {
            SocketChannel socketChannel = SocketChannel.open();
            CharBuffer charBuffer = CharBuffer.allocate(10);
            charBuffer.put('a');
            charBuffer.put('b');

            charBuffer.flip(); //after flippping  position 0 and limit set to 2

            charBuffer.put('c');
            charBuffer.put('d');

            System.out.println("POSITION IS :: "+charBuffer.position());
//            System.out.println(charBuffer.get(charBuffer.position()));
            System.out.println(charBuffer.get(1));
            System.out.println(charBuffer.get(0));

            byte[] bytes = "Some Array String".getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            byteBuffer.put(bytes,0,10);

            byte[] newBytes=  new byte[50];
            byteBuffer.get(newBytes);
            System.out.println( (char) newBytes[1]);

            System.out.println( byteBuffer.getChar(0));
            byteBuffer.putChar('a','b');
            System.out.println( byteBuffer.getChar());

            //View as
            CharBuffer charBuffer1 = byteBuffer.asCharBuffer();
            IntBuffer intBuffer = byteBuffer.asIntBuffer();
            DoubleBuffer doubleBuffer = DoubleBuffer.allocate(10);
            doubleBuffer.put(10);

            DoubleBuffer newdoubleBuffer = doubleBuffer.duplicate();
            System.out.println( "double buffer data:: " + newdoubleBuffer.get(0));
            System.out.println("Buffer equals :: " + doubleBuffer.equals(newdoubleBuffer));
            System.out.println( "HashCode :" + doubleBuffer.hashCode() );
            System.out.println("Hashcode of new double buffer" + newdoubleBuffer .hashCode());
            System.out.println("String " + newdoubleBuffer.toString());

            doubleBuffer.put(20);
            doubleBuffer.put(30);
            doubleBuffer.put(40);
            doubleBuffer.put(50);
            doubleBuffer.put(60);
            doubleBuffer.put(70);
            doubleBuffer.position(4);
            DoubleBuffer sliceDoubleBuffer = doubleBuffer.slice();
            System.out.println("Sliced buffer"+ sliceDoubleBuffer.get(0));
            System.out.println("Sliced buffer"+ sliceDoubleBuffer.get(1));
            System.out.println("Sliced buffer"+ sliceDoubleBuffer.get(2));




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
