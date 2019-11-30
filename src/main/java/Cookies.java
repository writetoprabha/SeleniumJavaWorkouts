import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
    At times we get test cases to verify that a specific cookie is present after performing an action in the application.
    In such cases, we can use the getCookies method of driver.manage() to iterate through the cookies and verify

    To verify that a certain cookie is present:
    * First we need to get all the cookies and assign it to a Set of type Cookie
    * Create an Iterator object on the Set object using Iterator <iteratorName> = setObject.iterator(); method
    * while iterator object has next element, iterate and find the cookie
 */
public class Cookies {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies(); //delete all the cookies before performing the required operation

        driver.get("https://secure01b.chase.com/web/auth/dashboard");
        Set<Cookie> cookiesSet = driver.manage().getCookies(); //returns cookies present in the driver
        Iterator cookies = cookiesSet.iterator(); //create the iterator object on the set object
        while(cookies.hasNext()) {
            Cookie cookie = (Cookie) cookies.next();
            System.out.println(cookie.getName() + " = " + cookie.getValue());
        }

        driver.get("http://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'A/B Testing')]")));

        //*************************************************************************************************
        //To find the x and y co-ordinates of an element
        int x = driver.findElement(By.xpath("//a[contains(text(), 'A/B Testing')]")).getLocation().x;
        int y = driver.findElement(By.xpath("//a[contains(text(), 'A/B Testing')]")).getLocation().y;

        System.out.println("Location of 'A/B Testing' link field on screen is: (" + x + " , " + y + ")" );
    }

}
