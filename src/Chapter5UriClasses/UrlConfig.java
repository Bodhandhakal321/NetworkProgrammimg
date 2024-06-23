package Chapter5UriClasses;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;

public class UrlConfig {
    public static void main(String[] args) {
        try {
//            URL url = new URL("https://www.google.com/");
            URL url = new URL("https://www.overcomingbias.com/");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoInput(false);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(30000);
            urlConnection.setReadTimeout(45000);
            urlConnection.setRequestProperty("Accept","text/html, image.png, image/gif");

            System.out.println("URL IS:: " + urlConnection.getURL());
            urlConnection.setAllowUserInteraction(true);
            System.out.println("Is User Interaction  Allowed ::" +urlConnection.getAllowUserInteraction());

            System.out.println("IS Readable && Writable::" +urlConnection.getDoInput())  ;

            System.out.println("OUTPUT BACK TO SERVER::" +urlConnection.getDoOutput());

            System.out.println("Modified when::" +urlConnection.getIfModifiedSince());

            System.out.println("Caches::" + urlConnection.getUseCaches());

            System.out.println("IS Timeout::" +urlConnection.getConnectTimeout());

            System.out.println("Read Timeout ::" +urlConnection.getReadTimeout());


            System.out.println(urlConnection.getRequestProperty("Accept"));


            Permission permission =  urlConnection.getPermission();
            System.out.println("Name is? ::"+permission.getName());
            System.out.println("Action is? ::"+permission.getActions());

            URL url1 = new URL("http://lesswrong.com/");
            HttpURLConnection  httpURLConnection= (HttpURLConnection) url1.openConnection();


            // set chunked streaming mode
//            httpURLConnection.setChunkedStreamingMode(10);
//
            httpURLConnection.setRequestMethod("POST");
            System.out.println(httpURLConnection.getRequestMethod());

            //to get http header
            httpURLConnection.setRequestMethod("HEAD");
            System.out.println(httpURLConnection.getRequestMethod());

            //to get what options are supported
            httpURLConnection.setRequestMethod("OPTIONS");
            System.out.println(httpURLConnection.getRequestMethod());

            //to get request header send same response on header
            httpURLConnection.setRequestMethod("TRACE");
            System.out.println(httpURLConnection.getRequestMethod());

            System.out.println( "RESPONSE CODE ::"+ httpURLConnection.getResponseCode());
            System.out.println( "RESPONSE MESSAGE ::"+ httpURLConnection.getResponseMessage());

            System.out.println("IS USING PROXY ? ::" +httpURLConnection.usingProxy());



            httpURLConnection.disconnect();


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
