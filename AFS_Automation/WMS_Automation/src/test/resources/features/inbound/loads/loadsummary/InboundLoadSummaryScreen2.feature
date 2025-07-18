@Inbound @Regression
Feature: Testing of Inbound Load Summary screen functionality
  Scenario: Checking Load Summary screen Buyer filter
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    Then Clicks buyer by index 0 dropdown on Inbound Load Summary page
    And Selects buyer by index 2 dropdown on Inbound Load Summary page
    And Clicks buyer by index 2 dropdown on Inbound Load Summary page
    And Selects buyer by index 0 dropdown on Inbound Load Summary page
    And Validates Items found is displayed on Inbound Load Summary page

  Scenario: Checking Load Summary screen Change door
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Checks Load with index 0 on Inbound Load Summary page
    And Clicks door option on Inbound Load Summary page
    And Validates popup Assign doors title for Inbound Load Summary
    And Clicks door on Assign doors popup on Inbound Load Summary page
    And Clicks door "DOOR" on Inbound Load Summary page
    And Clicks Save button on Inbound Load Summary page
    And Validates "Success" notification is displayed on Inbound Load Summary page
    And Clicks door option on Inbound Load Summary page
    And Validates popup Assign doors title for Inbound Load Summary
    And Clicks door on Assign doors popup on Inbound Load Summary page
    And Clicks door "DR03" on Inbound Load Summary page
    And Clicks Save button on Inbound Load Summary page
    And Validates "Success" notification is displayed on Inbound Load Summary page
    And Clicks door option on Inbound Load Summary page
    And Validates popup Assign doors title for Inbound Load Summary
    And Clicks Cancel button on Inbound Load Summary page

  Scenario: Checking Load Summary screen Data option
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Checks Load with index 2 on Inbound Load Summary page
    And Clicks data option on Inbound Load Summary page
    And Validates Enter data screen on Inbound Load Summary page
    And Clicks Add Product Cancel Button on Inbound Load Summary page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Checks Load with index 3 on Inbound Load Summary page
    And Validates Data option on Inbound Load Summary page is disabled

  Scenario: Checking Load Summary screen Edit Load option
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Selects Load with index 2 and apply "Edit" Load Option for Load
    And Validates Edit load popup on Inbound Load Summary page
    And Clicks Cancel button on Inbound Load Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Checks Load with index 0 on Inbound Load Summary page
    And Checks Load with index 3 on Inbound Load Summary page
    And Clicks Load Option dropdown for Load
    And Validates Edit on Inbound Load Summary page is disabled

  Scenario: Checking Load Summary screen Source Load option
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Selects Load with index 0 and apply "Source" Load Option for Load
    And Validates Source load screen on Inbound Load Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Checks Load with index 1 on Inbound Load Summary page
    And Checks Load with index 2 on Inbound Load Summary page
    And Clicks Load Option dropdown for Load
    And Validates Source on Inbound Load Summary page is disabled

  Scenario: Checking Load Summary screen Receive Load option
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Selects Load with index 0 and apply "Receive" Load Option for Load
    And Receiving page loads
    And Receiving page contains all web elements
    And Clicks Route Back button on Inbound Load Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Checks Load with index 1 on Inbound Load Summary page
    And Checks Load with index 2 on Inbound Load Summary page
    And Clicks Load Option dropdown for Load
    And Validates Receive on Inbound Load Summary page is disabled

  Scenario: Checking Change status to Ready to Receive Load Summary screen
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Open" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Checks Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Ready To Receive and Cancel Inbound statuses on Inbound Load Summary page

  Scenario: Checking Status change from Ready to Receive to Finish Receiving when there is staged inventory
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Checks Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Finish Receiving status on Inbound Load Summary page

  Scenario: Checking Status change from Ready to Receive to Finish Receiving when the received Qty less than the Ordered Qty
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Checks Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Finish Receiving status on Inbound Load Summary page
    And Clicks Save button on Inbound Load Summary page

  Scenario: Checking Status change from Received order to ReOpen on Load Summary screen
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Received Order" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Checks Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Reopen Order status on Inbound Load Summary page
    And Clicks Cancel button on Inbound Load Summary page