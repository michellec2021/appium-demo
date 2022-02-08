package foodtruck.pages;

import io.appium.java_client.MobileBy;
/**
 * @author Michelle
 */
public class WonderRestaurantDetailPage extends BasePage {
    public static final String BACK_BUTTON = "RESTAURANT_DETAIL_PAGE";

    public WonderRestaurantDetailPage() {
        super(MobileBy.AccessibilityId(BACK_BUTTON));
    }

    public void clickMeal(String mealName) {
        driver.findElementByAccessibilityId(mealName + " meal").click();
    }

}
