package cn.easyNotify.core;

import java.io.InputStream;
import java.util.Properties;

public class ConfigProp {
    private String sckey;

    private ConfigProp() {
    }

    private static volatile ConfigProp instance;

    public static ConfigProp getInstance() {
        if (instance == null) {
            synchronized (ConfigProp.class) {
                if (instance == null) {
                    instance = new ConfigProp();
                    instance.load();
                }
            }
        }
        return instance;
    }


    private void load() {
        try (InputStream is = ConfigProp.class.getClassLoader().getResourceAsStream("notify.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            sckey = properties.getProperty("serverChan.sckey");
        } catch (Exception e) {
            throw new NoAvailableConfigException();
        }
    }

    public String getSckey() {
        return sckey;
    }

}
