@Inbound @Regression
Feature: Testing of Inbound Load Details screen functionality

  Scenario: Checking Navigate to Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 1 on Inbound Load Summary page
    And Inbound Load Summary Details page main elements are present

  Scenario: Checking the Load details
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 0 on Inbound Load Summary page
    Then Select Load with index 1 on Inbound Load Summary page
    And Inbound Load Summary Details page main elements are present

  Scenario: Checking Number of images on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    Then Select Load with index 1 on Inbound Load Summary page
    And Validates images are present on Inbound Load Summary page

  Scenario: Checking Number of comments on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    Then Select Load with index 2 on Inbound Load Summary page
    And Validates comments are present on Inbound Load Summary page

  Scenario: Checking Progress bar colors on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    Then Select Load with index 2 on Inbound Load Summary page
    And Validates Received, Staged, Over and Remainder are present on Inbound Load Summary page with correct color

  Scenario: Checking Summary totals on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    Then Select Load with index 2 on Inbound Load Summary page
    And Validates orders are present for load on Inbound Load Summary page

  Scenario: Checking Status change from Received order to ReOpen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Received Order" on Inbound Load Summary page
    And Checks Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Reopen Order status on Inbound Load Summary page
    And Clicks Cancel button on Inbound Load Summary page

  @isofailed2
  Scenario: Checking Status change from Ready to Receive to Finish Receiving for Load
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 1 on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Finish Receiving status on Inbound Load Summary page
    And Clicks Save button on Inbound Load Summary page

  Scenario: Checking Status change from Open to Ready to Receive
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Open" on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Select Ready to Receive option on Inbound Load Summary page

  Scenario: Checking Source option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 2 on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Selects Load Option "Source" for Load
    And Validates Source load screen on Inbound Load Summary page
    And Validates Received, Staged and Remainder are present on Inbound Load Summary Source page with correct color