package basefiles;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import driverfactory.DriverFactory;
import utils.ConfigReader;

public class BaseTest {


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
