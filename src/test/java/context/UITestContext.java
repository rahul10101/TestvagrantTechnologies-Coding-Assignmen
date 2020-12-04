package context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageobjects.*;

public class UITestContext {

	private WebDriver driver;
	private WeatherSectionPageObjects weatherSectionPageObjects;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	
	public WeatherSectionPageObjects getweatherSectionPageObjects() {
		return weatherSectionPageObjects;
	}

	public void initializePageObjectClasses(WebDriver driver, Scenario scn) {
		weatherSectionPageObjects = new WeatherSectionPageObjects(driver, scn);

	}

	

}
