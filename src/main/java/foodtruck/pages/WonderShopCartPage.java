package foodtruck.pages;

import io.appium.java_client.MobileBy;

/**
 * @author Michelle
 */
public class WonderShopCartPage extends BasePage {
    private static final String CHECK_OUT_BUTTON = "checkout button";

    public WonderShopCartPage() {
        super(MobileBy.AccessibilityId(CHECK_OUT_BUTTON));
    }

    public void clickCheckoutButton(){
        driver.findElementByAccessibilityId(CHECK_OUT_BUTTON).click();
    }
}
