import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class MobileGestures extends MobileBase{

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = getAppiumAndroidDriver();
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

        // To scroll to an element present in the screen.
        //*************************************************
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Visibility\"));");
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Date Widgets\"));");

        driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();
        WebElement source = driver.findElementByXPath("//*[@content-desc='10']");
        WebElement destination = driver.findElementByXPath("//*[@content-desc='50']");

        TouchAction touch = new TouchAction(driver);

        touch.longPress(LongPressOptions.longPressOptions().withElement(element(source)).withDuration(Duration.ofSeconds(2))).moveTo(element(destination)).release().perform();
        //touch.longPress(element(source)).moveTo(element(destination)).release().perform();

    }
}
