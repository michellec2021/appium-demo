package foodtruck.element.find;

import foodtruck.common.BaseCase;
import foodtruck.util.StopWatch;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Michelle
 * Read a unique identifier for a UI element.
 * For XCUITest it is the element's accessibility-id attribute.
 * For Android it is the element's content-desc attribute.
 */
public class FindElementByAccessibilityId extends BaseCase {
    protected static final Logger LOGGER = LoggerFactory.getLogger(FindElementByAccessibilityId.class);

    @Test
    public void findLoginButton() {

        long totalElapsed = 0;
        int count = 100;
        for (int i = 0; i < count; i++) {
            StopWatch stopWatch = new StopWatch();
            WebElement loginButton = driver.findElementByAccessibilityId("login_button_on_welcome_page");
            totalElapsed = totalElapsed + stopWatch.elapsed();
            LOGGER.info("elapsed={}", stopWatch.elapsed());
        }
        LOGGER.info("averaged elapsed={}", totalElapsed / count);
    }
}
