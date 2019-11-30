package lt.configure;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class JschExec {

    public static StringBuilder getSshOutput(String host, String user, String password, String cmd) {

        StringBuilder String = null;
        try {
            String = new StringBuilder();
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");
            String.append("Connected\n\n");

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(cmd);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();
            channel.connect();
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                    String.append(new String(tmp, 0, i) + "\n");
                }
                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    String.append("exit-status: " + channel.getExitStatus() + "\n");
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                    String.append(ee);
                }
            }
            channel.disconnect();
            session.disconnect();
            System.out.println("Done");
            String.append("Done\n");
        } catch (Exception e) {
            e.printStackTrace();
            String.append(e);
        }
        return String;
    }
}