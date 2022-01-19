package foodtruck.testcase;

import foodtruck.common.BaseCase;
import foodtruck.element.find.FindElementByAndroidUIAutomator;
import foodtruck.element.find.FindElementByIOSPredicate;
import foodtruck.element.wait.WaitElementByAndroidUIAutomator;
import foodtruck.element.wait.WaitElementByIOSPredicate;
import org.testng.annotations.Test;

/**
 * @author niki
 */
public class Login extends BaseCase {

    @Test
    public void loginWithEmailOnIOS() {
        FindElementByIOSPredicate findInstance = FindElementByIOSPredicate.instance(driver);
        findInstance.setCount(1);
        WaitElementByIOSPredicate waitInstance = WaitElementByIOSPredicate.instance(driver);
//        findInstance.findElementByLabel("LOGIN").click();
        findInstance.findElementByName("profile button").click();
        waitInstance.waitElementByLabel("Login");
        findInstance.findElementByLabel("Login").click();
        waitInstance.waitElementByLabel("LOGIN WITH EMAIL");
        findInstance.findElementByLabel("LOGIN WITH EMAIL").click();
        waitInstance.waitElementByLabel("LOGIN WITH PHONE NUMBER");
        findInstance.findElementByName("email_input_on_email_login_page").sendKeys("nikisun@chancetop.com");
        findInstance.findElementByName("password_input_on_email_login_page").sendKeys("pwd11111");
        findInstance.findElementByLabel("LOG IN").click();
        waitInstance.waitElementByName("profile button");
        findInstance.findElementByName("profile button").click();
        waitInstance.waitElementByLabel("Logout");
        findInstance.findElementByLabel("Logout").click();
        waitInstance.waitElementByLabel("Yes");
        findInstance.findElementByLabel("Yes").click();
//        waitInstance.waitElementByLabel("Allow Once");
        waitInstance.waitElementByLabel("LOGIN WITH EMAIL");

    }

    @Test
    public void loginWithEmailOnAndroid() {
        FindElementByAndroidUIAutomator findInstance = FindElementByAndroidUIAutomator.instance(driver);
        findInstance.setCount(1);
        WaitElementByAndroidUIAutomator waitInstance = WaitElementByAndroidUIAutomator.instance(driver);
//        findInstance.findElementByText("LOGIN").click();
        findInstance.findElementByContentDesc("profile button").click();
        waitInstance.waitElementByText("Login");
        findInstance.findElementByText("Login").click();
        waitInstance.waitElementByText("LOGIN WITH EMAIL");
        findInstance.findElementByText("LOGIN WITH EMAIL").click();
        waitInstance.waitElementByText("LOGIN WITH PHONE NUMBER");
        findInstance.findElementByContentDesc("email_input_on_email_login_page").sendKeys("nikisun@chancetop.com");
        findInstance.findElementByContentDesc("password_input_on_email_login_page").sendKeys("pwd11111");
        findInstance.findElementByText("LOG IN").click();
        waitInstance.waitElementByContentDesc("profile button");
        findInstance.findElementByContentDesc("profile button").click();
        waitInstance.waitElementByText("Logout");
        findInstance.findElementByText("Logout").click();
        waitInstance.waitElementByText("YES");
        findInstance.findElementByText("YES").click();
        waitInstance.waitElementByText("LOGIN WITH EMAIL");
    }
}
