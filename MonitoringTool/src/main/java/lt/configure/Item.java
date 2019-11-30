package lt.configure;

public class Item {
    private String ip;
    private boolean reachable;


    public Item(String ip, boolean reachable) {
        this.ip = ip;
        this.reachable = reachable;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getReachable() {
        if (reachable) {
            return "Up";
        } else {
            return "Down";
        }
    }

    public void setReachable(boolean reachable) {
        this.reachable = reachable;
    }
}
