package foodtruck.testcase;

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
public class AndroidSwipeTest extends BaseCase {
    /*
     * avg swipe time is 606ms, tested for 80 times;
     * */
    @Test
    public void dragGesture() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();

        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        Thread.sleep(3000);

        //参数：elementId拖动作用的点、所有坐标都是相对这个元素、如果这个参数没设置则坐标为绝对坐标
        //如果element有设置，且start point也设置，则这些坐标为element左上角为起始点的相对位置。
        //speed每秒执行按pixel执行的速率，不能为负数，默认为2500*displayDensity
        StopWatch stopWatch = new StopWatch();
        long totalElapsed = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 2; j++) {
                stopWatch.reset();
                Map<String, Object> dragDownParms = new HashMap<>();
                dragDownParms.put("startX", width / 2);
                dragDownParms.put("startY", height / 2);
                dragDownParms.put("endX", width / 2);
                dragDownParms.put("endY", 0);
                driver.executeScript("mobile: dragGesture", dragDownParms);
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("drag swipe elapsed = " + stopWatch.elapsedInMilliSecond());
            }

            for (int j = 0; j < 2; j++) {
                stopWatch.reset();
                Map<String, Object> dragUpParms = new HashMap<>();
                dragUpParms.put("startX", width / 2);
                dragUpParms.put("startY", height / 2);
                dragUpParms.put("endX", width / 2);
                dragUpParms.put("endY", height - 10);
                driver.executeScript("mobile: dragGesture", dragUpParms);
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("drag swipe perform elapsed = " + stopWatch.elapsedInMilliSecond());
            }
        }
        long avgElapsed = totalElapsed / 80;
        System.out.println("avgElapsed = " + avgElapsed);
    }

    /*
     * avg swipe time is 1911ms, tested for 80 times
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
     * avg swipe time is 646ms, tested for 80 times
     * elementId: 滑动时作用的element，如果没这个字段则滑动区域必须设置，如果两个都设置了，则忽略滑动区域.
     * left:The left coordinate of the swipe bounding area（相当于x坐标）
     * top:The top coordinate of the swipe bounding area（相当于y坐标）
     * width:The width of the swipe bounding area
     * height:The height of the swipe bounding area
     * direction:up, down, left and right
     * percent:滑动区域的滑动百分比，0.1代表10%，1代表100%
     * speed每秒执行按pixel执行的速率，不能为负数，默认为5000*displayDensity
     * */
    @Test
    public void mobileSwipe() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();
        System.out.println("size = " + size);

        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        Thread.sleep(3000);
        StopWatch stopWatch = new StopWatch();
        long totalElapsed = 0;
        MobileElement element = driver.findElementByAccessibilityId("Wonder Delivery - Automation USE ONLY_on_home_page");
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                stopWatch.reset();
                Map<String, Object> swipeParms = new HashMap<>();
                swipeParms.put("left", width / 2);
                swipeParms.put("top", height / 2);
                swipeParms.put("width", width / 2);
                swipeParms.put("height", height / 2);
                swipeParms.put("direction", "left");
                swipeParms.put("percent", 0.75);
                driver.executeScript("mobile: scrollGesture", swipeParms);
                totalElapsed = totalElapsed + stopWatch.elapsedInMilliSecond();
                System.out.println("swipe elapsed = " + stopWatch.elapsedInMilliSecond());
            }
            long avgElapsed = totalElapsed / 1;
            System.out.println("avgElapsed = " + avgElapsed);
        }
    }
}
