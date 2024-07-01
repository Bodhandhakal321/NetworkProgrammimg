package Chapter7;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.logging.Logger;

public class Chapter7 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("requests");
        try {
           /* ServerSocket serverSocket =  new ServerSocket(13);



            Socket socket =serverSocket.accept();
            InputStream inputStream = socket.getInputStream();


            OutputStream outputStream =  socket.getOutputStream();
            Writer writer=  new OutputStreamWriter(outputStream);
            Date date = new Date();
            int dateinByte = (byte)date.getDate();
            outputStream.write(dateinByte); //stream takes raw data and acutal data from writer
            writer.write(date.toString());

            int c;
            while ((c = inputStream.read()) != -1 ) {
                writer.write((char) c);
            }

            writer.flush();
            socket.close();
            serverSocket.close();


//            System.out.println(logger);
            logger.warning("this is warning");

            logger.fine("its good");
            logger.finer("its finer");
            logger.finest("its finest");

            //server socket using port and queue numbner
            ServerSocket serverSocket1 = new ServerSocket(80,50);
//            System.out.println(serverSocket1);

            //using inet address
            InetAddress inetAddress = InetAddress.getByName("192.168.100.203");
            ServerSocket serverSocket2 = new ServerSocket(80,10, inetAddress);
//            System.out.println(serverSocket2); */

            //using non args methods and binding with inet address
            ServerSocket nonArgSocket = new ServerSocket();
            SocketAddress socketAddress = new InetSocketAddress(80);
            nonArgSocket.bind(socketAddress,50);

            System.out.println(nonArgSocket.getLocalSocketAddress());
            System.out.println(nonArgSocket.getLocalPort());
            System.out.println(nonArgSocket.getInetAddress());

            nonArgSocket.setSoTimeout(100);
            System.out.println("Timeout is ::" + nonArgSocket.getSoTimeout());

            nonArgSocket.setReuseAddress(true);
            System.out.println("Reuse Address ::"+ nonArgSocket.getReuseAddress());


            nonArgSocket.setReceiveBufferSize(200);
            System.out.println("Receive buffer size ::" + nonArgSocket.getReceiveBufferSize());
//            System.out.println(nonArgSocket);
            nonArgSocket.setPerformancePreferences(2,1,3);




        } catch (IOException e) {
            logger.severe("Very Critical" +e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
