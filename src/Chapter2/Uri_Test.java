package Chapter2;

import java.io.UnsupportedEncodingException;
import java.net.*;

public class Uri_Test {
    public static void main(String[] args) {
        try {
            URI uri = new URI("http://www.ibiblio.org/javafaq/books/jnp/index.html?isbn=1565922069#toc,");
            System.out.println("URI" + uri);

            URI absolute = new URI("http","//www.google.com",null);
            System.out.println("Absolute" + absolute);

            URI relative = new URI(null,"/abc/def",null);
            System.out.println("Relative" + relative);

            if (relative.isAbsolute()){
                System.out.println("this uri is absolute");
            } else if (relative.isOpaque()) {
                System.out.println("THIS uri is opaque");
                System.out.println(relative.getScheme());
                System.out.println(relative.getSchemeSpecificPart());
                System.out.println(relative.getFragment());
            }else {
                System.out.println("this is relative");
            }

            System.out.println("Authority of URI: "+uri.getAuthority());
            System.out.println("Fragment of URI:" + uri.getFragment());
            System.out.println("HOST is"+uri.getHost());
            System.out.println("Path is"+uri.getPath());
            System.out.println("PORT is"+uri.getPort());
            System.out.println("QUERY is"+uri.getQuery());
            System.out.println("USERINFO is"+uri.getUserInfo());

            //Resolving URI
            URI resolved = absolute.resolve(relative);
            System.out.println("Absolute To Relative::" + resolved);

            URI relativize = relative.relativize(absolute);
            System.out.println("Relativized to Absolute::" + relativize);

            //ENCODING DECODING
            String encoding = URLEncoder.encode("Encoding is * Happening", "UTF-8");
            System.out.println("Encoding" + encoding);

            String decoding = URLDecoder.decode(encoding);
            System.out.println("DECODING IS" + decoding );

            //PROXY SERVER
            //System Properties
            System.setProperty("http.proxyHost","192.168.254.254");
            System.setProperty("http.proxyHost","9000");

            //Proxy Class

            SocketAddress socketAddress = new InetSocketAddress("proxy.example.com", 80) ;
            Proxy proxy = new Proxy(Proxy.Type.HTTP, socketAddress);
            System.out.println("PROXY:: "+ proxy);

            //PASSWORD AUTH
            char[] pass ={'1','2','3'};


            PasswordAuthentication  passwordAuthentication = new PasswordAuthentication("abc",pass);
            System.out.println("PASSWORD " + passwordAuthentication.getPassword());

            System.out.println("USERNAME "+ passwordAuthentication.getUserName());
//            passwordAuthentication.getPassword();
//            passwordAuthentication.getUserName();

        } catch (URISyntaxException | UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
