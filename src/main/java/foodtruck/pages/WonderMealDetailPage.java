package foodtruck.pages;

import io.appium.java_client.MobileBy;

/**
 * @author Michelle
 */
public class WonderMealDetailPage extends BasePage {
    private static final String ADD_BUTTON = "take it button";

    public WonderMealDetailPage() {
        super(MobileBy.AccessibilityId(ADD_BUTTON));
    }
}
