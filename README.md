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
  
<code>
driver.manage.timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.manage.timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); //=> to make selenium wait for 20 seconds for page load <br>
driver.manage.timeouts().setScriptTimeout(20, Timeunit.SECONDS); //=> to make selenium wait for ajax scripts to execute
</code>

<h4>Explicitly Wait</h4>
<li>To make selenium wait for an element
<li>Sample Code:</li>
<code>
WebDriverWait wait = new WebDriverWait(driver, 10);  => takes the driver and timeout in seconds as input<br>
wait.until(ExpectedConditions.visibilityOf(driver.findElementBy.Id("xyz")));
</code>
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
<code>
        int x = driver.findElement(By.xpath("//a[contains(text(), 'A/B Testing')]")).getLocation().x;
        int y = driver.findElement(By.xpath("//a[contains(text(), 'A/B Testing')]")).getLocation().y;
</code>

<h3>Database validations </h3>
Commit: https://github.com/writetoprabha/SeleniumJavaWorkouts/commit/164719c218181d95b1c10a8e49dcaf7467052579
<h4>4 step process: </h4>
<li> Step 1: Associate the Connector jar file for the database (mySql jar is associated here) and load the driver using the Class.forName method <br>
Statement: <br>Class.forName("com.mysql.cj.jdbc.Driver");<br><br>
<li> Step 2: Create the connection object using Driver.getConnection method (will return connection object)<br>
Statement: <br>Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seleniumpractice", "root", "Colb@121"); <br><br>
<li> Step 3: Create the statement object and pass the query in statementObj.executeQuery method => Returns result set<br>
Statement smt = con.createStatement(); //Returns statement to execute query
ResultSet rs = smt.executeQuery("select FIRSTNAME from employeeInfo");<br><br>
<li> Step 4: Retrieve the results from the result set <br>
<code>
        while(rs.next()) {  <br>
            System.out.println(rs.getString("FIRSTNAME")); <br>
        } <br>
</code>

<h3> API Validations</h3>
Commit: https://github.com/writetoprabha/APIAutomation/commit/a5dd04bb51242f8a85c7743fdb1800950faf218b
<h4> To invoke a REST service with Java:</h4>
<ol>
<li>Set the baseURI property of the RESTASSURED static class<br> Example: <br/>RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";</li>  
<li>Create the RequestSpecification object and assign it with RestAssured.Given() method. <br>Example:<br/> RequestSpecification httpRequest = ResetAssured.Given();</li>
<li>Create the Response object and assign it with requestSpecificationObject.request() method <br/>Example: <br/> Response response = httpRequest.Request(METHOD.GET, "/Hyderabad"); <br>Note: "/Hyderabad" is the parameter passed in GET request </li>
<li>The Response of the request invoked can be accessed using the response object <br> Example: <br> System.out.println(response.getResponseBody()); </li>
</ol>

Notes:
<li>For POST requests, we need to add the payload and header as below: <br>
<code>
        JSONObject requestPayload = new JSONObject(); <br/>
        requestPayload.put("FirstName", firstName); <br/>
        requestPayload.put("LastName", lastName); <br/>
        requestPayload.put("UserName", userName); <br/>
        requestPayload.put("Password", password); <br/>
        requestPayload.put("Email", emailId); <br/> <br/>
        httpRequest.header("Content-Type", "application/json"); <br/>
        httpRequest.body(requestPayload.toJSONString()); <br/>
</code>
</li> 

<h4> API Testing using Rest Assured BDD Approach </h4>

<li>Need to include the below static packages to perform simple REST API validations with BDD approach</li>

<code>

import io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

</code>

<li>Both POST and GET methods can be invoked and validated</li>
<li>Supports both XML and JSON responses</li>
<li>Xpath can be used to verify XML responses</li>

<H3>Mobile Automation using Appium:</h3>
<li> Appium supports both Android and iOS automation</li>
<li>Works well for Native, Hybrid and mobile web browsers</li>
<li>Comes from selenium family</li>

<h4>Softwares needed:</h4>
<li>Android Studio for android mobile emulator</li>
<li>XCode for iOS mobile emulator</li>
<li>Appium Server</li>
<li>Appium Client</li>
<li>UI Automation Viewer - to identify elements in the mobile app</li>

<h5>Android Studio</h5>
<li>Android studio is required for creating mobile emulators</li>
<li>Need to set ANDROID_HOME environment variable</li>
<li>The UI Automation Viewer comes along with Android studio and is located under the below path</li>
~/Android/Sdk/emulator/bin
<h5>Appium Server</h5>
<li>Appium Server listens to Appium client for commands to perform on the mobile application under test</li>
<li>Appium Server is present in npm package and can be globally installed using the below command</li>
npm install -g appium
<li>Appium Server can be started by running the command appium in terminal</li>
<li>Appium runs on the 127.0.0.1:4723/wd/hub location</li>
<h5>Appium Client</h5>
<li>Appium clients are available for all the languages supported by selenium</li>
<li>Dependency for Appium Java client can be used to work on Java language</li>


<h5>When creating the driver  for mobile automation, we need to tell the below information</h5>
<li>Operating system in which the automation needs to be carried out</li>
<li>Emulator name (DEVICE_NAME) in which the automation needs to be performed</li>
<li>Application (APP) which needs to be launched on the mobile for automation</li>
<li>All these can be done using DesiredCapabilities object in Java as follows</li>

<code>
        
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //To tell Appium server whether to perform the automation on Android or iOS device, specify the framework name:
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        //Name of the emulator in android studio
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_XL_API_28");

        //To tell Appium server which app to open:
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");


        //Driver object creation to perform the automation. Takes 2 arguments -
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
</code>

<li>Identification of elements displayed on the app are done using UI Automation Viewer tool</li>

<code>
        
        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
        driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/edit']")).sendKeys("Some text goes here");
        driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click()
</code>
  
<h4>Touch Action</h4>
<li>Appium supports performing gestures on the app - like long press, swipe, scroll, tap etc., </li>
<li>TouchAction class's longPress method can be used to perform long press and drag operations </li>

<code>

        TouchAction touch = new TouchAction(driver);

        touch.longPress(LongPressOptions.longPressOptions().withElement(element(source)).withDuration(Duration.ofSeconds(2))).moveTo(element(destination)).release().perform();

</code>

<li>The longPress statement can also be written like below</li> 

<code>
touch.longPress(element(source)).moveTo(element(destination)).release().perform();
</code>  

<li>Using UIAndroidAutomator's UiScrollable method, we can scroll to a particular element on the screen</li>

<code>
driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Visibility\"));");

driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Date Widgets\"));");
</code>
