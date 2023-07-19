@Outbound @Regression
Feature: Testing of Outbound Summary Assign functionality

  Scenario: Checking Assign functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    When Filling start date "01/01/2017" and end date "02/22/2022" on Outbound Order Summary page
    And Verifies Assign Item is disabled on Outbound Order Summary page
    Then Selects order "CO00001442" on Outbound Order Summary page
    And Verifies Assign Item is enabled on Outbound Order Summary page
    And User selects assign item on Outbound Order Summary page
    And Verifies Assign popup is displayed on Outbound Order Summary page
    And User clicks user dropdown on Outbound Order Summary page
    And Validates users are present on Outbound Order Summary page
    And Selects random user from dropdown on Outbound Order Summary page
    And Clicks Save button on Outbound order summary page
    And Validates successful message "Success" on Outbound Order Summary page

