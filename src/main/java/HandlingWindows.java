import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class HandlingWindows {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.toolsqa.com/automation-practice-switch-windows");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.id("button1")).click();
        driver.findElement(By.id("button1")).click();
        driver.findElement(By.id("button1")).click();
        driver.findElement(By.id("button1")).click();

        //To retrieve all the opened browsers
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        //Output for the above statement is [15, 4294967345, 4294967354, 4294967365, 4294967368]

        //Using the driver.switchTo90.window() method, we can switch to child windows based on their ids
        for (String handle : handles) {
            driver.switchTo().window(handle);
            driver.get("https://www.google.com");
        }

        driver.quit();
    }
}
