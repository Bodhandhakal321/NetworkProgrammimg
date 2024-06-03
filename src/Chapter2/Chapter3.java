package Chapter2;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Chapter3 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.lolcats.com");
//            System.out.println(url);
            URL url2 = new URL("http","www.audubon.org","/");

            URL url3 = new URL("http","www.audubon.org",8081,"/audubonmagazine");
            System.out.println(url3);
//            System.out.println(url2);
            URL url4 = new URL(url,"/audubonmagazine");
            System.out.println(url4);

            //input stream read data
            try {
                InputStream inputStream = url.openStream();
                int c;
                while ((c=inputStream.read()) != -1){
                    System.out.println(c);

                }
                inputStream.close();

                URLConnection urlConnection = url.openConnection();
                        InputStream inputStream2 = urlConnection.getInputStream();
                        int d;
                while ((d=inputStream2.read()) != -1){
                    System.out.println(d);

                }
                //program to download object
                Object o = url.getContent();
                System.out.println(o.toString());

                Class <InputStream> [] classes = new Class[3];
                classes[0] = InputStream.class;
                InputStream inputStream3 = (InputStream) url.getContent(classes);
                System.out.println(inputStream3);
                int e;
                while ((e=inputStream3.read()) != -1){
                    System.out.println(e);

                }


                //splitting url into pieces

                URL urlPieces = new URL("http://www.ibiblio.org/javafaq/books/jnp/index.html?isbn=1565922069#toc,");
//                urlPieces.getProtocol();
                System.out.println("protocol is :: "+ urlPieces.getProtocol());
                System.out.println("File is :: "+urlPieces.getFile());
                System.out.println("Host is :: "+urlPieces.getHost());
                System.out.println("POrt is :: "+urlPieces.getPort());
                System.out.println("Fragment/ REF is :: "+urlPieces.getRef());
                System.out.println("Query is :: "+urlPieces.getQuery());
                System.out.println("Path is :: "+urlPieces.getPath());
                System.out.println("User INfo is :: "+urlPieces.getUserInfo());
                System.out.println("Authority is :: "+urlPieces.getAuthority());


                System.out.println(url.equals(url2));
                System.out.println(url.hashCode());
                System.out.println(url.toString());



            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

