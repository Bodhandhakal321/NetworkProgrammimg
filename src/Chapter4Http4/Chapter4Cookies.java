package Chapter4Http4;

import java.net.*;

public class Chapter4Cookies {
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);

        CookieStore cookieStore = cookieManager.getCookieStore();
        try {
            cookieStore.add(new URI("www.google.com"), new HttpCookie("firstname", "Bodhan"));
            cookieStore.add(new URI("www.google.com"), new HttpCookie("lastname", "Dhakal"));


            System.out.println("Cookie is::"+ cookieStore.getCookies().get(0));
            System.out.println("Cookie is::"+ cookieStore.getCookies().get(1));
            System.out.println(cookieStore.get(new URI("www.google.com")));
//            System.out.println(cookieStore.remove(new URI ("www.google.com"), new HttpCookie("firstname", "Bodhan" )));


            //remove only one cookie
            System.out.println(cookieStore.remove(new URI("www.google.com"), cookieStore.getCookies().get(0)));
            System.out.println(cookieStore.getCookies());


            System.out.println(cookieStore.removeAll());


            //remove all cookies
//            System.out.println(cookieStore.getCookies());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
