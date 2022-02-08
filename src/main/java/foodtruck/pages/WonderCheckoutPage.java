package foodtruck.pages;

import io.appium.java_client.MobileBy;

/**
 * @author Michelle
 */
public class WonderCheckoutPage extends BasePage {
    private static final String MAP = "customer_map_on_mkp_checkout_page";

    public WonderCheckoutPage() {
        super(MobileBy.AccessibilityId(MAP));
    }
}
