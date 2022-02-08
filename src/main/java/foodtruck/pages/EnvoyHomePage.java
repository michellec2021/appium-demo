package foodtruck.pages;

import io.appium.java_client.MobileBy;

/**
 * @author Michelle
 */
public class EnvoyHomePage extends BasePage {
    private static final String SELECT_ADDRESS = "select address";
    private static final String WONDER_TAB = "wonder_on_home_page";
    private static final String ENVOY_TAB = "envoy_on_home_page";
    private static final String DELIVERY_BUTTON = "delivery_button_on_home_page";
    private static final String PICKUP_BUTTON = "pickup_button_on_home_page";

    public EnvoyHomePage() {
        super(MobileBy.AccessibilityId(DELIVERY_BUTTON));
    }

    public void clickPickupButton() {
        driver.findElementByAccessibilityId(PICKUP_BUTTON).click();
    }

    public void clickWonderTab() {
        driver.findElementByAccessibilityId(WONDER_TAB).click();
    }

    public void clickRestaurant(String restaurantName) {
        driver.findElementByAccessibilityId(restaurantName + "_under_Burgers").click();
    }
}
