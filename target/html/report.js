$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/ui/weatherSection.feature");
formatter.feature({
  "name": "weather fuctionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ui"
    },
    {
      "name": "@weather"
    }
  ]
});
formatter.scenario({
  "name": "pin your city and validate on map with temperature information and weather details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ui"
    },
    {
      "name": "@weather"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have browser opened and url is navigated",
  "keyword": "Given "
});
formatter.match({
  "location": "WeatherSectionStepDef.i_have_browser_opened_and_url_is_navigated()"
});
formatter.write("Chrome Driver invoked and URL navigated as: https://www.ndtv.com/");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on top name more in category section",
  "keyword": "When "
});
formatter.match({
  "location": "WeatherSectionStepDef.i_click_on_top_name_more_in_category_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on weather",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherSectionStepDef.i_click_on_weather()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter search city \"pune\"",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherSectionStepDef.i_enter_search_city(String)"
});
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate \"pune\" city is available on the map with temparature information",
  "keyword": "Then "
});
formatter.match({
  "location": "WeatherSectionStepDef.i_validate_corresponding_city_is_available_on_the_map_with_temparature_information(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate select city on the map revels the weather details",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherSectionStepDef.i_validate_secting_any_cith_on_the_map_revels_the_weather_details()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Browser is Closed");
formatter.after({
  "status": "passed"
});
});