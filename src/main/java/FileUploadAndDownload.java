import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FileUploadAndDownload {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/upload");

        // **************************************************************************************************************
        driver.findElement(By.id("file-upload")).sendKeys(System.getProperty("user.dir") + "/Files/toUpload/achu.jpeg");
        // **************************************************************************************************************
        System.out.println(driver.findElement(By.id("file-upload")).getAttribute("value"));
        driver.findElement(By.id("file-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        System.out.println(driver.findElement(By.id("uploaded-files")).getText());
        driver.quit();

        /*To Download **************************************************************************************************************
        * In firefox and chrome, we can directly download the files using selenium code
        * In IE and edge, we need to use http client to download files
        *
        * Before writing the code to download the file, we need to make sure that the browser should not display the download dialog box
        * Can use FirefoxOptions and FirefoxProfile objects to set preferences
        *
        * Objects to use for Firefox driver:
        * FirefoxOptions
        * FirefoxProfile
        * FirefoxDriver
        ************************************************************************************************************************** */
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        firefoxProfile.setPreference("browser.download.folderList", 2); //preference can be taken from about:config of firefox
        firefoxProfile.setPreference("browser.download.dir", System.getProperty("user.dir") + "/Files/downloaded");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        firefoxProfile.setPreference("browser.download.forbid_open_with", true);

        firefoxOptions.setProfile(firefoxProfile);
        WebDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        firefoxDriver.get("https://the-internet.herokuapp.com/download");
        firefoxDriver.findElement(By.linkText("restdoc.docx")).click();

    }
}
