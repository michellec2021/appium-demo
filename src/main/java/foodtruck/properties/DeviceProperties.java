package foodtruck.properties;

import com.google.common.io.Resources;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @author Michelle
 */
public class DeviceProperties {
    public static String DEVICE_OS;
    public static String DEVICE_NAME;
    public static String DEVICE_VERSION;
    public static String APP_PATH;

    static {
        try {
            InputStream stream = ClassLoader.getSystemResourceAsStream("devices.properties");
            Properties properties = new Properties();
            properties.load(stream);
            DEVICE_OS = properties.getProperty("device.os");
            DEVICE_NAME = properties.getProperty("device.name");
            DEVICE_VERSION = properties.getProperty("device.version");
            APP_PATH = properties.getProperty("app.path");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
