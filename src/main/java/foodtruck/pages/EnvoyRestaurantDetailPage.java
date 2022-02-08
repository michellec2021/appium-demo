package foodtruck.pages;

import io.appium.java_client.MobileBy;

/**
 * @author Michelle
 */
public class EnvoyRestaurantDetailPage extends BasePage {
    public static final String PAGE_TEST_ID = "MKP_RESTAURANT_DETAIL_PAGE";

    public EnvoyRestaurantDetailPage() {
        super(MobileBy.AccessibilityId(PAGE_TEST_ID));
    }
}
