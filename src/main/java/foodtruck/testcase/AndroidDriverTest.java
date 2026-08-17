package foodtruck.testcase;

import foodtruck.common.DriverInstance;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author michelle
 */
public class AndroidDriverTest {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> driver = DriverInstance.of().driver;
        driver.installApp("/Users/mixuanchen/Documents/app/WONDER_3.1.0uatRelease.apk");
        driver.activateApp("com.remarkablefoods.consumerUAT");
        Thread.sleep(5000);
        driver.findElementByAccessibilityId("login_button_on_welcome_page").click();
        Thread.sleep(5000);
    }
}
