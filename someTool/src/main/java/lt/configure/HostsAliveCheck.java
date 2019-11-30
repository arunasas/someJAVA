package lt.configure;

import javafx.scene.control.TextField;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class HostsAliveCheck {

    public HostsAliveCheck() {

    }

    public static List<String> IPstoArray(String ipStart, String ipEnd) {
        if (ipStart.isEmpty()) {
            ipStart = new LocalHostAndIp().getLocalIP();
        }
        if (ipEnd.isEmpty()) {
            ipEnd = ipStart;
        }
        String[] ipSta = ipStart.split("\\.");
        String[] ipEn = ipEnd.split("\\.");
        int iStart = Integer.parseInt(ipSta[3]);
        int iEnd = Integer.parseInt(ipEn[3]);
        List<String> ipArray = new ArrayList<>();
        //if (iEnd == 0) {iEnd = iStart;};
        for (int i = iStart; i < iEnd + 1; i++) {
            ipArray.add(ipSta[0] + "." + ipSta[1] + "." + ipSta[2] + "." + i);
        }

        return ipArray;
    }

    public static boolean IsAlive(String ip, int timeout) {
        boolean reachable = false;
        try {
            InetAddress address = InetAddress.getByName(ip);
            reachable = address.isReachable(timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reachable;
    }

    public static boolean validateIP(String ipStr) {
        String regex = "\\b((25[0–5]|2[0–4]\\d|[01]?\\d\\d?)(\\.)){3}(25[0–5]|2[0–4]\\d|[01]?\\d\\d?)\\b";
        if (ipStr == null) {
            return false;
        } else {
            return Pattern.matches(regex, ipStr);
        }
    }
}
