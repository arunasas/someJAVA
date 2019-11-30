package lt.configure;

import java.sql.Timestamp;
import java.util.Date;

public class MainTest {
    public static void main(String[] args) {
        //String ip = "";

        //boolean alive = HostsAliveCheck.IsAlive(ip);
        //System.out.println(alive);
        //System.out.println(HostsAliveCheck.IPstoArray("192.168.8.1", "192.168.8.1"));
        //Date date = new Date();
        //Object ts = new Timestamp(date.getTime());
//        for (String ip:HostsAliveCheck.IPstoArray("10.206.1.1", "10.206.1.10")
//             ) {
//            //Object ts = new Timestamp(date.getTime());
//            System.out.println(ip + " " + HostsAliveCheck.IsAlive(ip));
//        }
        System.out.println(new LocalHostAndIp());
        System.out.println(new LocalHostAndIp().getIp());
        System.out.println(new LocalHostAndIp().getName());
        //System.out.println(new LocalHostAndIp().getName());

    }
}
