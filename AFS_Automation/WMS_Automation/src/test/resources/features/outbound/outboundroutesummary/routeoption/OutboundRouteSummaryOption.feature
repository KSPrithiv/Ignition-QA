@Outbound @Regression
Feature: Testing of Outbound Route Summary Route option
  @issue
  Scenario: Checking Route Edit option functionality
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
    And Validates Route options from Route dropdown are enabled on Outbound Route Summary page
    And Select Outbound Route Edit option on Outbound Route Summary page
    And Validates Edit route window elements on Outbound Route Summary page
    And Validates Save and Cancel buttons are displayed on Outbound Route Summary page
   # And Validates Edit Route code field and window title on Outbound Route Summary page
 #   And Typing Outbound Route code by index 0 on Outbound Route Summary page
    And Typing random Outbound Route code on Outbound Route Summary page
    And Select Outbound Route type by index 2 on Outbound Route Summary page
    And Validates Route type by index 2 value on Outbound Route Summary page
    And Validates Scheduled Date and Scheduled Time are displayed on Outbound Route Summary page
    And Filling scheduled date "01012020" and scheduled time "11:11" on Outbound Route Summary page
    And Clicks Carrier dropdown on Outbound Route Summary page
    And Select Outbound Route carrier by index 1 option on Outbound Route Summary page
    And Type Route driver "testdriver" on Outbound Route Summary page
    And Validates Trailer is displayed on Outbound Route Summary page
    And Clicks Trailer dropdown on Outbound Route Summary page
    And Select Trailer option by index 0 on Outbound Route Summary page
    And Validates Max Stops is displayed on Outbound Route Summary page
    And Type Max Stops by index 0 on Outbound Route Summary page
    And Validates Temperature type by index 1 is displayed on Outbound Route Summary page
    And Click Temperature type by index 1 on Outbound Route Summary page
    And Select Temperature type by index 0 on Outbound Route Summary page
    And Type Temperature by index 1 on Outbound Route Summary page
    And Clicks Save button on Outbound Route Summary page
    And Validates "Success" notification is displayed on Outbound Route Summary page
   # And Validates Route with index 0 contains "Testing123" on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Select Outbound Route Edit option on Outbound Route Summary page
 #   And Validates Route type by index 2 value on Outbound Route Summary page
 #   And Validates scheduled date "01/01/2020" and scheduled time "11:11" values on Outbound Route Summary page
