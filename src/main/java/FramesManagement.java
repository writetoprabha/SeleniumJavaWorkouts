import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
frame count on a web page can be retrieved using the findElements method and getSize method
Similar to alerts, once we are done with the frames, we should use the driver.switchTo().defaultContent() method
*/
public class FramesManagement {
    public static void main(String[] args){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/frames");

        driver.findElement(By.linkText("iFrame")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'An iFrame containing the TinyMCE WYSIWYG Editor')]")));

        //retrieves the frame count in the web page
        int frameCount = driver.findElements(By.tagName("iframe")).size();

        if(frameCount > 0) {
            driver.switchTo().frame(0);
            System.out.println(driver.findElement(By.id("tinymce")).getText());
            driver.switchTo().defaultContent();
        }

        driver.navigate().back();
        driver.findElement(By.linkText("Nested Frames")).click();

        frameCount = driver.findElements(By.tagName("frame")).size();

        if(frameCount >0 ) {
            System.out.println("Total number of frames found = " + frameCount);
            for(int frameIndex = 0; frameIndex < frameCount; frameIndex++) {
                System.out.println("Inside Frame #" + (frameIndex + 1));
                driver.switchTo().frame(frameIndex); // => need to pass the index of the frame
                List<WebElement> elements = driver.findElements(By.xpath("//*"));
                getAndPrintTextOfElements(elements);
                driver.switchTo().defaultContent();
            }
        }
    }

    public static void getAndPrintTextOfElements(List<WebElement> elements) {
        for(WebElement element : elements) {
            System.out.println(element.getText());
        }
    }
}
