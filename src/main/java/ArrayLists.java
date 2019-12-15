import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;

/* Task: Understand ArrayLists and its uses
   * Array lists are containers used to group/store multiple items
   * Size is dynamic - no need to define the size
   * Can be used to retrieve group of elements from the webpage and store them in arrayList
   * Example: Retrieve all the links displayed in the webpage and print it.
   * Whenever an xpath retrieves more than 1 element, it should be stored in arrayList, List or any other collection API
 */
public class ArrayLists {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("List Item 1");
        list.add("List Item 2");
        list.add(34342);
        list.add("List item 4");
        list.add("List item 5");

        System.out.println("Size of the Array List is  " + list.size());
        for(int i=0; i<list.size(); i++) {
            System.out.println("List Item #" + i + " and its value is " + list.get(i));
        }


        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com");
        //Example to retrieve all links displayed in the https://the-internet.herokuapp.com
        ArrayList<WebElement> elements = (ArrayList<WebElement>) driver.findElements(By.xpath("//a"));
        System.out.println(elements.size() + " links found on the page");

        for(WebElement element: elements) {
            System.out.println(element.getText() + " liked to " + element.getAttribute("href"));
        }

        driver.quit();
    }
}
