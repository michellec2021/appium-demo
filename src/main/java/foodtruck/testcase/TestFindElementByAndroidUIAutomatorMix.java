package foodtruck.testcase;

import foodtruck.common.DriverInstance;
import foodtruck.element.find.FindElementByAndroidUIAutomator;
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
import foodtruck.util.Constant;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author niki
 */
public class TestFindElementByAndroidUIAutomatorMix {
    public String email = "nikisun@chancetop.com";
    public String password = "pwd11111";
    public AppiumDriver<MobileElement> driver;
    public int loopCount;
    public FindElementByAndroidUIAutomator findElementByAndroidUIAutomator;

    @BeforeClass
    public void initFindElement() {
        loopCount = 20;
        DriverInstance of = DriverInstance.of();
        this.driver = of.driver;
        UserLoginHelper userLoginHelper = new UserLoginHelper();
        userLoginHelper.validUserLogin(email, password);
    }

    @BeforeMethod
    public void restartApp() {
        driver.activateApp(SysProperties.BUNDLE_ID);
    }

    @Test
    public void findWonderTab() {
        findElementByAndroidUIAutomator = FindElementByAndroidUIAutomator.instance(driver);
        findElementByAndroidUIAutomator.setCount(1);
        for (int i = 0; i < loopCount; i++) {
            WonderHomePage wonderHomePage = new WonderHomePage();
            findElementByAndroidUIAutomator.findElement("new UiSelector().className(\"android.view.View\").description(\"wonder_on_home_page\")");
            driver.closeApp();
            driver.launchApp();
        }
        System.out.println(findElementByAndroidUIAutomator.getAvgTime(loopCount));
    }

    @Test
    public void findRestaurantOnWonderRLP() {
        findElementByAndroidUIAutomator = FindElementByAndroidUIAutomator.instance(driver);
        findElementByAndroidUIAutomator.setCount(1);
        for (int i = 0; i < loopCount; i++) {
            WonderHomePage wonderHomePage = new WonderHomePage();
            findElementByAndroidUIAutomator.findElement("new UiSelector().className(\"android.view.ViewGroup\").descriptionContains(\"App Automation Use\")");
            driver.closeApp();
            driver.launchApp();
        }
        System.out.println(findElementByAndroidUIAutomator.getAvgTime(loopCount));
    }

    @Test
    public void findMealOnWonderRDP() throws InterruptedException {
        findElementByAndroidUIAutomator = FindElementByAndroidUIAutomator.instance(driver);
        findElementByAndroidUIAutomator.setCount(1);
        for (int i = 0; i < loopCount; i++) {
            WonderHomePage wonderHomePage = new WonderHomePage();
            wonderHomePage.clickRestaurant(Constant.RESTAURANT);
            Thread.sleep(5000);
            BaseUtils.swipeToUp(0.4, 2, 1000);
            findElementByAndroidUIAutomator.findElement("new UiSelector().className(\"android.widget.TextView\").text(\"XM Test Chips & Salsa\")");
            new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("back_button_on_restaurant_detail_page"))).click();
        }
        System.out.println(findElementByAndroidUIAutomator.getAvgTime(loopCount));
    }

    @Test
    public void findAddButtonOnWonderMDP() throws InterruptedException {
        findElementByAndroidUIAutomator = FindElementByAndroidUIAutomator.instance(driver);
        findElementByAndroidUIAutomator.setCount(1);
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant(Constant.RESTAURANT);
        Thread.sleep(5000);
        BaseUtils.swipeToUp(0.4, 2, 1000);
        WonderRestaurantDetailPage wonderRestaurantDetailPage = new WonderRestaurantDetailPage();
        wonderRestaurantDetailPage.clickMeal("XM Test Chips & Salsa");
        WonderMealDetailPage mealDetailPage = new WonderMealDetailPage();
        findElementByAndroidUIAutomator.findElement("new UiSelector().className(\"android.widget.TextView\").description(\"take it button\")");
        mealDetailPage.clickBack();
        for (int i = 0; i < loopCount - 1; i++) {
            wonderRestaurantDetailPage = new WonderRestaurantDetailPage();
            wonderRestaurantDetailPage.clickMeal("XM Test Chips & Salsa");
            mealDetailPage = new WonderMealDetailPage();
            findElementByAndroidUIAutomator.findElement("new UiSelector().className(\"android.widget.TextView\").description(\"take it button\")");
            Thread.sleep(1000);
            mealDetailPage.clickBack();
        }
        System.out.println(findElementByAndroidUIAutomator.getAvgTime(loopCount));
    }

    @Test
    public void findButtonOnShopCartPage() throws InterruptedException {
        findElementByAndroidUIAutomator = FindElementByAndroidUIAutomator.instance(driver);
        findElementByAndroidUIAutomator.setCount(1);
        for (int i = 0; i < loopCount; i++) {
            WonderHomePage wonderHomePage = new WonderHomePage();
            wonderHomePage.clickViewOrder();
            WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
            findElementByAndroidUIAutomator.findElement("new UiSelector().className(\"android.widget.TextView\").text(\"XM Test Chips & Salsa\")");
            Thread.sleep(1000);
            wonderShopCartPage.clickBack();
        }
        System.out.println(findElementByAndroidUIAutomator.getAvgTime(loopCount));
    }

    @Test
    public void findButtonOnCheckoutPage() throws InterruptedException {
        findElementByAndroidUIAutomator = FindElementByAndroidUIAutomator.instance(driver);
        findElementByAndroidUIAutomator.setCount(1);
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickViewOrder();
        for (int i = 0; i < loopCount; i++) {
            WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
            wonderShopCartPage.clickCheckoutButton();
            WonderCheckoutPage checkoutPage = new WonderCheckoutPage();
            findElementByAndroidUIAutomator.findElement("new UiSelector().description(\"address_delivery_instructions\").text(\"Add delivery instructions\")");
            Thread.sleep(1000);
            checkoutPage.clickBack();
        }
        System.out.println(findElementByAndroidUIAutomator.getAvgTime(loopCount));
    }

