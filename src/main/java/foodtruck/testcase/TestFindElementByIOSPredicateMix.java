package foodtruck.testcase;

import foodtruck.common.DriverInstance;
import foodtruck.element.find.FindElementByIOSPredicate;
import foodtruck.helpers.UserLoginHelper;
import foodtruck.pages.EnvoyHomePage;
import foodtruck.pages.EnvoyRestaurantDetailPage;
import foodtruck.pages.WonderCheckoutPage;
import foodtruck.pages.WonderHomePage;
import foodtruck.pages.WonderMealDetailPage;
import foodtruck.pages.WonderRestaurantDetailPage;
import foodtruck.pages.WonderShopCartPage;
import foodtruck.properties.SysProperties;
import foodtruck.util.BaseUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author niki
 */
public class TestFindElementByIOSPredicateMix {
    public String email = "nikisun@chancetop.com";
    public String password = "pwd11111";
    public AppiumDriver<MobileElement> driver;

    public FindElementByIOSPredicate findElementByIOSPredicate;

    @BeforeClass
    public void initFindElement() {
        DriverInstance of = DriverInstance.of();
        this.driver = of.driver;
        findElementByIOSPredicate = FindElementByIOSPredicate.instance(driver);
        findElementByIOSPredicate.setCount(20);
        UserLoginHelper userLoginHelper = new UserLoginHelper();
        userLoginHelper.validUserLogin(email, password);
    }

    @BeforeMethod
    public void restartApp() {
        driver.activateApp(SysProperties.BUNDLE_ID);
    }

    @Test
    public void findWonderTab() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        findElementByIOSPredicate.findElement("label == 'wonder_on_home_page' AND name == 'wonder_on_home_page'");
    }

    @Test
    public void findRestaurantOnWonderRLP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        findElementByIOSPredicate.findElement("label == \"Vertical scroll bar, 7 pages XM Test Automation Use ONLY XM Test Automation Use ONLY 6 min away $$\" AND name == \"XM Test Automation Use ONLY restaurant\"");
    }

    @Test
    public void findMealOnWonderRDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant("XM Test Automation Use ONLY");
        WonderRestaurantDetailPage wonderRestaurantDetailPage = new WonderRestaurantDetailPage();
        BaseUtils.swipeToUp(2, 1000);
        findElementByIOSPredicate.findElement("label == \"1 XM Test Chips & Salsa Crispy on the outside. Tender, juicy, organic white meat on the inside $33.00\" AND name == \"XM Test Chips & Salsa meal\"");
    }

    @Test
    public void findAddButtonOnWonderMDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant("XM Test Automation Use ONLY");
        WonderRestaurantDetailPage wonderRestaurantDetailPage = new WonderRestaurantDetailPage();
        BaseUtils.swipeToUp(2, 1000);
        wonderRestaurantDetailPage.clickMeal("XM Test Chips & Salsa");
        WonderMealDetailPage mealDetailPage = new WonderMealDetailPage();
        findElementByIOSPredicate.findElement("label == \"ADD — $33.00\" AND name == \"take it button\"");
    }

    @Test
    public void findButtonOnShopCartPage() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickViewOrder();
        WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
        findElementByIOSPredicate.findElement("label == \"1 XM Test Chips & Salsa $33.00 MODIFY DELETE\" AND name == \"XM Test Chips & Salsa_cart_item\"");
    }

    @Test
    public void findButtonOnCheckoutPage() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickViewOrder();
        WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
        wonderShopCartPage.clickCheckoutButton();
        WonderCheckoutPage checkoutPage = new WonderCheckoutPage();
        findElementByIOSPredicate.findElement("label == \"Add delivery instructions\" AND name == \"address_delivery_instructions\"");
    }

    @Test
    public void findPickupButtonOnEnvoyRLP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        findElementByIOSPredicate.findElement("label == \"PICKUP\" AND name == \"pickup_button_on_home_page\"");
    }

    @Test
    public void findBurgersOnEnvoyRLP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        findElementByIOSPredicate.findElement("label == \"Burgers\" AND name == \"Burgers_on_home_page\"");
    }

    @Test
    public void findAddressOnEnvoyRDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        envoyHomePage.clickRestaurant("Closed - Marketplace Automation USE ONLY");
        EnvoyRestaurantDetailPage envoyRestaurantDetailPage = new EnvoyRestaurantDetailPage();
        findElementByIOSPredicate.findElement("label == \"117 N Union Ave, Cranford, NJ, 07016\" AND name == \"address_on_mkp_rlp_page\"");
    }

    @AfterMethod
    public void terminalApp() {
        if (driver != null) {
            driver.terminateApp(SysProperties.BUNDLE_ID);
        }
    }

    @AfterClass
    public void removeApp() {
        if (driver != null) {
            driver.removeApp(SysProperties.BUNDLE_ID);
        }
    }
}
