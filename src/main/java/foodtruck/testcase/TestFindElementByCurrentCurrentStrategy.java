package foodtruck.testcase;

import foodtruck.element.find.FindElementByCurrent;
import foodtruck.util.Constant;

/**
 * @author niki
 */
public class TestFindElementByCurrentCurrentStrategy extends TestFindElement<FindElementByCurrent> {

    @Override
    protected FindElementByCurrent get() {
        return new FindElementByCurrent(driver);
    }

    @Override
    public void findWonderTab() {
        t.findElementByAccessibility("wonder_on_home_page");
    }

    @Override
    public void findRestaurantOnWonderRLP() {
        t.findElementByAccessibility(Constant.RESTAURANT + " restaurant");
    }

    @Override
    public void findMealOnWonderRDP() {
        t.findElementByAccessibility("XM Test Chips & Salsa meal");
    }

    @Override
    public void findAddButtonOnWonderMDP(){
        t.findElementByAccessibility("take it button");
    }

    @Override
    public void findButtonOnShopCartPage() {
        t.findElementByAccessibility("XM Test Chips & Salsa_cart_item");
    }

    @Override
    public void findButtonOnCheckoutPage() {
        t.findElementByAccessibility("address_delivery_instructions");
    }

    @Override
    public void findPickupButtonOnEnvoyRDP() {
        t.findElementByAccessibility("PICKUP");
    }

    @Override
    public void findBurgersOnEnvoyRLP() {
        t.findElementByAccessibility("Burgers_on_home_page");
    }

    @Override
    public void findAddressOnEnvoyRDP() {
        t.findElementByAccessibility("address_on_mkp_rlp_page");
    }

}
