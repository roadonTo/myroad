package 网络编程.InetAddress_;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress byName = InetAddress.getByName("DESKTOP-3K8E437");
        System.out.println(byName);

        InetAddress byName1 = InetAddress.getByName("www.baidu.com");
        System.out.println(byName1);

        String hostAddress = byName1.getHostAddress();
        System.out.println(hostAddress);




    }
}
