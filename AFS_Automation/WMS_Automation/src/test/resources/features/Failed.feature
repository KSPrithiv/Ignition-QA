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