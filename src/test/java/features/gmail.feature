## Notes ##
# In order to comment use '#'
# We cannot comment between 'tag' and 'scenario'
# We can comment between the steps; can comment top of the tag
# In oder to do a block comment, select the bunch of codes and in keyboard press Ctrl and '/' (forward slash)

#Scenarios written for Gmail webpage+
@Gmail
Feature: Gmail

  Background: 
    Given user is on Gmail "https://www.gmail.com/"

  #Verify Gmail page Title
  @Sanity
  Scenario: Verify Gmail page Title
    Then the page title should be "Gmail"

  #Verify Gmail Create Account
  @Regression
  Scenario: Verify Gmail Create Account
    Given I click on Create Account
    When I click on For my personal use
    Then I should see the page title as "Create your Google Account"

  #Verify gmail sign up with valid data
  @SmokeTest
  Scenario Outline: Verify gmail sign up with valid data
    Given clicks on account creation button
    Given clicks on For my personal use option
    When user enters <Firstname> <Lastname> <Username> <Password> and <Confirm>
    When clicks on button: Next
    Then I should be navigated to page: Verify your phone number

    Examples: 
      | Firstname | Lastname | Username  | Password    | Confirm     |
      | Robert    | Bob      | rb583627  | robertBob22 | robertBob22 |
      | Jane      | Doe      | doej60696 | janeDoe22   | janeDoe22   |