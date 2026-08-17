package foodtruck.testcase;

import foodtruck.common.DriverInstance;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author michelle
 */
public class IOSDriverTest {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> driver = DriverInstance.of().driver;
        driver.installApp("/Users/mixuanchen/Documents/app/wonderQA_3.1.0-c545e0a7c.app");
        driver.activateApp("com.remarkablefoods.consumerQA");
        Thread.sleep(5000);
        driver.findElementByAccessibilityId("login_button_on_welcome_page").click();
        Thread.sleep(5000);
    }
}
