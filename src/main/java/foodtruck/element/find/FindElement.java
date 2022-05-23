package foodtruck.element.find;

import foodtruck.util.StopWatch;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niki
 */
public abstract class FindElement {
    protected final AppiumDriver<MobileElement> driver;
    protected long count = 100;
    protected List<Long> sum = new ArrayList<>();

    protected abstract Logger getLogger();

    protected FindElement(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    protected MobileElement findElement(By by) {
        long totalElapsed = 0;
        MobileElement mobileElement = null;
        for (int i = 0; i < count; i++) {
            StopWatch stopWatch = new StopWatch();
            mobileElement = driver.findElement(by);
            totalElapsed = totalElapsed + stopWatch.elapsed();
            getLogger().info("find element elapsed time = {} ms", stopWatch.elapsed() / 1000000);
        }
        long avgTime = totalElapsed / count / 1000000;
        getLogger().info("find element average elapsed time = {} ms", avgTime);
        sum.add(avgTime);
        return mobileElement;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getAvgTime(int loopCount) {
        Long total = sum.stream().reduce(Long::sum).get();
        System.out.println(sum);
        return total/loopCount;
    }
}
