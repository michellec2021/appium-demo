package foodtruck.testcase;

import com.google.common.collect.ImmutableMap;
import foodtruck.common.BaseCase;
import foodtruck.pages.WonderHomePage;
import foodtruck.util.StopWatch;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.appium.java_client.touch.offset.PointOption.point;

/**
 * @author michelle
 */
public class IOSSwipeTest extends BaseCase {
    /*
     * avg swipe time is 646ms, tested for 80 times
     * regression的时间和这边没差
     * 虽然这个滑动的速度很快，但是滑动的距离太小了；差不多滑动到MKP底部要10次，但是drag方法只需要4次，因此这个方法没有很大的优势
     * */
    @Test
    public void mobileSwipe() throws InterruptedException {
        WonderHomePage wonderHomePage = new WonderHomePage();
        Thread.sleep(1000);
        wonderHomePage.clickEnvoy();
        Thread.sleep(3000);
        StopWatch stopWatch = new StopWatch();
        long totalElapsed = 0;
        //velocity值越大滑动的越快，同样的值在不同设备上滑动速率可能不一样
        MobileElement element = driver.findElementByAccessibilityId("Wonder Delivery - Automation USE ONLY_on_home_page");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 2; j++) {
                stopWatch.reset();
                driver.executeScript("mobile: swipe", ImmutableMap.of("direction", "up", "elementId", element.getId()));
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("swipe elapsed = " + stopWatch.elapsedInMilliSecond());
            }

            for (int j = 0; j < 2; j++) {
                stopWatch.reset();
                driver.executeScript("mobile: swipe", ImmutableMap.of("direction", "down", "elementId", element.getId()));
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("swipe elapsed = " + stopWatch.elapsedInMilliSecond());
            }
        }
        long avgElapsed = totalElapsed / 80;
        System.out.println("avgElapsed = " + avgElapsed);
    }

    /*
     * avg swipe time is 3520ms, tested for 80 times
     * */
    @Test
    public void mobileScroll() throws InterruptedException {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        Thread.sleep(3000);
        StopWatch stopWatch = new StopWatch();
        long totalElapsed = 0;
        //MobileElement element = driver.findElementByAccessibilityId("Automation USE ONLY Marketplace_on_home_page");
        //scroll滚动的距离比swipe大很多, 如果有设置滑动元素，则滑动的距离比较短
        //当element已经在页面存在时，则滑动到element出来,并且滑动的距离不大；但是如果element不存在，则不滑动；
        //name和predicate没啥用，写上去后基本不滑动
        //官网说当element不是container时，则无效，这个container是干啥的？？
        //看官网说明element是scroll on的元素
        //这个方法的实现是在一些uncheeck的
        //driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down", "name", "Automation USE ONLY Marketplace_on_home_page", "toVisible", true));
        MobileElement element = driver.findElementByAccessibilityId("Paused - Marketplace Automation USE ONLY_on_home_page");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 2; j++) {
                stopWatch.reset();
                driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down", "elementId", element.getId()));
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("scroll elapsed = " + stopWatch.elapsedInMilliSecond());
            }

            for (int j = 0; j < 2; j++) {
                stopWatch.reset();
                driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "up"));
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("scroll elapsed = " + stopWatch.elapsedInMilliSecond());
            }
        }
        long avgElapsed = totalElapsed / 80;
        System.out.println("avgElapsed = " + avgElapsed);
    }

    /*
     * avg swipe time is 1614ms, tested for 80 times; duration=0.01,avg=1539;
     * 这个方法在regression项目没啥区别
     * */
    @Test
    public void dragFromToForDuration() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();

        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        Thread.sleep(3000);

        //参数：elementId拖动作用的点、所有坐标都是相对这个元素、如果这个参数没设置则坐标为绝对坐标
        //duration点击后停留多久0.5-60(s)
        //fromX、fromY、toX、toY
        StopWatch stopWatch = new StopWatch();
        long totalElapsed = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 2; j++) {
                stopWatch.reset();
                Map<String, Object> dragDownParms = new HashMap<>();
                dragDownParms.put("duration", 0);
                dragDownParms.put("fromX", width / 2);
                dragDownParms.put("fromY", height / 2);
                dragDownParms.put("toX", width / 2);
                dragDownParms.put("toY", 0);
                driver.executeScript("mobile: dragFromToForDuration", dragDownParms);
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("drag swipe elapsed = " + stopWatch.elapsedInMilliSecond());
            }

            for (int j = 0; j < 2; j++) {
                stopWatch.reset();
                Map<String, Object> dragUpParms = new HashMap<>();
                dragUpParms.put("duration", 0.1);
                dragUpParms.put("fromX", width / 2);
                dragUpParms.put("fromY", height / 2);
                dragUpParms.put("toX", width / 2);
                dragUpParms.put("toY", height - 10);
                driver.executeScript("mobile: dragFromToForDuration", dragUpParms);
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("drag swipe perform elapsed = " + stopWatch.elapsedInMilliSecond());
            }
        }
        long avgElapsed = totalElapsed / 80;
        System.out.println("avgElapsed = " + avgElapsed);
    }

    /*
     * avg swipe time is 890ms, tested for 80 times
     * 问题：这个方法在regression项目里跑得特别慢，是因为加了wdaEventloopIdleDelay这个参数
     * */
    @Test
    public void touchPerformTest() throws InterruptedException, IOException {
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();

        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        Thread.sleep(3000);

        StopWatch stopWatch = new StopWatch();

        long totalElapsed = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 2; j++) {
                stopWatch.reset();
                new TouchAction<>(driver)
                        .longPress(point(width / 2, height / 2))
                        .moveTo(point(width / 2, 0))
                        .release().perform();
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("touch perform elapsed = " + stopWatch.elapsedInMilliSecond());
            }

            for (int j = 0; j < 2; j++) {
                stopWatch.reset();
                new TouchAction<>(driver)
                        .longPress(point(width / 2, height / 2))
                        .moveTo(point(width / 2, height - 10))
                        .release().perform();
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("touch perform elapsed = " + stopWatch.elapsedInMilliSecond());
            }
        }

        long avgElapsed = totalElapsed / 80;
        System.out.println("avgElapsed = " + avgElapsed);
    }

    /*
     * 官网有这个文档，但是实际跑起来会报错提示没这个命令。
     * */
    @Test
    public void scrollToElement() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();

        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        Thread.sleep(3000);

        //参数：elementId拖动作用的点、所有坐标都是相对这个元素、如果这个参数没设置则坐标为绝对坐标
        //duration点击后停留多久0.5-60(s)
        StopWatch stopWatch = new StopWatch();
        long totalElapsed = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                stopWatch.reset();
                String elementId = driver.findElementByAccessibilityId("Restaurant Delivery - Automation USE ONLY_on_home_page").getId();
                driver.executeScript("mobile: scrollToElement", elementId);
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("drag scroll to element elapsed = " + stopWatch.elapsedInMilliSecond());
            }
        }
        long avgElapsed = totalElapsed / 1;
        System.out.println("avgElapsed = " + avgElapsed);
    }
}
