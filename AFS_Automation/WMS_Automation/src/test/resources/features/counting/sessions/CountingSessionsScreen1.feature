@Counting @Regression
Feature: Testing of Counting Count functionality

  Scenario: Checking Navigate to Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Counting Sessions page
    Then Validates Counting Sessions page is displayed
    And Validates Edit and Delete buttons are disabled on Counting Sessions page

  Scenario: Checking Existing Count Session on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    When User clicks session dropdown on Counting Sessions page
    And Validates sessions are present in Session dropdown on Counting Sessions page
    And User clicks session page title on Counting Sessions page
    Then User clicks session dropdown on Counting Sessions page
    And User selects session with index 2 on Counting Sessions page
    And Validates Locations, Products and Assignments Tabs are displayed on Counting Sessions page
    And Validates Session Labels on Counting Sessions page are displayed
    And Validates Blind Label on Counting Sessions page is displayed

  Scenario: Checking Create New Session Warnings on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    When User clicks New Session button on Counting Sessions page
    And Validates Session name and Count type are displayed on Counting Sessions page
    Then User clicks Save button on Counting Sessions page
    And Validates session warning "Enter session name" on Counting Sessions page
    And User types randomly created session name on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates session warning "Select count type" on Counting Sessions page

  Scenario: Checking Create New Session on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    And User clicks New Session button on Counting Sessions page
    And Validates Session name and Count type are displayed on Counting Sessions page
    When User types count type 3 on Counting Sessions page
    And User types randomly created session name on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Wait until Loader invisible on Counting Sessions page
    Then User clicks session dropdown on Counting Sessions page
    And User selects randomly created session on Counting Sessions page
    And Validates random session is saved on Counting Sessions page
    And Validates Session Labels on Counting Sessions page are displayed
    And Validates Locations, Products and Assignments Tabs are displayed on Counting Sessions page
    And Validates Partially informed Label on Counting Sessions page is displayed
    And Validates Session details on Counting Sessions page
    And Validates Active Checkbox is not selected on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates items are not present on Counting Sessions page
    And Validates No Record on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And Validates items are not present on Counting Sessions page
    And Validates No Record on Counting Sessions page
    And User clicks Assignments tab on Counting Sessions page
    And Validates items are not present on Counting Sessions page
    And Validates No Record on Counting Sessions page
    And User clicks New Session button on Counting Sessions page
    And Validates Session name and Count type are displayed on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page
    And User clicks Delete Session button on Counting Sessions page
    And User clicks Ok button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page

  Scenario: Checking add locations to the session on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    And User clicks New Session button on Counting Sessions page
    And Validates Session name and Count type are displayed on Counting Sessions page
    And User types count type 0 on Counting Sessions page
    When User types randomly created session name on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    Then User clicks session dropdown on Counting Sessions page
    And User selects randomly created session on Counting Sessions page
    And Validates random session is saved on Counting Sessions page
    And Validates Locations, Products and Assignments Tabs are displayed on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User types Location code with index 1 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And User clicks Yes button if need to add on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User selects Location code with index 2 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Wait until Loader invisible on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User clicks Location code button on Counting Sessions page
    And Validates Location index popup is displayed on Counting Sessions page
    And Selects location by index 0 on Counting Sessions page
    And Validates Location Code is not empty on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User types Partial location code "PartName123" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User selects random Location type with index 3 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User selects random Zone with index 2 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User types Starting Location with index 1 on Counting Sessions page
    And User types Ending Location with index 1 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And User clicks Yes button if need to add on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    And User selects randomly created session on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User types Location code with index 1 on Counting Sessions page
    And User types Partial location code "testPartName" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    And User selects randomly created session on Counting Sessions page
    And User clicks Delete Session button on Counting Sessions page
    And User clicks Ok button on Counting Sessions page

  Scenario: Checking Sorting of the columns on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 1 on Counting Sessions page
    When User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 0 on Counting Sessions page
    Then User clicks Location Column on Counting Sessions page
    And Validates Location Column Sorting Result on Counting Sessions page
    And User clicks Location Column on Counting Sessions page
    And Validates Location Column Sorting Result on Counting Sessions page
    And User clicks Zone Column on Counting Sessions page
    And Validates Zone Column Sorting Result on Counting Sessions page
    And User clicks Zone Column on Counting Sessions page
    And Validates Zone Column Sorting Result on Counting Sessions page
    And User clicks Type Column on Counting Sessions page
    And Validates Type Column Sorting Result on Counting Sessions page
    And User clicks Type Column on Counting Sessions page
    And Validates Type Column Sorting Result on Counting Sessions page
    And User clicks Status Column on Counting Sessions page
    And Validates Status Column Sorting Result on Counting Sessions page
    And User clicks Status Column on Counting Sessions page
    And Validates Status Column Sorting Result on Counting Sessions page
    And User clicks Release Date and Time Column on Counting Sessions page
    And Validates Release Date Time Column Sorting Result on Counting Sessions page
    And User clicks Release Date and Time Column on Counting Sessions page
    And Validates Release Date Time Column Sorting Result on Counting Sessions page

  Scenario: Checking Location Navigation on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    And User clicks session dropdown on Counting Sessions page
    When User selects session with index 4 on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    Then User selects session with index 3 on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks table location by index 1 on Counting Sessions page
    And Waits for Location Lookup page to load
    And Validates Notification Warning "Location locked" on Location Lookup page is displayed
    And Validates Inventory details of location on Location Lookup page are loaded

  Scenario: Checking Locked location on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 2 on Counting Sessions page
    When User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    Then User selects session with index 4 on Counting Sessions page
    And User clicks table location by index 1 on Counting Sessions page
    And Waits for Location Lookup page to load
    And Validates Inventory details of location on Location Lookup page are loaded
    And Validates Notification Warning "Location locked" on Location Lookup page is displayed
    And Validates Add location button is disabled on Lookup Location page
    And User checks table row by index 1 on Counting Sessions page
    And User clicks Delete Session button on Counting Sessions page
    And User clicks Yes button on Counting Sessions page
    And User selects reason "Create Inventory" on Counting Sessions page
    And User clicks Ok button on Counting Sessions page
    And Validates notification message contains "Location" message on Counting Sessions page
    And Validates notification message contains "is locked" message on Counting Sessions page

  Scenario: Checking Select All checkbox on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    And User clicks session dropdown on Counting Sessions page
    When User selects session with index 2 on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    Then User clicks session dropdown on Counting Sessions page
    And User selects session with index 3 on Counting Sessions page
    And User clicks Select All Checkbox on Counting Sessions page
    And Validates location with index 0 is selected on Counting Sessions page
    And User clicks Unselect All Checkbox on Counting Sessions page
    And Validates location with index 0 is not selected on Counting Sessions page

  Scenario: Checking Count Details on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    When User clicks session dropdown on Counting Sessions page
    And User selects session with index 1 on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    Then User selects session with index 2 on Counting Sessions page
    And User clicks table count by index 1 on Counting Sessions page
    And Validates Count Details popup on Counting Sessions page
    And Validates Count History columns are displayed on Counting Sessions page
    And User clicks all inputs checkbox on Count details popup on Counting Sessions page
    And Validates Counted Location columns on Count details popup on Counting Sessions page