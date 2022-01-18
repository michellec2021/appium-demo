package foodtruck.properties;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Michelle
 */
public class SysProperties {
    public static String DEVICE_OS;
    public static String DEVICE_NAME;
    public static String DEVICE_VERSION;
    public static String APP_PATH;
    public static String APPIUM_URL;
    public static String BUNDLE_ID;

    static {
        try {
            InputStream stream = ClassLoader.getSystemResourceAsStream("sys.properties");
            Properties properties = new Properties();
            properties.load(stream);
            DEVICE_OS = properties.getProperty("device.os");
            DEVICE_NAME = properties.getProperty("device.name");
            DEVICE_VERSION = properties.getProperty("device.version");
            APP_PATH = properties.getProperty("app.path");
            APPIUM_URL = properties.getProperty("appium.url");
            BUNDLE_ID = properties.getProperty("app.bundleId");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
