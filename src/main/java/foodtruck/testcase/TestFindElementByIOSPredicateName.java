package foodtruck.testcase;

import foodtruck.element.find.FindElementByIOSPredicate;
import foodtruck.properties.SysProperties;
import foodtruck.util.Constant;
import org.testng.annotations.AfterMethod;

/**
 * @author niki
 */
public class TestFindElementByIOSPredicateName extends TestFindElement<FindElementByIOSPredicate>{

    @Override
    protected FindElementByIOSPredicate get() {
        return null;
    }

    @Override
    public void findWonderTab() {
        t.findElementByName("wonder_on_home_page");
    }

    @Override
    public void findRestaurantOnWonderRLP() {
        t.findElementByName("XM Test App Automation Use ONLY restaurant");
    }

    @Override
    public void findMealOnWonderRDP() {
        t.findElementByName(Constant.RESTAURANT);
    }

    @Override
    public void findAddButtonOnWonderMDP() {
        t.findElementByName("take it button");
    }

    @Override
    public void findButtonOnShopCartPage() {
        t.findElementByName("XM Test Chips & Salsa_cart_item");
    }

    @Override
    public void findButtonOnCheckoutPage() {
        t.findElementByName("address_delivery_instructions");
    }

    @Override
    public void findPickupButtonOnEnvoyRDP() {
        t.findElementByName("PICKUP");
    }

    @Override
    public void findBurgersOnEnvoyRLP() {
        t.findElementByName("Burgers_on_home_page");
    }

    @Override
    public void findAddressOnEnvoyRDP() {
        t.findElementByName("address_on_mkp_rlp_page");
    }

    @AfterMethod
    public void terminalApp() {
        if (driver != null) {
            driver.terminateApp(SysProperties.BUNDLE_ID);
        }
    }
}
