import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class MobileAutomation extends MobileBase {
    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = getAppiumAndroidDriver();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
        driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/edit']")).sendKeys("Some text goes here");
        driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();

    }
}
