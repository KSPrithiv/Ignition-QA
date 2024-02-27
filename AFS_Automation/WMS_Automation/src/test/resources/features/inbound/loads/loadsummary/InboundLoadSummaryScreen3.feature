@Inbound @Regression
Feature: Testing of Inbound Load Summary screen functionality

  Scenario: Checking Summary totals on Load Summary screen
    Given User signs in the application
    And Main page is loaded
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Open" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "Open" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "Ready To Receive" on Inbound Load Summary page
    And Selects load status "Received Order" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page