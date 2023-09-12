@Inbound @Regression
Feature: Testing of Inbound Load Summary screen functionality

  Scenario: Checking Load Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Loads page
    Then Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present

  Scenario: Checking Load Summary screen Date filter
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Selects 453 days ago from start date on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Selects 25 days forward from start date on Inbound Load Summary page
    And Selects 125 days forward from end date on Inbound Load Summary page
    And Validates Items are displayed on Inbound Load Summary page
    And Selects 453 days ago from start date on Inbound Load Summary page
    And Selects 33 days ago from end date on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page

  Scenario: Checking Load Summary screen Load filter
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types load by index 1 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Cleans load input on Inbound Load Summary page
    Then Types load by index 3 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Cleans load input on Inbound Load Summary page
    And Types load "E4vrdv" on Inbound Load Summary page
    And Validates No Record Inbound Load Summary grid
    And Cleans load input on Inbound Load Summary page
    And Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    And Types load by index 1 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page

  Scenario: Checking Load Summary screen Status Filter
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    Then Selects load status "Ready To Receive" on Inbound Load Summary page
    And Validates Items found is displayed on Inbound Load Summary page
    And Clicks load status "Ready To Receive" on Inbound Load Summary page
    And Selects load status "Received Order" on Inbound Load Summary page
    And Validates Items found is displayed on Inbound Load Summary page

  Scenario: Checking Load Summary screen Carrier Filter
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    And Clicks carrier by index 0 on Inbound Load Summary page
    Then Selects carrier by index 3 on Inbound Load Summary page
    And Validates Items found is displayed on Inbound Load Summary page
    And Clicks carrier by index 3 on Inbound Load Summary page
    And Selects carrier by index 2 on Inbound Load Summary page
    And Validates Items found is displayed on Inbound Load Summary page

  Scenario: Checking Load Summary screen Door Filter
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    And Clicks door "Select door" dropdown on Inbound Load Summary page
    Then Clicks door "DOOR" on Inbound Load Summary page
    And Validates Items found is displayed on Inbound Load Summary page
    And Clicks door "DOOR" dropdown on Inbound Load Summary page
    And Clicks door "DR02" on Inbound Load Summary page
    And Validates Items found is displayed on Inbound Load Summary page

  Scenario: Checking Load Summary screen Load type filter
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page

    Then Clicks load type "Select load type" dropdown on Inbound Load Summary page
    And Clicks load type "Inbound" on Inbound Load Summary page

    And Validates Items found is displayed on Inbound Load Summary page

  Scenario: Checking Load Summary screen Supplier code filter
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    Then Types supplier code "0045" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page

  Scenario: Checking Load Summary screen Supplier name filter
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    Then Types supplier name "Jackson, Lincoln and Adams Atorneys at Law" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clears supplier name on Inbound Load Summary page
    And Types supplier name "DtdGe" on Inbound Load Summary page
    And Validates Items found not displayed on Inbound Load Summary page
    And Validates No Record Inbound Load Summary grid

  Scenario: Checking Load Summary screen Product filter
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    Then Types product "203433" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clears product on Inbound Load Summary page
    And Types product "208hi3" on Inbound Load Summary page
    And Validates Items found not displayed on Inbound Load Summary page
    And Validates No Record Inbound Load Summary grid

  Scenario: Checking Load Summary screen Buyer filter
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    Then Clicks buyer "Select buyer" dropdown on Inbound Load Summary page
    And Selects buyer "AFS - User" dropdown on Inbound Load Summary page
    And Validates Items found is displayed on Inbound Load Summary page
    And Clicks buyer "AFS - User" dropdown on Inbound Load Summary page
    And Selects buyer "Select buyer" dropdown on Inbound Load Summary page
    And Validates Items found is displayed on Inbound Load Summary page

  Scenario: Checking Load Summary screen Change door
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
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
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
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
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Selects Load with index 1 and apply "Edit" Load Option for Load
    And Validates Edit load popup on Inbound Load Summary page
    And Clicks Cancel button on Inbound Load Summary page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Checks Load with index 0 on Inbound Load Summary page
    And Checks Load with index 5 on Inbound Load Summary page
    And Clicks Load Option dropdown for Load
    And Validates Edit on Inbound Load Summary page is disabled

  Scenario: Checking Load Summary screen Source Load option
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Selects Load with index 0 and apply "Source" Load Option for Load
    And Validates Source load screen on Inbound Load Summary page
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
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Selects Load with index 0 and apply "Receive" Load Option for Load
    And Receiving page loads
    And Receiving page contains all web elements
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
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Open" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Checks Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Ready To Receive and Cancel Inbound statuses on Inbound Load Summary page
    And Validates popup Change stage content for Inbound Load Summary
    And Clicks No button on Inbound Load Summary page

  Scenario: Checking Status change from Ready to Receive to Finish Receiving when there is staged inventory
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Checks Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Finish Receiving status on Inbound Load Summary page
    And Validates popup Change stage title for Inbound Load Summary
    And Clicks No button on Inbound Load Summary page

  Scenario: Checking Status change from Ready to Receive to Finish Receiving when the received Qty less than the Ordered Qty
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Checks Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Finish Receiving status on Inbound Load Summary page
    And Clicks Save button on Inbound Load Summary page
    And Validates warning message title for Inbound Load Summary
    And Validates popup Quantity received is less than Order quantity inventory content for Inbound Load Summary
    And Clicks No button on Inbound Load Summary page

  Scenario: Checking Status change from Received order to ReOpen on Load Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Received Order" on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Checks Load with index 0 on Inbound Load Summary page
    And Clicks change status option on Inbound Load Summary page
    And Validates popup Change status title for Inbound Load Summary
    And Validates Change status popup with Reopen Order status on Inbound Load Summary page
    And Clicks Cancel button on Inbound Load Summary page

  Scenario: Checking Summary totals on Load Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 0 on Inbound Load Summary page
    And Types end date by index 4 on Inbound Load Summary page
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