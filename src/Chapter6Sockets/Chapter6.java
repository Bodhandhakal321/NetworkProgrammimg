package Chapter6Sockets;

import java.io.*;
import java.net.*;

public class Chapter6 {
    public static void main(String[] args) {
        try {
//            Socket socket = new Socket("time.nist.gov",13);

            //creting a socket address
            Socket socket = new Socket();
            SocketAddress  socketAddress= new  InetSocketAddress("time.nist.gov",13);
            //proxy socket
//            Proxy proxy = new Proxy(Proxy.Type.HTTP, socketAddress);
//            Socket socket = new Socket(proxy);
            socket.connect(socketAddress);

            System.out.println("INET Address is" + socket.getInetAddress());
            System.out.println("Port is" + socket.getPort());
            System.out.println("Local Address is" + socket.getLocalAddress());
            System.out.println("LocalPort is" + socket.getLocalPort());



            //socket address methods
            if (socket.isConnected()){
                System.out.println("Socket is Connected");
            }
//            socket.close();
            if (socket.isClosed()){
                System.out.println("Socket is Closed");
            }
            System.out.println("Remote address is" +socket.getRemoteSocketAddress());
            System.out.println("Local address is "+socket.getLocalAddress());



            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ASCII");
            String dateTime = "";
            int time;
            while ((time= inputStreamReader.read()) != -1){
                dateTime = dateTime + (char) time;
            }

            System.out.println("Date time of nist is" +dateTime);
            //write a socket
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");

            writer.write("write something");
            writer.flush();

//            Socket socket1 = new Socket(InetAddress.getByName("www.google.com"),90);
            //NoDelay
            socket.setTcpNoDelay(true);
            System.out.println("Delay set::"+socket.getTcpNoDelay());

            //soLinger
            socket.setSoLinger(true ,5);
//            socket.close();
//            System.out.println("IS CONNECTED?::" +socket.isConnected());
            System.out.println("IS CONNECTED?::" +socket.isClosed());
            System.out.println("So Linger:: "+socket.getSoLinger());

            //So_Timeout
            socket.setSoTimeout(3600);
            System.out.println("TimeOut" + socket.getSoTimeout());

            //setbuffer
            socket.setSendBufferSize(10);
            System.out.println("SetBuffer is" + socket.getSendBufferSize());

            //receive buffer
            socket.setReceiveBufferSize(10);
            System.out.println("Receive Buffer is" + socket.getReceiveBufferSize());

            //is alive or not
            //11 min the client tries
            socket.setKeepAlive(true);
            System.out.println("IS Alive" + socket.getKeepAlive());

            //OOBINLINE

            socket.sendUrgentData(123);
            socket.setOOBInline(true);
            System.out.println("IS OOBINLINE" + socket.getOOBInline());

            //reusable address
            socket.setReuseAddress(true);
            System.out.println("IS REUSABLE " + socket.getReuseAddress());

            //getsettraffic classes
            socket.setTrafficClass(128);
            System.out.println("IS Traffic Class ::" + socket.getTrafficClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
