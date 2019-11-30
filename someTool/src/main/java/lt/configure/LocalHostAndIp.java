package lt.configure;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
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

    public String getName() {
        //InetAddress ip;
        //String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostName;
    }

    public String getIp() {
        //InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    public String getLocalIP() {
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            ip = socket.getLocalAddress().getHostAddress();
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    @Override
    public String toString() {
        return "Local IP: " + ip + ", Local HostName: " + hostName;
    }
}