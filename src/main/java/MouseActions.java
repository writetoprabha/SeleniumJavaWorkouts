import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement src = driver.findElement(By.id("column-a"));
        WebElement dest = driver.findElement(By.id("column-b"));
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        action.dragAndDrop(src, dest).build().perform();
    }
}
