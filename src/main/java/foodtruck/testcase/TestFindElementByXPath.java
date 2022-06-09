package foodtruck.testcase;

import foodtruck.element.find.FindElementByXPath;
import foodtruck.util.Constant;

/**
 * @author niki
 */
public class TestFindElementByXPath extends TestFindElement<FindElementByXPath>{

    @Override
    protected FindElementByXPath get() {
        return new FindElementByXPath(driver);
    }

    @Override
    public void findWonderTab() {
        t.findElementByDesc("wonder_on_home_page");
    }

    @Override
    public void findRestaurantOnWonderRLP() {
        t.findElementByDesc(Constant.RESTAURANT + " restaurant");
    }

    @Override
    public void findMealOnWonderRDP() {
        t.findElementByDesc("XM Test Chips & Salsa meal");
    }

    @Override
    public void findAddButtonOnWonderMDP() {
        t.findElementByText("ADD — $33.00");
    }

    @Override
    public void findButtonOnShopCartPage() {
        t.findElementByText("XM Test Chips & Salsa");
    }

    @Override
    public void findButtonOnCheckoutPage() {
        t.findElementByDesc("address_delivery_instructions");
    }

    @Override
    public void findPickupButtonOnEnvoyRDP() {
        t.findElementByText("PICKUP");
    }

    @Override
    public void findBurgersOnEnvoyRLP() {
        t.findElementByDesc("Burgers_on_home_page");
    }

    @Override
    public void findAddressOnEnvoyRDP() {
        t.findElementByText("117 N Union Ave, Cranford, NJ, 07016");
    }
}
