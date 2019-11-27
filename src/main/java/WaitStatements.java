import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/*Three types of wait statements are available
Implicit wait driver.manage.Timeouts.implicitelyWait => sets the timeout for all driver.findElementBy statements
Explicit wait => WebDriverWait => wait.until(ExpectedConditions.visibilityOfElementLocated
Static wait => Thread.sleep => should not be used
 */
public class WaitStatements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize(); // => To maximize the window
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //=> implicit wait
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//a[contains(text(), 'Dynamic Controls')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Remove')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(), 'Remove')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add')]")));
        Thread.sleep(3000); // => static wait. should not be used very offen
    }
}
