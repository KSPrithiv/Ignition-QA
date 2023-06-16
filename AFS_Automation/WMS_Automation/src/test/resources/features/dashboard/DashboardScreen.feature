@Dashboard @Regression
Feature: Testing of Dashboard functionality

  Scenario: Checking Dashboard Icon and Spelling
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page

  Scenario: Checking Dashboard menu item
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And User clicks user profile icon on Dashboard page
    And Clicks user profile logout icon on Dashboard page
    And Waits until Login page is visible

  Scenario: Checking Visibility Of Dashboard
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And User clicks user profile icon on Dashboard page
    And Clicks user profile logout icon on Dashboard page
    And Waits until Login page is visible
    And Admin user signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Security Permissions page
    And Unselects allow user access to Dashboard checkbox on Security Permissions page
    And User clicks user profile icon on Dashboard page
    And Clicks user profile logout icon on Dashboard page
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
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Go to Work Queue Task page
    And Waits for Work Queue Task page to load
    And Validates Work Queue Task page is displayed
    And Validates Search Field in right top corner of the grid is displayed on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And Go to Dashboard page
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Tasks by Type widget on Dashboard page
    And Clicks Cycle Count graph bar on DockManagement page
    And Waits for Work Queue Task page to load
    And Validates Work Queue Task page is displayed
    And Validates Search Field in right top corner of the grid is displayed on Work Queue Task page
    And Hover mouse over Search on Work Queue Task page
    And Validates Searchable items are displayed as Tool tip on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And Go to Dashboard page
    And Hover over Cycle Count graph bar on DockManagement page
    And Validates number of Tasks popup is displayed on Dashboard page

  Scenario: Checking Transactions -> Assignments by Group widgets
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "SavInformed - Active" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Assignments tab on Counting Sessions page
    And Validates Assignment tab contains Release and Delete buttons, Add filter button on Counting Sessions page
    And Go to Work Queue Assign Work page
    And Waits for Work Queue Work Assign page to load
    And Validates Assign work screen is displayed on Work Queue Work Assign Page
    And Go to Dashboard page
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Assignments by Group widget on Dashboard page
    And Clicks Count graph bar on DockManagement page
    And Waits for Work Queue Task page to load
    And Validates Work Queue Task page is displayed
    And Validates Search Field in right top corner of the grid is displayed on Work Queue Task page
    And Hover mouse over Search on Work Queue Task page
    And Validates Searchable items are displayed as Tool tip on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And Go to Dashboard page
    And Hover over Count graph bar on DockManagement page
    And Validates number of Tasks popup is displayed on Dashboard page

  Scenario: Checking Transactions -> Picking Status widget
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Picking Status graph is displayed on Dashboard page

  Scenario: Checking Transactions -> Late Outbound widget
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Late Outbound graph is displayed on Dashboard page

  Scenario: Checking Transactions -> Late Inbound widget
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Late Inbound graph is displayed on Dashboard page

  Scenario: Checking Transactions -> Inbound Loads widget
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Inbound Loads graph is displayed on Dashboard page

  Scenario: Checking Transactions -> Outbound Routes widget
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Outbound Routes graph is displayed on Dashboard page

  Scenario: Checking Transactions -> Inbound Orders widget
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Inbound Orders graph is displayed on Dashboard page

  Scenario: Verify that Labor widget is divided into two Parts
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Active Operators graph is displayed on Dashboard page
    And Validates Operators by Group graph is displayed on Dashboard page

  Scenario: Verify Labor Active Operators
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Validates Active Operators graph is displayed on Dashboard page
    And Validates Active Operators Time Groups is displayed on Dashboard page

  Scenario: Verify the Labor widgets is visible to the logged in user
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Clicks On Break graph bar on DockManagement page
    And Waits for Work Queue Logged In Users page to load
    And Validates User Logged In title is displayed on Work Queue Logged In Users page
    And Validates table columns are displayed on Work Queue Logged In Users page

  Scenario: Verify that Assignment logged in user display
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Validates Dashboard Icons and Spelling on Dashboard page
    And Clicks Pal Dry graph bar on DockManagement page
    And Waits for Work Queue Assignments page to load
    And Work Queue Assignments Page is validated

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