package foodtruck.testcase;

import foodtruck.element.find.FindElementByIOSPredicate;
import org.testng.annotations.Test;

/**
 * @author niki
 */
public class TestFindElementByIOSPredicateLabel extends TestFindElement<FindElementByIOSPredicate>{

    @Override
    protected FindElementByIOSPredicate get() {
        return new FindElementByIOSPredicate(driver);
    }

    @Test
    public void findWonderTab() {
        t.findElementByLabel("wonder_on_home_page");
    }

    @Test
    public void findRestaurantOnWonderRLP() {
        t.findElementByLabel("App Automation Use ONLY American $$ App Automation Use ONLY");
    }

    @Test
    public void findMealOnWonderRDP() {
        t.findElementByLabel("1 XM Test Chips & Salsa Crispy on the outside. Tender, juicy, organic white meat on the inside $33.00");
    }

    @Test
    public void findAddButtonOnWonderMDP() {
        t.findElementByLabel("ADD — $33.00");
    }

    @Test
    public void findButtonOnShopCartPage() {
        t.findElementByLabel("1 XM Test Chips & Salsa $33.00 MODIFY DELETE");
    }

    @Test
    public void findButtonOnCheckoutPage() {
        t.findElementByLabel("Add delivery instructions");
    }

    @Test
    public void findPickupButtonOnEnvoyRDP() {
        t.findElementByLabel("PICKUP");
    }

    @Test
    public void findBurgersOnEnvoyRLP() {
        t.findElementByLabel("Burgers");
    }

    @Test
    public void findAddressOnEnvoyRDP() {
        t.findElementByLabel("117 N Union Ave, Cranford, NJ, 07016");
    }
}
