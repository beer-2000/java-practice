package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DnsPractice {
    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 IP: " + local.getHostAddress());

            InetAddress[] iaArr = InetAddress.getAllByName("daum.net");
            for (InetAddress remote : iaArr) {
                System.out.println("네이버 IP: " + remote.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}

