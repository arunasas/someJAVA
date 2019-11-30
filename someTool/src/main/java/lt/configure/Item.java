package lt.configure;

public class Item {
    private int id;
    private String ip;
    private boolean state;
    private boolean select;


    public Item(int id, String ip, boolean state, boolean select) {
        this.id = id;
        this.ip = ip;
        this.state = state;
        this.select = select;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getState() {
        if (state) {
            return "Up";
        } else {
            return "Down";
        }
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
