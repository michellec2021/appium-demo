package foodtruck.common;

import foodtruck.properties.SysProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Michelle
 */
public class BaseCase {
    protected AppiumDriver<MobileElement> driver;
    protected WebDriverWait webDriverWait;
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseCase.class);

    @BeforeSuite
    public void setupDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", SysProperties.DEVICE_NAME);
        capabilities.setCapability("app", SysProperties.APP_PATH);
        capabilities.setCapability("noReset", "true");
        if (SysProperties.DEVICE_OS.equals("android")) {
            capabilities.setCapability("automationName", "UIAutomator2");
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("platformVersion", SysProperties.DEVICE_VERSION);
            driver = new AndroidDriver<>(new URL(SysProperties.APPIUM_URL), capabilities);
        } else if (SysProperties.DEVICE_OS.equals("ios")) {
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("platformName", "ios");
            capabilities.setCapability("autoAcceptAlerts", "true");
            capabilities.setCapability("platformVersion", SysProperties.DEVICE_VERSION);
            driver = new IOSDriver<>(new URL(SysProperties.APPIUM_URL), capabilities);
        } else {
            throw new IllegalArgumentException("unknown device os " + SysProperties.DEVICE_OS);
        }
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @AfterSuite
    public void tearDown() {
        //End the running session
        if (driver != null) {
            driver.terminateApp(SysProperties.BUNDLE_ID);
            driver.quit();
            LOGGER.info("driver quited");
        }
    }
}
