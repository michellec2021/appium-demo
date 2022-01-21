package foodtruck.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Michelle
 */
public class WonderHomePage extends BasePage {
    private static final String SELECT_ADDRESS = "select address";
    private static final String WONDER_TAB = "wonder_on_home_page";
    private static final String ENVOY_TAB = "envoy_on_home_page";

    public WonderHomePage() {
        super(MobileBy.AccessibilityId(WONDER_TAB));
    }

    public void waitRestaurantExist(String restaurantName) {
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(restaurantName+" restaurant")));
    }

    public void clickEnvoy() {
        driver.findElementByAccessibilityId(ENVOY_TAB).click();
    }
}
