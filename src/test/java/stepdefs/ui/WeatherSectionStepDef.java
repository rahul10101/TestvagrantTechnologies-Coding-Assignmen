package stepdefs.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import context.TestBase;
import context.UITestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.manager.driver.factory.DriverFactory;
import utils.manager.driver.factory.DriverManager;

public class WeatherSectionStepDef extends TestBase {

	UITestContext uitestContext;
	Scenario scn;

	public WeatherSectionStepDef(UITestContext uitestContext) {
		this.uitestContext = uitestContext;
	}
	
	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() throws Exception {

		DriverManager driverManager = DriverFactory.getDriverManager("chrome");
		WebDriver driver = driverManager.getDriver();
		driverManager.maximizeBrowser();
	    driverManager.navigateToDriver(serverUI);
	
		scn.write("Chrome Driver invoked and URL navigated as: " + serverUI);
		uitestContext.setDriver(driver);
		uitestContext.initializePageObjectClasses(driver, scn);
	}

	@When("I click on top name more in category section")
	public void i_click_on_top_name_more_in_category_section() {
		uitestContext.getweatherSectionPageObjects().ClickOnTop_Name_More_Sectionn();

	}

	@When("I click on weather")
	public void i_click_on_weather() {
		uitestContext.getweatherSectionPageObjects().ClickOn_Weather_Section();
	}

	@When("I enter search city {string}")
	public void i_enter_search_city(String cityName) {
		uitestContext.getweatherSectionPageObjects().SetSearchTextBox(cityName);
		uitestContext.getweatherSectionPageObjects().ClickOn_city_checkbox();
	}

	@Then("I validate {string} city is available on the map with temparature information")
	public void i_validate_corresponding_city_is_available_on_the_map_with_temparature_information(String cityName) {
		uitestContext.getweatherSectionPageObjects().ClickOn_city_Name_In_Map(cityName);

	}

	@Then("I validate select city on the map revels the weather details")
	public void i_validate_secting_any_cith_on_the_map_revels_the_weather_details() {
		uitestContext.getweatherSectionPageObjects().ClickOn_weather_details_of_selected_city();

	}
	
	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}

	@After
	public void CleanUp(Scenario s) {
		
		if (s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot)uitestContext.getDriver();
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
		}
		
		uitestContext.getDriver().quit();
		scn.write("Browser is Closed");
	}
	

}
