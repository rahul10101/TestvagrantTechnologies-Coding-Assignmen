@ui @weather
Feature: weather fuctionality

  @tag1
  Scenario: pin your city and validate on map with temperature information and weather details
    Given I have browser opened and url is navigated
    When I click on top name more in category section
    And I click on weather
    And I enter search city "pune"
    Then I validate "pune" city is available on the map with temparature information
    And I validate select city on the map revels the weather details
