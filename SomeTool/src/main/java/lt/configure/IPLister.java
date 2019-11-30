package lt.configure;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
 
public class IPLister {
 
    public static void main(String[] args) {
        listIPAddresses();
    }
 
    private static void listIPAddresses(){
        Enumeration<NetworkInterface> net = null;
        try { // get all interfaces; ethernet, wifi, virtual... etc
            net = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
 
        if (net == null){
            throw new RuntimeException("No network interfaces found.");
        }
 
        while(net.hasMoreElements()){
            NetworkInterface element = net.nextElement();
            try {
                if (element.isVirtual() || element.isLoopback()){
                    // discard virtual and loopback interface (127.0.0.1)
                    continue;
                }
 
                // rest are either Wifi or ethernet interfaces
                // loop through and print the IPs
                Enumeration<InetAddress> addresses = element.getInetAddresses();
                while (addresses.hasMoreElements()){
                    InetAddress ip = addresses.nextElement();
                    if (ip instanceof Inet4Address){
                        if (ip.isSiteLocalAddress()){
                            //System.out.println(element.getDisplayName() + " - " + ip.getHostAddress());
                            System.out.println(ip.getHostAddress());
                        }
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    } // listIPAddresses() ends
}