package cn.easyNotify.core;

import java.net.HttpURLConnection;
import java.net.URL;

public class ServerChanNotify {
    public void notify(String title, String content) throws Exception {
        String sckey = ConfigProp.getInstance().getSckey();
        String serverUrl = String.format(ServerChanContext.serverUrl, sckey);

        URL url = new URL(serverUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.getOutputStream().write(("text=" + title + "&desp=" + content).getBytes());
        conn.getOutputStream().flush();
        conn.setConnectTimeout(5000);
        conn.getInputStream().close();
        conn.disconnect();
    }

    public static void main(String[] args) throws Exception {
        new ServerChanNotify().notify("123", "");
    }
}
