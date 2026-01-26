package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	private By username = By.id("username");
	private By password = By.id("password");
	private By loginBtn = By.id("submit");
	
	 public LoginPage() {
		 this.driver = DriverFactory.getDriver();
	    }

		public void login(String user, String pass) {
	        driver.findElement(username).sendKeys(user);
	        driver.findElement(password).sendKeys(pass);
	        driver.findElement(loginBtn).click();
	    }

}
