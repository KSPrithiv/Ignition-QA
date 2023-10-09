@Outbound @Regression
Feature: Testing of Outbound Route Summary Assign option
  Scenario: Checking Assign Route functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date by index 4 on Outbound Route Summary page
    And Validates assign item is not active on Outbound Route Summary page
    Then Selects route with index 0 on Outbound Route Summary page
    And Validates assign item is active on Outbound Route Summary page
    And User selects assign item on Outbound Route Summary page
    And Verifies Assign window is displayed on Outbound Route Summary page
    And User clicks user dropdown for Assign Route on Outbound Route Summary page
    And Validates users are present for Assign Route on Outbound Route Summary page
    And Selects random user from dropdown for Assign route on Outbound Route Summary page
    And Clicks Save button on Outbound Route Summary page
    And Validates "Success" notification is displayed on Outbound Route Summary page