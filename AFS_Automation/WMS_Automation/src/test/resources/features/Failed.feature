@Appointments @Regression
Feature: Testing of Failed
  Scenario: Checking Route Data functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    And Filling route start date by index 2 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Validates Items Counts displayed on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are disabled on Outbound Route Summary page
    When Selects route with index 0 on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    Then Select Outbound Route Data option on Outbound Route Summary page
    And Validates Route Data page is displayed on Outbound Route Summary page
    And Validates Route Data page title contains "Route" on Outbound Route Summary page
    And Click Cancel button on Outbound Route Summary page

  Scenario: Checking Route Source functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Validates Items Counts displayed on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    Then Selects route with index 0 on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are enabled on Outbound Route Summary page
    And Select Outbound Route Source option on Outbound Route Summary page
    And Validates Source page columns for Route on Outbound Route Summary page
    And Validates Source page screens for Route on Outbound Route Summary page
    And Validates Shipper on Source page for Route is displayed on Outbound Route Summary page
    And Validates green color for Shipped, yellow for Allocated, orange for Unallocated on Outbound Route Summary page
    And Clicks on "Shipper" column with index 0 on Outbound Route Summary page
    And Validates Shipped, Audit, Picked, Unallocated, Shorts, Waiting inbound and Remainder status displayed on Outbound Route Summary page

  Scenario: Checking Route Edit/Move task functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    And Filling route start date by index 2 on Outbound Route Summary page
    And Selects route with index 0 on Outbound Route Summary page
    And Validates work item is active on Outbound Route Summary page
    When User selects work item on Outbound Route Summary page
    And Validates Assignments tab and Tasks tab are displayed on Outbound Route Summary page
    And Validates Assignments tab is active by default on Outbound Route Summary page
    And Validates Assignment Type filter is displayed on Outbound Route Summary page
    Then Selects Tasks Tab on Outbound Route Summary page
    And Validates Types Tab is displayed on Outbound Route Summary page
    And Validates Tasks options Edit, Delete, Move and Reprocess are disabled on Outbound Route Summary page
    And Validates Tasks option Top Off is enabled on Outbound Route Summary page
    And Selects route with index 0 on Outbound Route Summary page
    And Selects route with index 1 on Outbound Route Summary page
    And Selects Tasks Tab on Outbound Route Summary page
    And Selects Task checkbox by index 0 on Outbound Route Summary page
    And Validates Route Title is displayed on Outbound Route Summary page
    And Validates Tasks options Edit, Delete, Move and Reprocess are enabled on Outbound Route Summary page
    And Selects Move option for Task on Outbound Route Summary page
    And Validates Move task window on Outbound Route Summary page
    And New assignment, Existing assignment, New shipper and Existing shippers are displayed on Outbound Route Summary page
    And Validates To New or Existing Shippers disabled on Outbound Route Summary page
    And Validates Save and Cancel buttons are displayed on Outbound Route Summary page
    And Click Cancel button on Outbound Route Summary page

  Scenario: Checking Route Review functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Validates Items Counts displayed on Outbound Route Summary page
    Then Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are disabled on Outbound Route Summary page
    And Selects route with index 0 on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are enabled on Outbound Route Summary page
    And Select Outbound Route Review option on Outbound Route Summary page
    And Validates Route Review page labels are displayed on Outbound Route Summary page

  Scenario: Checking Route Door option functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Validates Items Counts displayed on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are disabled on Outbound Route Summary page
    And Selects route with index 0 on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are enabled on Outbound Route Summary page
    Then Select Outbound Route Door option on Outbound Route Summary page
    And Validates popup Assign door title for Route on Outbound Route Summary page
    And Validates Door dropdown is not empty by default on Outbound Route Summary page
    And User clicks door dropdown for Route on Outbound Route Summary page
    And Validates Doors are present in dropdown on Outbound Route Summary page
    And User clicks door "DR03" on Outbound Route Summary page
    And Clicks Save button on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are enabled on Outbound Route Summary page
    And Select Outbound Route Door option on Outbound Route Summary page
    And Validates Save and Cancel buttons are displayed on Outbound Route Summary page
    And User selects default option "Select door" on Outbound Route Summary page
    And Clicks Save button on Outbound Route Summary page

  Scenario: Checking route option Edit when click on the Route
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Validates Items Counts displayed on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are disabled on Outbound Route Summary page
    Then Selects route with index 1 on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Select Outbound Route Edit option on Outbound Route Summary page
    And Validates Save and Cancel buttons are displayed on Outbound Route Summary page
    And Validates Edit Route code field and window title on Outbound Route Summary page
    And Typing Outbound Route code "Testing123" on Outbound Route Summary page
    And Select Outbound Route type by index 2 on Outbound Route Summary page
    And Filling scheduled date "01012020" and scheduled time "11:11" on Outbound Route Summary page
    And Clicks Carrier dropdown on Outbound Route Summary page
    And Select Outbound Route carrier by index 2 option on Outbound Route Summary page
    And Type Route driver "testdriver" on Outbound Route Summary page
    And Validates Trailer is displayed on Outbound Route Summary page
    And Clicks Trailer dropdown on Outbound Route Summary page
    And Select Trailer option by index 0 on Outbound Route Summary page
    And Validates Max Stops is displayed on Outbound Route Summary page
    And Type Max Stops by index 0 on Outbound Route Summary page
    And Validates Temperature type by index 1 is displayed on Outbound Route Summary page
    And Type Temperature by index 1 on Outbound Route Summary page
    And Clicks Save button on Outbound Route Summary page

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

  Scenario: Checking Data option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 2 on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Clicks data option on Inbound Load Summary page
    And Types temperature by index 0 on Inbound Load Summary page
    And Types seal number by index 0 on Inbound Load Summary page
    And Clicks Add Product Cancel Button on Inbound Load Summary page

  Scenario: Checking Door option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
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
    When Types start date by index 4 on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present

  Scenario: Check Searching on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds orders from date by index 4 on Inbound Order summary page
    And Types Valid product code by index 1 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    Then Deletes product on Inbound Order Summary page
    And Types invalid product code "Ht5frK" on Inbound Order Summary page

  @setupfailed
  Scenario: Checking UI verification of encoding tab on Setup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Setup Product page
    And Validates Setup Product page is displayed
    And Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    And Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Clicks Extract date as dropdown on Setup Product page
    And Validates Extract date as options on Setup Product page
    And Clicks Extract date as dropdown on Setup Product page
    And Validates Extract Date As Text "(None)" on Date encoding popup on Setup Product page
    And Validates Day Mapping Text "(None)" on Date encoding popup on Setup Product page
    And Validates Month Mapping Text "(None)" on Date encoding popup on Setup Product page
    And Validates Year Mapping Text "(None)" on Date encoding popup on Setup Product page
    And Validates Week Mapping Text "(None)" on Date encoding popup on Setup Product page
    And Clicks Day Mapping dropdown on Setup Product page
    And Validates Day Mapping options on Setup Product page
    And Clicks Month Mapping dropdown on Setup Product page
    And Validates Month Mapping options on Setup Product page

  @setupfailed
  Scenario: Checking creation with mandatory values on Date encoding popup on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    And Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    When Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Selects Day Mapping "(None)" on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    Then Selects Extract date as "Production date" on Setup Product page
    And Enter Input Code "CODEE 5" on Date encoding popup on Setup Product page
    And Enter Input Desc "desc 11" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask 11" on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Clicks Product Label on Setup Product page
    And Clicks Add new on Setup Product page
    And Clicks Suppliers Tab on Setup Product page
    And Clicks Add on Setup Product page
    And User clicks Date encoding dropdown on Setup Product page
    And Validates "CODEE 5" option on Setup Product page
    And User clicks Date encoding dropdown on Setup Product page
    And Clicks Cancel on Setup Product page
    And Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    And Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    And Selects Extract date as "Production date" on Setup Product page
    And Enter Input Code "CODEE 5" on Date encoding popup on Setup Product page
    And Enter Input Desc "desc 11" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask 11" on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Validates warning message "\"CODEE 5 \" is a duplicate code" on Date encoding popup on Setup Product page
    And Clicks Cancel on Setup Product page
    And Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Selects Day Mapping "(None)" on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    And Selects Extract date as "Production date" on Setup Product page
    And Enter Input Code "CODE 55" on Date encoding popup on Setup Product page
    And Enter Input Desc "desc 11" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask 11" on Date encoding popup on Setup Product page
    And Clicks Cancel on popup on Setup Product page
    And Selects row by code "CODEE 5" on Setup Product page
    And User clicks Delete Settings button on Setup Product page
    And Clicks OK Button on Setup Product page

  @setupfailed
  Scenario: Checking Editing date encoding on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Validates Setup Product page is displayed
    And Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    When Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Selects Day Mapping "(None)" on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    Then Selects Extract date as "Production date" on Setup Product page
    And Enter Input Code "CODE10" on Date encoding popup on Setup Product page
    And Enter Input Desc "desc 11" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask 11" on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Selects row by code "CODE10" on Setup Product page
    And User clicks Edit Settings button on Setup Product page
    And Enter Input Desc "desc 12" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask 12" on Date encoding popup on Setup Product page
    And Selects Extract date as "Expiration date" on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Selects row by code "CODE10" on Setup Product page
    And User clicks Delete Settings button on Setup Product page
    And Clicks OK Button on Setup Product page

  @setupfailed
  Scenario: Checking UI verification of UOM on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    When Clicks Add new on Setup Product page
    And Validates Setup Product page is displayed
    And Clicks Warehouse Tab on Setup Product page
    Then Clicks UOM Tab on Setup Product page
    And Validates UOM tab details on Setup Product page
    And Validates Add, Edit, Delete buttons are displayed on Setup Product page
    And Validates Add is enabled and Edit, Delete are disabled on Setup Product page
    And Validates Items Count and Items Found on Setup Product page
    And Validates UOM grid should display all column names on Setup Product page

  Scenario: Checking navigation functionality of Lookup Dock Management screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup DockManagement page
    And Waits for Dock Management Lookup page to load
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    When User types date from input by index 1 on Dock Management page
    And User clicks item 1 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page
    And User clicks Dock Mgmt Summary row 1 on Dock Management page
    And Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User clicks not empty Trailer by index 0 on Dock Management Summary page
    Then Validates "Change trailer" popup is displayed on DockManagement Lookup page
    And User clicks Cancel on Dock Management Summary page
    And User clicks not empty Scheduled by index 0 on Dock Management Summary page
    And Validates Scheduled time popup is displayed on DockManagement Lookup page
    And User clicks Cancel on Dock Management Summary page
    And Validates Receiving, Shipping, Production are disabled on DockManagement Lookup page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And Validates Color Indication labels are correct on DockManagement Lookup page
    And User clicks item 2 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page
    And User clicks Dock Mgmt Summary row 2 on Dock Management page
    And Go to Lookup DockManagement page
    And Waits for Dock Management Lookup page to load
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User clicks not empty Scheduled by index 2 on Dock Management Summary page
    And Validates Scheduled time popup is displayed on DockManagement Lookup page
    And User clicks Cancel on Dock Management Summary page

  Scenario: Checking Route/Load/Order of Lookup Dock Management screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    When User types date from input by index 1 on Dock Management page
    Then User types date to input by index 3 on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page
    And User clicks item 1 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page
    And User clicks Dock Mgmt Summary row 1 on Dock Management page
    And Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User clicks item 1 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page

  Scenario: Checking Trailer Change of Lookup Dock Management screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    When User types date from input by index 1 on Dock Management page
    Then User types date to input by index 3 on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page
    And User clicks not empty Trailer by index 0 on Dock Management Summary page
    And Validates "Change trailer" popup is displayed on DockManagement Lookup page
    And User selects trailer by index 0 on Dock Management Summary page
    And User clicks OK on Dock Management Summary page

  Scenario: Checking navigation functionality of Lookup Dock Management screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup DockManagement page
    And Waits for Dock Management Lookup page to load
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    When User types date from input by index 1 on Dock Management page
    And User clicks not empty Trailer by index 0 on Dock Management Summary page
    Then Validates "Change trailer" popup is displayed on DockManagement Lookup page
    And User clicks Cancel on Dock Management Summary page
    And User clicks not empty Scheduled by index 0 on Dock Management Summary page
    And Validates Scheduled time popup is displayed on DockManagement Lookup page
    And User clicks Cancel on Dock Management Summary page
    And Validates Receiving, Shipping, Production are disabled on DockManagement Lookup page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And Validates Color Indication labels are correct on DockManagement Lookup page
    And User clicks item 2 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page
    And User clicks Dock Mgmt Summary row 2 on Dock Management page
    And Go to Lookup DockManagement page
    And Waits for Dock Management Lookup page to load
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User clicks not empty Scheduled by index 2 on Dock Management Summary page
    And Validates Scheduled time popup is displayed on DockManagement Lookup page
    And User clicks Cancel on Dock Management Summary page

  Scenario: Checking Navigate to Inbound/Outbound from DockManagement of Lookup Dock Management screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    When User types date from input by index 1 on Dock Management page
    Then User types date to input by index 3 on Dock Management page
    And User clicks item 0 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page
    And User clicks Dock Mgmt Summary row 0 on Dock Management page
    And Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page dates are displayed on DockManagement Lookup page

  Scenario: Checking Data In Lookup Dock Management screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    When User types date from input by index 1 on Dock Management page
    Then User types date to input by index 3 on Dock Management page
    And Validates DockManagement Lookup Page dates are displayed on DockManagement Lookup page
    And Validates Receiving, Shipping, Production are disabled on DockManagement Lookup page
    And Validates Color Indication labels are correct on DockManagement Lookup page

  Scenario: Checking Navigate to DockManagement Summary of Lookup Dock Management screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    When User types date from input by index 1 on Dock Management page
    Then User types date to input by index 3 on Dock Management page
    And User clicks item 0 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page

  Scenario: Checking Appointment Scheduler Creation With Valid Order functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Appointment scheduler page
    And Waiting Appointment Scheduler Page To Load
    And Appointment Scheduler page is displayed
    And User searches for valid order "R" for appointment on Appointment Scheduler page
    And Validates Order Data on Appointment Scheduler page
    And User selects order by row number 0 on Appointment Scheduler page
    And Click Next on Appointment Scheduler page
    And Validates Delivery Type and Email on Appointment Scheduler Delivery page are displayed
    And Click Next on Appointment Scheduler page
    And Validates Submit button is active on Appointment Scheduler page
    And Validates Scheduler date and Scheduler time on Appointment Scheduler page

  Scenario: Enter not valid username and password, get error message
    Given User signs in the application with wrong credentials
    When Login page is displayed
    Then Wrong credentials notification error "Either Username or Password is incorrect. Please try again." is displayed

  Scenario: Check every screen should have warehouse at top
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates warehouse dropdown is displayed on Inbound Load Summary page
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And Validates warehouse dropdown is displayed on Inbound Load Summary page
    And Go to Counting Count page
    And Waits for Counting Count page to load
    And Validates warehouse dropdown is displayed on Inbound Load Summary page
    Then Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates warehouse dropdown is displayed on Inbound Load Summary page
    And Go to Work Queue Assign Work page
    And Waits for Work Queue Work Assign page to load
    And Validates warehouse dropdown is displayed on Inbound Load Summary page
    And Go to Lookup Label page
    And Waits for Label Lookup page to load
    And Validates warehouse dropdown is displayed on Inbound Load Summary page

  Scenario: Checking Dashboard Icon and Spelling
    Given User signs in the application
    And Main page is loaded
    When DockManagement Summary Page is validated
    Then Validates Dashboard Icons and Spelling on Dashboard page

  Scenario: Checking Dashboard menu item
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    When User clicks user profile icon on Dashboard page
    Then Clicks user profile logout icon on Dashboard page
    And Waits until Login page is visible

  Scenario: Checking Visibility Of Dashboard
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And User clicks user profile icon on Dashboard page
    And Clicks user profile logout icon on Dashboard page
    And Waits until Login page is visible
    And Admin user signs in the application
    And Main page is loaded
    When Go to Security Permissions page
    And Unselects allow user access to Dashboard checkbox on Security Permissions page
    And User clicks user profile icon on Dashboard page
    Then Clicks user profile logout icon on Dashboard page
    And Waits until Login page is visible
    And User signs in the application
    And Main page is loaded
    And User clicks user profile icon on Dashboard page
    And Clicks user profile logout icon on Dashboard page
    And Waits until Login page is visible
    And Admin user signs in the application
    And Main page is loaded
    And Go to Security Permissions page
    And Selects allow user access to Dashboard checkbox on Security Permissions page
    And User clicks user profile icon on Dashboard page
    And Clicks user profile logout icon on Dashboard page
    And Waits until Login page is visible

  Scenario: Checking Transactions -> Tasks by Type widget
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Work Queue Task page
    And Waits for Work Queue Task page to load
    And Validates Work Queue Task page is displayed
    And Validates Search Field in right top corner of the grid is displayed on Work Queue Task page
    Then Go to Dashboard page
    And Hover over Cycle Count graph bar on DockManagement page
    And Validates number of Tasks popup is displayed on Dashboard page

  Scenario: Checking Transactions -> Assignments by Group widgets
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User clicks session dropdown on Counting Sessions page
    When User selects session with index 2 on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Assignments tab on Counting Sessions page
    And Validates Assignment tab contains Release and Delete buttons, Add filter button on Counting Sessions page
    Then Go to Work Queue Assign Work page
    And Waits for Work Queue Work Assign page to load
    And Validates Assign work screen is displayed on Work Queue Work Assign Page
    And Go to Dashboard page
    And Validates Dashboard Icons and Spelling on Dashboard page

  Scenario: Checking Transactions -> Picking Status widget
    Given User signs in the application
    And Main page is loaded
    When DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    Then Validates Picking Status graph is displayed on Dashboard page

  Scenario: Checking Transactions -> Late Outbound widget
    Given User signs in the application
    And Main page is loaded
    When DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    Then Validates Late Outbound graph is displayed on Dashboard page

  Scenario: Checking Transactions -> Late Inbound widget
    Given User signs in the application
    And Main page is loaded
    When DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    Then Validates Late Inbound graph is displayed on Dashboard page

  Scenario: Checking Transactions -> Inbound Loads widget
    Given User signs in the application
    And Main page is loaded
    When DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    Then Validates Inbound Loads graph is displayed on Dashboard page

  Scenario: Checking Transactions -> Outbound Routes widget
    Given User signs in the application
    And Main page is loaded
    When DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    Then Validates Outbound Routes graph is displayed on Dashboard page

  Scenario: Checking Transactions -> Inbound Orders widget
    Given User signs in the application
    And Main page is loaded
    When DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    Then Validates Inbound Orders graph is displayed on Dashboard page

  Scenario: Verify that Labor widget is divided into two Parts
    Given User signs in the application
    And Main page is loaded
    When DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Active Operators graph is displayed on Dashboard page
    Then Validates Operators by Group graph is displayed on Dashboard page

  Scenario: Verify Labor Active Operators
    Given User signs in the application
    And Main page is loaded
    When DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Active Operators graph is displayed on Dashboard page
    Then Validates Active Operators Time Groups is displayed on Dashboard page

  Scenario: Verify the Labor widgets is visible to the logged in user
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Clicks On Break graph bar on DockManagement page
    And Waits for Work Queue Logged In Users page to load
    And Validates User Logged In title is displayed on Work Queue Logged In Users page
    And Validates table columns are displayed on Work Queue Logged In Users page

