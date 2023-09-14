@Inbound @Regression
Feature: Testing of Inbound Load Order Details screen functionality

  Scenario: Checking Navigate to Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Validates Inbound Load Order details page contains all web elements

  Scenario: Checking Summary totals on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Validates load orders Summary totals is present on Inbound Load Order Summary page

  Scenario: Checking Comments on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Validates Comments Button is present on Inbound Load Order Summary page

  Scenario: Checking Images on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Validates Images Button is present on Inbound Load Order Summary page

  Scenario: Checking Status change from Received order to ReOpen on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Received Order" on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Order Summary page
    And Validates popup Change status title for Inbound Load Order Summary page
    And Validates Change status popup with Reopen Order status on Inbound Load Order Summary page
    And Clicks Cancel button on Inbound Load Order Summary page

  @issue
  Scenario: Checking Status change from Ready to Receive to Finish Receiving on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Order Summary page
    And Validates popup Change status title for Inbound Load Order Summary page
    And Validates Change status popup with Finish Receiving Order status on Inbound Load Order Summary page
    And Clicks Save on Inbound Load Order Summary page
    And Validates popup Quantity received is less than Order quantity inventory content on Inbound Load Order Summary page
    And Clicks No button on Inbound Load Order Summary page
    And Clicks back to Inbound Load Order Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Types start date by index 2 on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Order Summary page
    And Validates popup Change status title for Inbound Load Order Summary page
    And Validates Change status popup with Finish Receiving Order status on Inbound Load Order Summary page
    And Clicks Save on Inbound Load Order Summary page
    And Validates popup Change staged inventory content on Inbound Load Order Summary page
    And Clicks No button on Inbound Load Order Summary page
    And Validates Order status "READY TO RECEIVE" is correct on Inbound Load Order Summary page

  Scenario: Checking Status change from Open to Ready to Receive on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Open" on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Order Summary page
    And Validates popup Change status title for Inbound Load Order Summary page
    And Validates Change status popup with Ready To Receive Order status on Inbound Load Order Summary page
    And Clicks Cancel button on Inbound Load Order Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Select Load Order with index 1 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Order Summary page
    And Validates popup Change status title for Inbound Load Order Summary page
    And Validates Change status popup with Ready To Receive Order status on Inbound Load Order Summary page
    And Clicks Cancel button on Inbound Load Order Summary page

  Scenario: Checking Progress bar colors on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Validates Received, Staged, Over and Remainder are present on Inbound Load Order Summary page with correct color

  Scenario: Checking Source option on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page
    And User applies order "Source" option on Inbound Load Order Summary page
    And Validates Source load screen on Inbound Load Order Summary page
    And Validates Received, Staged and Remainder are present on Inbound Load Order Summary page with correct color

  Scenario: Checking Receive option on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And User applies order "Receive" option on Inbound Load Order Summary page
    And Receiving page loads
    And Receiving page contains all web elements

  Scenario: Checking Edit option on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And User applies order "Edit" option on Inbound Load Order Summary page
    And Clicks Cancel button on Inbound Load Order Summary page

  Scenario: Checking Door option on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Clicks door option on Inbound Load Order Summary page
    And Validates popup Assign doors title for Inbound Load Order Summary page
    And Clicks door on Assign doors popup on Inbound Load Order Summary page
    And Clicks door "DR01" on Inbound Load Order Summary page
    And Clicks Save on Inbound Load Order Summary page
    And Validates "Success" notification is displayed on Inbound Load Order Summary page
    And Clicks door option on Inbound Load Order Summary page
    And Validates popup Assign doors title for Inbound Load Order Summary page
    And Clicks door on Assign doors popup on Inbound Load Order Summary page
    And Clicks door "DOOR" on Inbound Load Order Summary page
    And Clicks Save on Inbound Load Order Summary page
    And Validates "Success" notification is displayed on Inbound Load Order Summary page
    And Clicks door option on Inbound Load Order Summary page
    And Validates popup Assign doors title for Inbound Load Order Summary page
    And Clicks Cancel button on Inbound Load Order Summary page

  Scenario: Checking Order details on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Validates Inbound Load Order details page contains all web elements

  Scenario: Checking Log Details on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 2 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page
    And User applies order "Log" option on Inbound Load Order Summary page
    And Validates popup Receiver title on Inbound Load Order Details page
    And Validates popup Receiver details on Inbound Load Order Details page
    And Clicks Ok button on Inbound Load Order Summary page

  Scenario: Checking Move Order to Load on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 2 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page
    And User applies order "Move" option on Inbound Load Order Summary page
    And Validates Move popup on Inbound Load Order Details page
    And Validates Save button is disabled for Move order to Load
    And Types Ship Date by index 5 to move Order to Load on Inbound Load Order Summary page
    And Types Load by index 0 to move Order to Load on Inbound Load Order Summary page
    And Validates Save button is enabled for Move order to Load
    And Clicks Cancel button on Inbound Load Order Summary page

    #
  Scenario: Checking Add/Delete Image to the order on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page
    And Select Order Product with index 0 on Inbound Load Order Summary page
    And Clicks Order Line Image button on Inbound Load Order Line Items page
    And Validates Load Images on Inbound Load Order Details page
    And Clicks back to Inbound Load Order Summary page

  Scenario: Checking Back button on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 2 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Inbound Load Summary Details page main elements are present
    And Validates Received, Staged, Over and Remainder are present on Inbound Load Summary page with correct color

  Scenario: Checking Data Details on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 2 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page
    And Clicks data option on Inbound Load Order Summary page
    And Validates Enter data screen on Inbound Load Order Details page
    And Clicks Cancel on Order Data on Inbound Load Order Summary page
    And Clicks Route Back button on Inbound Load Summary page