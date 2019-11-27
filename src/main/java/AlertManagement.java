import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//Handling native java script alerts
public class AlertManagement {
    public static void main(String args[]) {

        //WebDriver object initialization
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]")).click();

        //Waits until the alert is displayed. Usualy alerts are immediate.
        // But it is always safe to use the explicit wait to wait until the alert is displayed.
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());

        /*
        After the alert is displayed, we need to make the driver point to the alert window.
        driver.switchTo() statement is used
        After performing actions on the alert, we need to point driver back to browser window. defaultContent() method is used for the same.
        */
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]")).click();
        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.dismiss();
        driver.switchTo().defaultContent();


        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Prompt')]")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.sendKeys("Some text goes here");
        alert.accept();
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

    }
}
