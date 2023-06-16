@Inbound @Regression
Feature: Testing of Inbound Load Details screen functionality

  Scenario: Checking Navigate to Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "01/01/2018" start date on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 3 on Inbound Load Summary page
    And Inbound Load Summary Details page main elements are present

  Scenario: Checking the Load details
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "01/01/2018" start date on Inbound Load Summary page
    Then Select Load with index 4 on Inbound Load Summary page
    And Inbound Load Summary Details page main elements are present

  Scenario: Checking Number of images on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "01/01/2018" start date on Inbound Load Summary page
    Then Select Load with index 4 on Inbound Load Summary page
    And Validates images are present on Inbound Load Summary page

  Scenario: Checking Number of comments on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "01/01/2020" start date on Inbound Load Summary page
    Then Select Load with index 4 on Inbound Load Summary page
    And Validates comments are present on Inbound Load Summary page

  Scenario: Checking Progress bar colors on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "01/01/2020" start date on Inbound Load Summary page
    Then Select Load with index 4 on Inbound Load Summary page
    And Validates Received, Staged, Over and Remainder are present on Inbound Load Summary page with correct color

  Scenario: Checking Summary totals on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "01/01/2020" start date on Inbound Load Summary page
    Then Select Load with index 3 on Inbound Load Summary page
    And Validates orders are present for load on Inbound Load Summary page

  Scenario: Checking Status change from Received order to ReOpen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "01/01/2018" start date on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Received Order" on Inbound Load Summary page
    And Checks Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Reopen Order status on Inbound Load Summary page
    And Clicks Cancel button on Inbound Load Summary page

  Scenario: Checking Status change from Ready to Receive to Finish Receiving
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "01/01/2018" start date on Inbound Load Summary page
    And Types "06/01/2023" end date on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Finish Receiving status on Inbound Load Summary page
    And Clicks Save button on Inbound Load Summary page
    And Validates popup Quantity received is less than Order quantity inventory content for Inbound Load Summary
    And Clicks No button on Inbound Load Summary page

  Scenario: Checking Status change from Open to Ready to Receive
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "01/01/2022" start date on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Open" on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Select Ready to Receive option on Inbound Load Summary page
    And Clicks Save button on Inbound Load Summary page
    And Validates popup Change stage title for Inbound Load Summary
    And Validates popup Change stage content for Inbound Load Summary
    And Validates Yes Button and No Button are present on load popup on Inbound Load Summary page
    And Clicks No button on Inbound Load Summary page

  Scenario: Checking Source option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "06/06/2022" start date on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Selects Load Option "Source" for Load
    And Validates Source load screen on Inbound Load Summary page
    And Validates Received, Staged and Remainder are present on Inbound Load Summary Source page with correct color

  Scenario: Checking Receive option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "06/06/2022" start date on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Selects Load Option "Receive" for Load
    And Receiving page loads
    And Receiving page contains all web elements

  Scenario: Checking Data option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    Then Inbound Load Summary page main elements are present
    When Types "06/06/2022" start date on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Clicks data option on Inbound Load Summary page
    And Validates Enter data screen on Inbound Load Summary page
    And Types "44" temperature on Inbound Load Summary page
    And Types "55" seal number on Inbound Load Summary page
    And Clicks Add Product Cancel Button on Inbound Load Summary page

  Scenario: Checking Edit option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "06/06/2022" start date on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Selects Load Option "Edit" for Load
    And Validates Edit load popup on Inbound Load Summary page
    And Types "testdriver" driver for Load
    And Clicks Save button on Inbound Load Summary page
    And Validates "Success" notification is displayed on Inbound Load Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    And Selects Load Option "Edit" for Load
    And Validates Edit load popup on Inbound Load Summary page
    And Clicks Cancel button on Inbound Load Summary page

  Scenario: Checking Door option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "06/06/2022" start date on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Clicks door option on Inbound Load Summary page
    And Validates popup Assign doors title for Inbound Load Summary
    And Clicks door on Assign doors popup on Inbound Load Summary page
    And Clicks door "DR01" on Inbound Load Summary page
    And Clicks Save button on Inbound Load Summary page
    And Validates "Success" notification is displayed on Inbound Load Summary page
    And Clicks door option on Inbound Load Summary page
    And Validates popup Assign doors title for Inbound Load Summary
    And Clicks door on Assign doors popup on Inbound Load Summary page
    And Clicks door "DOOR" on Inbound Load Summary page
    And Clicks Save button on Inbound Load Summary page
    And Validates "Success" notification is displayed on Inbound Load Summary page
    And Clicks door option on Inbound Load Summary page
    And Validates popup Assign doors title for Inbound Load Summary
    And Clicks Cancel button on Inbound Load Summary page

  Scenario: Checking Back button for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types "06/06/2022" start date on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present