//    @Test
//    public void findPickupButtonOnEnvoyRLP() {
//        findElementByAndroidUIAutomator = FindElementByAndroidUIAutomator.instance(driver);
//        findElementByAndroidUIAutomator.setCount(1);
//        for (int i = 0; i < loopCount; i++) {
//            WonderHomePage wonderHomePage = new WonderHomePage();
//            wonderHomePage.clickEnvoy();
//            EnvoyHomePage envoyHomePage = new EnvoyHomePage();
//            findElementByAndroidUIAutomator.findElementByContentDesc("pickup_button_on_home_page");
//            envoyHomePage.clickWonderTab();
//        }
//        System.out.println(findElementByAndroidUIAutomator.getAvgTime(loopCount));
//
//    }

    @Test
    public void findBurgersOnEnvoyRLP() {
        findElementByAndroidUIAutomator = FindElementByAndroidUIAutomator.instance(driver);
        findElementByAndroidUIAutomator.setCount(1);
        for (int i = 0; i < loopCount; i++) {
            WonderHomePage wonderHomePage = new WonderHomePage();
            wonderHomePage.clickEnvoy();
            EnvoyHomePage envoyHomePage = new EnvoyHomePage();
            findElementByAndroidUIAutomator.findElement("new UiSelector().text(\"Burgers\").descriptionStartsWith(\"Burgers\")");
            envoyHomePage.clickWonderTab();
        }
        System.out.println(findElementByAndroidUIAutomator.getAvgTime(loopCount));

    }

    @Test
    public void findAddressOnEnvoyRDP() {
        findElementByAndroidUIAutomator = FindElementByAndroidUIAutomator.instance(driver);
        findElementByAndroidUIAutomator.setCount(1);
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        BaseUtils.swipeToUp(0.3, 1, 1000);
        for (int i = 0; i < loopCount; i++) {
            envoyHomePage = new EnvoyHomePage();
            envoyHomePage.clickRestaurant("Closed - Marketplace Automation USE ONLY");
            EnvoyRestaurantDetailPage envoyRestaurantDetailPage = new EnvoyRestaurantDetailPage();
            findElementByAndroidUIAutomator.findElement("new UiSelector().className(\"android.widget.TextView\").description(\"address_on_mkp_rlp_page\")");
            envoyRestaurantDetailPage.clickBack();
        }
        System.out.println(findElementByAndroidUIAutomator.getAvgTime(loopCount));
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