#    #
#  Scenario: Verify that Assignment logged in user display
#    Given User signs in the application
#    When Main page is loaded
#    Then DockManagement Summary Page is validated
#    And Validates Dashboard Icons and Spelling on Dashboard page
#    And Clicks Pal Dry graph bar on DockManagement page
#    And Waits for Work Queue Assignments page to load
#    And Work Queue Assignments Page is validated

  Scenario: Verify Operators by Group
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Operators by Group graph is displayed on Dashboard page

  Scenario: Verify LABOR Graph display
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Active Operators Time Groups is displayed on Dashboard page

  Scenario: Verify Operators by Group - Graph displayed
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Operators by Group graph is displayed on Dashboard page

  Scenario: Verify INVENTORY - By Status
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates By Status graph widget is displayed on Dashboard page

  Scenario: Verify WAREHOUSE CAPACITY - Graph display
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Warehouse Capacity graph is displayed on Dashboard page

  Scenario: Verify WAREHOUSE CAPACITY - Empty Locations by Zone
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Empty Locations by Zone graph is displayed on Dashboard page

  Scenario: Verify WAREHOUSE CAPACITY - Warehouse Capacity
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Warehouse Capacity graph is displayed on Dashboard page
    And Validates Warehouse Capacity picture is displayed on Dashboard page

  Scenario: Checking Appointment Scheduler Navigation functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Appointment scheduler page
    Then Appointment Scheduler page is displayed

  Scenario: Checking Appointment Scheduler Creation With Valid Order functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Appointment scheduler page
    And Waiting Appointment Scheduler Page To Load
    And Appointment Scheduler page is displayed
    When User searches for valid order "R" for appointment on Appointment Scheduler page
    And Validates Order Data on Appointment Scheduler page
    And User selects order by row number 0 on Appointment Scheduler page
    Then Click Next on Appointment Scheduler page
    And Validates Delivery Type and Email on Appointment Scheduler Delivery page are displayed
    And Click Next on Appointment Scheduler page
    And Validates Submit button is active on Appointment Scheduler page
    And Validates Scheduler date and Scheduler time on Appointment Scheduler page

  Scenario: Checking Cancel Appointment Scheduler Creation With Valid Order
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Appointment scheduler page
    And Waiting Appointment Scheduler Page To Load
    And Appointment Scheduler page is displayed
    When User types order number "1" on Appointment Scheduler page
    Then Validates Invalid Order Warning on Appointment Scheduler page
    And Validates Next Button is not active on Appointment Scheduler page
    And Validates Cancel Button is not active on Appointment Scheduler page

  Scenario: Checking Cancel Appointment Scheduler Creation With Valid Order
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Appointment scheduler page
    And Waiting Appointment Scheduler Page To Load
    And Appointment Scheduler page is displayed
    When User searches for valid order "R" for appointment on Appointment Scheduler page
    And Validates Order Data on Appointment Scheduler page
    And User selects order by row number 0 on Appointment Scheduler page
    Then Click Next on Appointment Scheduler page
    And Validates Delivery Type and Email on Appointment Scheduler Delivery page are displayed
    And Types email "testuser@gmail.com" on Appointment Scheduler page
    And User selects delivery "DRY" on Appointment Scheduler page
    And Click Next on Appointment Scheduler page
    And User types Future Date in 10 days on Appointment Scheduler page
    And Click Cancel button on Appointment Scheduler page