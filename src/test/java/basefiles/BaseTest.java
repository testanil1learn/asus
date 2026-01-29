package basefiles;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import driverfactory.DriverFactory;
import utils.ConfigReader;
import utils.ExtentManager;

public class BaseTest {

	
	 protected ExtentReports extent;
	    protected ExtentTest test;

	    @BeforeSuite
	    public void setupReport() {
	        extent = ExtentManager.getExtent();
	    }

	    @AfterSuite
	    public void flushReport() {
	        extent.flush();
	    }

	@BeforeClass
	public void setUp() {
		
		DriverFactory.initDriver(ConfigReader.get("browser"));
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().manage().timeouts()
		.pageLoadTimeout(Duration.ofSeconds(10));
		DriverFactory.getDriver().get(ConfigReader.get("url"));	

	}
	

	@AfterClass
	public void tearDown() {
		
		
		DriverFactory.quitDriver();
		
	}
}
