@Google
Feature: Google

  Background: 
    Given user is on Google Homepage "https://www.google.com/"

  @GGG
  Scenario: Verify Google Homepage Title
    Then I should be able to see the page title as "Google"

  @Sanity
  Scenario: Verify Gmail Link
    When I click on Gmail link
    Then I should be able to navigate to Gmail page

  @Regression
  Scenario: Verify Search Engine
    When I click on Search box
    And Enters the keyword "Weather"
    And clicks on Enter key
    Then I should be able to navigate to corresponding results page

  @GoogleImage
  Scenario: Verify Images Link
    When I click on Images link
    Then I should be able to navigate to Google Images page
