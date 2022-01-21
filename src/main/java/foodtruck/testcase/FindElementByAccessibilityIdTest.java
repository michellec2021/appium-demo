package foodtruck.testcase;

import foodtruck.common.BaseCase;
import foodtruck.element.find.RepeatFindElementByAccessibility;
import foodtruck.helpers.UserLoginHelper;
import foodtruck.pages.EnvoyHomePage;
import foodtruck.pages.WonderHomePage;
import org.testng.annotations.Test;

/**
 * @author Michelle
 */
public class FindElementByAccessibilityIdTest extends BaseCase {
    @Test
    public void findRestaurantWithLogin() {
        UserLoginHelper userLoginHelper = new UserLoginHelper();
        userLoginHelper.validUserLogin("mm@cc.com", "pwd11111");
        WonderHomePage wonderHomePage = new WonderHomePage();
    }

    @Test
    public void findRestaurantWithoutLogin() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        RepeatFindElementByAccessibility findElementByAccessibility = new RepeatFindElementByAccessibility();
        findElementByAccessibility.findElementByAccessibility("delivery_button_on_home_page");
    }
}
