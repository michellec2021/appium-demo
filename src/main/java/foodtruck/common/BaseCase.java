package foodtruck.common;

import foodtruck.element.find.FindElementByAccessibilityId;
import foodtruck.properties.DeviceProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Michelle
 */
public class BaseCase {
    protected AppiumDriver<WebElement> driver;
    protected WebDriverWait webDriverWait;

    @BeforeSuite
    public void setupDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "/Users/michelle.chen/apps/WONDER_2.0.0uatRelease.apk");
        if (DeviceProperties.DEVICE_OS.equals("android")) {
            capabilities.setCapability("automationName", "UIAutomator2");
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("platformVersion", DeviceProperties.DEVICE_VERSION);
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } else if (DeviceProperties.DEVICE_OS.equals("ios")) {
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("platformName", "ios");
            capabilities.setCapability("platformVersion", DeviceProperties.DEVICE_VERSION);
            driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } else {
            throw new IllegalArgumentException("unknow device os " + DeviceProperties.DEVICE_OS);
        }
        webDriverWait = new WebDriverWait(driver, 10);
    }
}
