package TestSteps;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class OpenSteps{
	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("./ExtentReports/report1.html");
	public static ExtentReports extent = new ExtentReports();
	public static WebDriver driver;
	public static String Er;
	public static String Ar;
	public static Logger log = Logger.getLogger(OpenSteps.class.getName());
	
	@BeforeTest
	public static void open()
	{
		System.out.println("opening the browser");
		extent.attachReporter(reporter);
		ExtentTest logger1 = extent.createTest("opening");
		logger1.log(Status.INFO, "open browser");
		try {
			String driverPath = System.getProperty("user.dir") +"\\Driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			 driver = new ChromeDriver();
			 log.debug("opening webiste");
			 logger1.log(Status.PASS, "opening pass");
		}catch(Exception e)
		{
			logger1.log(Status.FAIL, "opening fail");
		}
		extent.flush();
	}

	@Test
	public static void navigate() throws IOException
	{
		System.out.println("navigating");
		extent.attachReporter(reporter);
		ExtentTest logger2 = extent.createTest("navigating page");
		logger2.log(Status.INFO, "navigate brwoser");
	    try {
	    	Er="Google";
	    	driver.navigate().to("https://google.com");
	    	Ar=driver.getTitle();
	    	Assert.assertTrue((Er.equals(Ar)) ?  true : false);
	    	System.out.println("Title verified");
	    	logger2.log(Status.PASS, "pass title verified");
	    	logger2.addScreenCaptureFromPath("D:\\Desktop\\download.png");

	    	
	    }catch(AssertionError ae)
	    {
	    	logger2.log(Status.FAIL, "title verfication fail");
	    }
	    extent.flush();
	}
	@AfterTest
	public static void Close()
	{
		System.out.println("closing  the browser");
		extent.attachReporter(reporter);
		ExtentTest logger3 = extent.createTest("closing");
		logger3.log(Status.INFO, "close browser");
	    try {
	    	driver.close();
	    	logger3.log(Status.PASS, "closing pass");
	    	
	    }catch(Exception e)
	    {
	    	logger3.log(Status.FAIL, "closing fail");	
	    }
	    extent.flush();
	}

}
