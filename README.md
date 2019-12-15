Topics covered so far: <br>
<list>
<li>Array list</li>
<li>Hash tables</li>
<li>Hash maps</li>
<li>Reflection API</li>
  
Commit for the above topics: https://github.com/writetoprabha/SeleniumJavaWorkouts/commit/e3fda49d5f1af777a1c3ba9925835c10c55362b2

<h3>Different waits supported in Selenium</h3>
<h4>Implicit Wait:</h4>
<li>it is the default timeout for all the driver.findElement statements.
<li>If the element is not located within the given timeout SLA, NoSuchElementFound exception will be thrown
<li>driver.manage.timeouts().implicitlyWait(20, TimeUnit.SECONDS); <br>
<li>driver.manage.timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); => to make selenium wait for 20 seconds for page load <br>
<li>driver.manage.timeouts().setScriptTimeout(20, Timeunit.SECONDS); => to make selenium wait for ajax scripts to execute
<h4>Explicity Wait</h4>
<li>To make selenium wait for an element
<li>Sample Code: <br>
WebDriverWait wait = new WebDriverWait(driver, 10);  => takes the driver and timeout in seconds as input<br>
wait.until(ExpectedConditions.visibilityOf(driver.findElementBy.Id("xyz")));
<li>dynamic in nature => Waits only until the visibility of the element
<h4>Thread.sleep()</h4>
<li>Static wait
<li>Should not be used frequently
<h4>HashSets to fetch different windows opened</h4>
<h3> Alerts, Frames and Mouse Actions:
<h4>Alerts</h4>
<li> When native java script alerts are displayed, we need to make the driver point to the alert window in order to perform operations/verify text displayed in the alert
<li>To do so, we can use driver.switchTo().Alert() function => returns Alert object
<h4>Frames</h4>
<li>Frames are html pages within an another HTML page
<li>In order to perform operations on frames, we need to point our driver to the frame. 
<li> Can be done using driver.switchTo().frame(frameIndex); statement
<li> Can get the number of frames present in the web page using: driver.findElements(By.tagName("frame")).size();
<h4>MouseActions</h4>
<li>Sometimes we will come across draggable objects in our web applications
<li>Mouse actions can be done on such objects
<li>Statement for mouse actions: Actions action = new Actions(driver);
<li>action.dragAndDrop(srcWebElement, destWebElement).build().perform();
<h3>Cookies verification</h3>
<li>At times we get test cases to verify that a specific cookie is present after performing an action in the application.
<li>In such cases, we can use the getCookies method of driver.manage() to iterate through the cookies and verify
<h4>To verify that a certain cookie is present:</h4>
<li>First we need to get all the cookies and assign it to a Set of type Cookie
<li>Create an Iterator object on the Set object using Iterator iteratorName = setObject.iterator(); method
<li>while iterator object has next element, iterate and find the cookie
<h3>Getting the co-ordinates of an element</h3>
        <li>int x = driver.findElement(By.xpath("//a[contains(text(), 'A/B Testing')]")).getLocation().x;
        <li>int y = driver.findElement(By.xpath("//a[contains(text(), 'A/B Testing')]")).getLocation().y;
<h3>Database validations </h4>
<h4>4 step process:
<li> Step 1: Associate the Connector jar file for the database (mySql jar is associated here) and load the driver using the Class.forName method <br>
Statement: <br>Class.forName("com.mysql.cj.jdbc.Driver");<br><br>
<li> Step 2: Create the connection object using Driver.getConnection method (will return connection object)<br>
Statement: <br>Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seleniumpractice", "root", "Colb@121"); <br><br>
<li> Step 3: Create the statement object and pass the query in statementObj.executeQuery method => Returns result set<br>
Statement smt = con.createStatement(); //Returns statement to execute query
ResultSet rs = smt.executeQuery("select FIRSTNAME from employeeInfo");<br><br>
<li> Step 4: Retrieve the results from the result set <br>
        while(rs.next()) {  <br>
            System.out.println(rs.getString("FIRSTNAME")); <br>
        } <br>
