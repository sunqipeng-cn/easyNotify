package cn.easyNotify.core;

public class NoAvailableConfigException extends RuntimeException {
    @Override
    public String getMessage() {
        return "请在classpath目录下创建notify.properties，添加serverChan.sckey属性填写您server酱服务的sckey ";
    }
}
