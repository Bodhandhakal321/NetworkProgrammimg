package Chapter5UriClasses;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class UrlConnectionTest {
    public static void main(String[] args) {
        try {
            //URL OBJECTS
//            URL url = new URL("https://www.overcomingbias.com/");

            URL url = new URL("https://www.google.com/");
            // CREATE CONNECTION
            URLConnection urlConnection = url.openConnection();
            //READ DAta
            InputStream inputStream = urlConnection.getInputStream();
            InputStream bufferedInputStream =  new  BufferedInputStream(inputStream);
            Reader reader = new InputStreamReader(bufferedInputStream);
            int c;
            while ((c = reader.read()) != -1){
//                System.out.print((char) c);
            }
            //getting content types
            System.out.println("Content type::"+urlConnection.getContentType());

            System.out.println("Content Leghth" + urlConnection.getContentLength());
            System.out.println("Content Encoding::" + urlConnection.getContentEncoding());
//            System.out.println("Content Date::" + urlConnection.getDate());
            Date date = new Date(urlConnection.getDate());
            System.out.println("Content Date::" +date);

//            System.out.println("Get Last Modified::" + urlConnection.getLastModified());

            Date date2 = new Date(urlConnection.getLastModified());
            System.out.println("Get Last Modified::" +date2);

            //another way of getting content types
            System.out.println(urlConnection.getHeaderField("content-type"));

//            getting server
            System.out.println(urlConnection.getHeaderField("server"));

            //getting connection
            System.out.println(urlConnection.getHeaderField("connection"));


            //get header field key
            System.out.println(urlConnection.getHeaderFieldKey(1));

            //get header value
            System.out.println(urlConnection.getHeaderField(1));

            //getfield date
//          Date date3 = new Date(urlConnection.getHeaderFieldDate("date",0)) ;
//          System.out.println(date3);
//          //or
            System.out.println(new Date(urlConnection.getHeaderFieldDate("date",0)));


            //content leghth
            System.out.println(urlConnection.getHeaderFieldInt("content-type",-1));


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
