Topics covered so far: <br>
<list>
<li>Array list</li>
<li>Hash tables</li>
<li>Hash maps</li>
<li>Reflection API</li>
  
Commit for the above topics: https://github.com/writetoprabha/SeleniumJavaWorkouts/commit/e3fda49d5f1af777a1c3ba9925835c10c55362b2

<h3>Different waits supported in Selenium</h3>
<h4>Implicit Wait:</h4>
* it is the default timeout for all the driver.findElement statements.
* If the element is not located within the given timeout SLA, NoSuchElementFound exception will be thrown
* driver.manage.timeouts().implicitlyWait(20, TimeUnit.SECONDS); <br>
* driver.manage.timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); => to make selenium wait for 20 seconds for page load <br>
* driver.manage.timeouts().setScriptTimeout(20, Timeunit.SECONDS); => to make selenium wait for ajax scripts to execute
<h4>Explicity Wait</h4>
* To make selenium wait for an element
* Sample Code: <br>
WebDriverWait wait = new WebDriverWait(driver, 10);  => takes the driver and timeout in seconds as input<br>
wait.until(ExpectedConditions.visibilityOf(driver.findElementBy.Id("xyz")));
* dynamic in nature => Waits only until the visibility of the element
<h4>Thread.sleep()<h4>
* Static wait
* Should not be used frequently
<h4>HashSets to fetch different windows opened</h4>
<h3> Alerts, Frames and Mouse Actions:
* Alerts
    * When native java script alerts are displayed, we need to make the driver point to the alert window in order to perform operations/verify text displayed in the alert
    * To do so, we can use driver.switchTo().Alert() function => returns Alert object
* Frames
    * Frames are html pages within an another HTML page
    * In order to perform operations on frames, we need to point our driver to the frame. 
    * Can be done using driver.switchTo().frame(\<frameIndex\>); statement
    * Can get the number of frames present in the web page using: driver.findElements(By.tagName("frame")).size();
* MouseActions
    * Sometimes we will come across draggable objects in our web applications
    * Mouse actions can be done on such objects
    * Statement for mouse actions: Actions action = new Actions(driver);
    * action.dragAndDrop(\<srcWebElement>, \<destWebElement>).build().perform();
*