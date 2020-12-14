package pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class WeatherSectionPageObjects extends Interact {
	private static final Logger logger = LogManager.getLogger(WeatherSectionPageObjects.class);
	Scenario scn;
	private By top_name_more_section = By.xpath("//a[@id='h_sub_menu']");
	private By weathe_section_Button = By.xpath("//a[contains(text(),'WEATHER')]");
	private By Searchbox_pin_your_city = By.xpath("//input[@id='searchBox']");
	private By city_list = By.xpath("//*[@id='messages']/div");
	private By select_city_checkbox = By.xpath("//*[@id='messages']/div[67]/label");
	private By city_names_on_map = By.xpath("//div[@class='cityText']");
	private By weather_details_of_selected_city = By.xpath("//*[@id='map_canvas']/div[1]/div[4]/div[12]/div");

	public WeatherSectionPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}

	public void ClickOnTop_Name_More_Sectionn() {
		clickElement(top_name_more_section);
		logger.info("Clicked on Top Name More Section");
	}

	public void ClickOn_Weather_Section() {
		clickElement(weathe_section_Button);
		logger.info("Clicked on weather Button");
	}

	public void validate_city_Name_In_Map(String cityName) {
		if (validateElementIsDisplayed(city_names_on_map) == true)
			logger.info("city name on map is Available");
		takeScreenShotAndAttachInReport(scn);
	}

	public void ClickOn_city_checkbox() {

		selectbyElement(select_city_checkbox);
		logger.info("Clicked on city checkbox");
	}

	public void ClickOn_weather_details_of_selected_city() {
		clickElement(weather_details_of_selected_city);
		logger.info("Clicked on weather details of selected city");
		takeScreenShotAndAttachInReport(scn);
	}

	public void SetSearchTextBox(String text) {
		setElement(Searchbox_pin_your_city, text);
		logger.info("City entered in search box: " + text);
		takeScreenShotAndAttachInReport(scn);
	}

	public String ClickOncity() {
		List<WebElement> list = getListOfWebElements(city_list);
		clickElement(list.get(0));
		scn.write("Clicked on First city");
		return list.get(0).getText();
	}

	public String ClickOncity(String cityTextContains) {
		List<WebElement> list = getListOfWebElements(city_list);
		boolean flag = false;
		int counter = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains(cityTextContains)) {
				clickElement(list.get(i));
				counter = i;
				flag = true;
				break;
			}
		}

		if (flag) {
			scn.write("Clicked on city containing text as: " + cityTextContains + "");
		} else {
			scn.write("Unable to click on city containing text as: " + cityTextContains
					+ " No city found with mentioned text");
			Assert.fail("Unable to click on city containing text as: " + cityTextContains
					+ " No city found with mentioned text");
		}

		return list.get(counter).getText();

	}

}
