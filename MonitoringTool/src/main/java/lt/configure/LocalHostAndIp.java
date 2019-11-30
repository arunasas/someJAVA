package lt.configure;
 
import java.net.InetAddress;
import java.net.UnknownHostException;
 
public class LocalHostAndIp {
    private String ip;
    private String hostName;

    public LocalHostAndIp() {

    }

    public LocalHostAndIp(String ip, String hostName) {
        this.ip = ip;
        this.hostName = hostName;
    }

    public String getName () {
        //InetAddress ip;
        //String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostName;
    }

        public String getIp () {
            //InetAddress ip = null;
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        return ip;
    }

    @Override
    public String toString() {
        return "Local IP: " + ip + ", Local HostName: " + hostName;
    }
}