#   And Validates carrier by index 0 value on Outbound Route Summary page
    And Validates driver "testdriver" value on Outbound Route Summary page
    And Validates Trailer by index 0 is correct on Outbound Route Summary page
    And Validates max stops by index 0 value on Outbound Route Summary page
  #  And Validates Temperature type by index 0 is displayed on Outbound Route Summary page
  #  And Validates temperature by index 1 value on Outbound Route Summary page
   # And Door dropdown is displayed on Outbound Route Summary page
  #  And Click Temperature type by index 0 on Outbound Route Summary page
  #  And Select Temperature type by index 1 on Outbound Route Summary page
    And Clicks Save button on Outbound Route Summary page
    And Validates "Success" notification is displayed on Outbound Route Summary page

  Scenario: Checking Route Assign functionality
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
    And Selects route with index 0 on Outbound Route Summary page
    Then User selects assign item on Outbound Route Summary page
    And Verifies Assign window is displayed on Outbound Route Summary page
    And User clicks user dropdown for Assign Route on Outbound Route Summary page
    And Validates users are present for Assign Route on Outbound Route Summary page
    And Validates user dropdown for Assign Route is not empty on Outbound Route Summary page

  Scenario: Checking Route Door functionality
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
    Then Selects route with index 0 on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are enabled on Outbound Route Summary page
    And Select Outbound Route Door option on Outbound Route Summary page
    And Validates popup Assign door title for Route on Outbound Route Summary page
    And Validates Door dropdown is not empty by default on Outbound Route Summary page
    And User clicks door dropdown for Route on Outbound Route Summary page
    And Validates Doors are present in dropdown on Outbound Route Summary page
    And User clicks door "DR03" on Outbound Route Summary page
    And Clicks Save button on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Select Outbound Route Door option on Outbound Route Summary page
    And Validates popup Assign door title for Route on Outbound Route Summary page
    And Validates Door "DR03" value is correct on Outbound Route Summary page
    And Validates Save and Cancel buttons are displayed on Outbound Route Summary page
    And Click Cancel button on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Select Outbound Route Door option on Outbound Route Summary page
    And Validates popup Assign door title for Route on Outbound Route Summary page
    And User selects default option "Select door" on Outbound Route Summary page
    And Clicks Save button on Outbound Route Summary page
    And Validates Select door notification is displayed on Outbound Route Summary page
    And Click Cancel button on Outbound Route Summary page

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
    Then Validates Route options from Route dropdown are enabled on Outbound Route Summary page
    And Select Outbound Route Data option on Outbound Route Summary page
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
    And Validates source items are displayed on Outbound Route Summary page
    And Validates Route Back button on Source page is displayed on Outbound Route Summary page
    And Clicks on Route Back button on Outbound Route Summary page
    And Validates Outbound Route Summary page is displayed

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
    And Validates Columns on Types Tab are displayed on Outbound Route Summary page
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
    And Validates Route Review page is displayed on Outbound Route Summary page
    And Validates Route Review page labels are displayed on Outbound Route Summary page

  Scenario: Checking Route Tab/Move Assignment functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Selects route with index 3 on Outbound Route Summary page
    And Validates work item is active on Outbound Route Summary page
    And User selects work item on Outbound Route Summary page
    And Validates Assignments tab and Tasks tab are displayed on Outbound Route Summary page
    And Validates Assignments tab is active by default on Outbound Route Summary page
    And Validates Assignment Type filter is displayed on Outbound Route Summary page
    Then User selects first assignment for route on Outbound Route Summary page
    And Validates Edit, Delete, Release, Labels and Move for Routes are enabled on Outbound Route Summary page
    And Selects Move option for Assignment on Outbound Route Summary page
    And Validates Move assignment window on Outbound Route Summary page
    And New assignment, Existing assignment, New shipper and Existing shippers are displayed on Outbound Route Summary page
    And Validates To New or Existing Shippers disabled on Outbound Route Summary page
    And Validates Save and Cancel buttons are displayed on Outbound Route Summary page
    And Click Cancel button on Outbound Route Summary page

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
    And Validates Edit route window elements on Outbound Route Summary page
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
  #  And Validates Route with index 0 contains "Testing123" on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Select Outbound Route Edit option on Outbound Route Summary page
  #  And Validates Edit Route code field equals "Testing123" on Outbound Route Summary page
 #   And Validates Route type by index 2 value on Outbound Route Summary page
 #   And Validates scheduled date "01/01/2020" and scheduled time "11:11" values on Outbound Route Summary page
#    And Validates carrier by index 3 value on Outbound Route Summary page
 #   And Validates driver "testdriver" value on Outbound Route Summary page
 #   And Validates Trailer by index 0 is correct on Outbound Route Summary page
  ##  And Validates max stops by index 0 value on Outbound Route Summary page
  #  And Validates temperature by index 1 value on Outbound Route Summary page
    And Clicks Save button on Outbound Route Summary page

  Scenario: Checking route option Data functionality
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
    Then Selects route with index 0 on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are enabled on Outbound Route Summary page
    And Select Outbound Route Data option on Outbound Route Summary page
    And Validates Route Data page is displayed on Outbound Route Summary page
    And Validates Route Data page title contains "Route" on Outbound Route Summary page
    And Click Cancel button on Outbound Route Summary page

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
    And Validates Select door notification is displayed on Outbound Route Summary page
    And Click Cancel button on Outbound Route Summary page