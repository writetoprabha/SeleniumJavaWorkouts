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