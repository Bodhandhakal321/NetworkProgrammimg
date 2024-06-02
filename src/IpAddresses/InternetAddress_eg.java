package IpAddresses;

import java.io.IOException;
import java.net.*;
import java.util.Enumeration;


public class InternetAddress_eg {
    public static void main(String[] args){
        try { //get host name get by name
            InetAddress inetAddressHostName = InetAddress.getByName("www.google.com");
            System.out.println(inetAddressHostName);
            //get host
            InetAddress inetAddressHost = InetAddress.getByName("142.250.194.68");
            System.out.println(inetAddressHost.getHostName());

            InetAddress[] inetAddressList = InetAddress.getAllByName("www.google.com");
            for (int i = 0; i < inetAddressList.length ; i++) {

                System.out.println("first Address" + i + "" + inetAddressList[i]);
            }
            //localhost ip
            InetAddress inetAddressLocal = InetAddress.getLocalHost();
            System.out.println("Local host:" + inetAddressLocal);

            // get by address in byte form
            byte[] addressByte = {107, 23, (byte) 216, (byte) 196};
            InetAddress inetAddressByAddress = InetAddress.getByAddress(addressByte);
            System.out.println("Get By Address:" + inetAddressByAddress.getHostName());
            // both
            InetAddress inetAddressByAddressAndHost = InetAddress.getByAddress("google.com",addressByte);
            System.out.println("Get By Address and Host:" + inetAddressByAddressAndHost.getHostAddress());

            //doing getHostname canonical
            InetAddress inetAddressHostNameCanonical = InetAddress.getByName("www.google.com");
            System.out.println("get canonical host name:" + inetAddressHostNameCanonical.getCanonicalHostName());
            //addresstypes
            InetAddress inetAddressType = InetAddress.getByName("142.250.194.68");
            System.out.println("Any local Address: " + inetAddressType.isAnyLocalAddress());

            InetAddress inetAddressType2 = InetAddress.getByName("127.0.0.1");
            System.out.println("Any loopback Address: " + inetAddressType2.isLoopbackAddress());

            InetAddress inetAddressType3 = InetAddress.getByName("142.250.194.68");
            System.out.println("Any linklocal Address: " + inetAddressType3.isLinkLocalAddress());

            InetAddress inetAddressType4 = InetAddress.getByName("192.168.137.9");
            System.out.println("Any Sitelocal Address: " + inetAddressType4.isSiteLocalAddress());

            InetAddress inetAddressType5 = InetAddress.getByName("224.0.1.7");
            System.out.println("Any multicast Address: " + inetAddressType5.isMulticastAddress());

            InetAddress inetAddressType6 = InetAddress.getByName("142.250.194.68");
            System.out.println("Any MCGlobal Address: " + inetAddressType6.isMCGlobal());

            InetAddress inetAddressType7 = InetAddress.getByName("142.250.194.68");
            System.out.println("Any MCNodeLocal Address: " + inetAddressType7.isMCNodeLocal());

            InetAddress inetAddressType8 = InetAddress.getByName("142.250.194.68");
            System.out.println("Any McSite local Address: " + inetAddressType8.isMCSiteLocal());

            InetAddress inetAddressType9 = InetAddress.getByName("142.250.194.68");
            System.out.println("Any McORgLocal Address: " + inetAddressType9.isMCOrgLocal());

            InetAddress inetAddressType10 = InetAddress.getByName("142.250.193.132");
            System.out.println("Any McLinkLocal Address: " + inetAddressType10.isMCLinkLocal());


            System.out.println("IS Reachable: " + inetAddressType10.isReachable(600));
            //equals check
            InetAddress inetAddressEquals1 = InetAddress.getByName("142.250.194.68");
            InetAddress inetAddressEquals2 = InetAddress.getByName("142.250.194.68");
            System.out.println("IS EQuals: " + inetAddressEquals1.equals(inetAddressEquals2));
            System.out.println("To HasCode: " + inetAddressEquals1.hashCode());
            System.out.println("To String: " + inetAddressEquals1.toString());
            //slide 34

            //ipv4 ipv6 labbbb
            InetAddress inet4Address =  Inet4Address.getByName("www.google.com");
            System.out.println("Inet4Address" +inet4Address);

            InetAddress inet6Address =  Inet6Address.getByName("www.google.com");
            System.out.println("Inet6Address" +inet6Address);


            //NIC newtork identification card
            NetworkInterface networkInterface = NetworkInterface.getByName("lo");
            System.out.println("NIC:" + networkInterface);

            NetworkInterface networkInterfaceAddress = NetworkInterface.getByInetAddress(inet4Address);
            System.out.println("Get By INET:" + networkInterfaceAddress);

            NetworkInterface networkInterface3 = NetworkInterface.getNetworkInterfaces().nextElement();
            System.out.println("GEt bY INET:" + networkInterface3);

            Enumeration networkInterface4 = NetworkInterface.getNetworkInterfaces();
            while (networkInterface4.hasMoreElements()){
                System.out.println("Network Interfaces:" + networkInterface4.nextElement());

            }
            System.out.println("GEt bY ENumerations:" + networkInterface4);

            Enumeration enumAddress = networkInterface.getInetAddresses();
            while (enumAddress.hasMoreElements()){
                System.out.println(enumAddress.nextElement());
            }

            System.out.println("networkinterface.getname() :" + networkInterface.getName());
            System.out.println("networkinterface.getDisplayname() :" + networkInterface.getDisplayName());






        }catch (UnknownHostException e){
            throw  new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


