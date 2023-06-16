@Outbound @Regression
Feature: Testing of Outbound Route Summary Filter Option functionality

  Scenario: Checking Filtering Start and End Date functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    Then Filling route start date "03/01/2022" and end date "03/31/2022" on Outbound Route Summary page
    And Validates Outbound Route Summary start date "03/01/2022" and end date "03/31/2022" on Outbound Route Summary page

  Scenario: Checking Filtering Route Filter functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    And Validates Outbound Route is empty on Outbound Route Summary page
    Then Filling route start date "01/01/2017" and end date "03/31/2022" on Outbound Route Summary page
    And Types route "1355" on Outbound Route Summary page
    And Route "1355" is displayed on Outbound Route Summary page
    And Routes are displayed on Outbound Route Summary page
    And Routes are correct and equal "1355" on Outbound Route Summary page
    And Deletes route input on Outbound Route Summary page
    And Types route "fevd" on Outbound Route Summary page
    And Validates No Record Outbound Route Summary grid on Outbound Route Summary page
    And Deletes route input on Outbound Route Summary page
    And Types route "1316" on Outbound Route Summary page
    And Route "1316" is displayed on Outbound Route Summary page
    And Routes are displayed on Outbound Route Summary page
    And Routes are correct and equal "1316" on Outbound Route Summary page

  @issue
  Scenario: Checking Account Filter functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    Then Filling route start date "01/01/2017" and end date "03/31/2022" on Outbound Route Summary page
    And Types account "001001" on Outbound Route Summary page
    And Account "001001" is displayed on Outbound Route Summary page
    And Routes are displayed on Outbound Route Summary page
    And Deletes account input on Outbound Route Summary page
    And Filling route start date "01/01/2017" and end date "01/01/2017" on Outbound Route Summary page
    And Types account "001001" on Outbound Route Summary page
    And Validates No Record Outbound Route Summary grid on Outbound Route Summary page
    And Deletes account input on Outbound Route Summary page
    And Waits for Outbound Route Summary page to load
    And Filling route start date "01/01/2017" and end date "03/31/2022" on Outbound Route Summary page
    And Types account "rrrrr" on Outbound Route Summary page
    And Validates No Record Outbound Route Summary grid on Outbound Route Summary page
    And User clicks search for account button on Outbound Route Summary page
    And Validates Account Index popup on Outbound Route Summary page
    And Searches for account "111" on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Click Cancel button on Outbound Route Summary page

  Scenario: Checking Statuses Filter functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    Then Filling route start date "01/01/2010" and end date "03/31/2022" on Outbound Route Summary page
    And Status All status is displayed on Outbound Route Summary page
    And User clicks status "All status" on Outbound Route Summary page
    And User searches for status Cancelled on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And User clicks status "Cancelled" on Outbound Route Summary page
    And User searches for status Open on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And User clicks status "Open" on Outbound Route Summary page
    And User searches for status Closed on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And User clicks status "Closed" on Outbound Route Summary page
    And User searches for status Shipment in Progress on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    When User clicks status "Shipment in Progress" on Outbound Route Summary page
    And User searches for status All status on Outbound Route Summary page
    And Selects route with index 0 on Outbound Route Summary page
    And Validates change status is active on Outbound Route Summary page
    And Selects route with index 2 on Outbound Route Summary page
    And Selects route with index 3 on Outbound Route Summary page
    And Validates change status is active on Outbound Route Summary page

  Scenario: Checking Door Filter functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    Then Filling route start date "01/01/2010" and end date "03/31/2022" on Outbound Route Summary page
    And Status Select door is displayed on Outbound Route Summary page
    And User clicks door "Select door" dropdown on Outbound Route Summary page
    And User searches for door D1 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And User clicks door "D1" dropdown on Outbound Route Summary page
    And User searches for door DOOR on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And User clicks door "DOOR" dropdown on Outbound Route Summary page
    And User searches for door DOOR01 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And User clicks door "DOOR01" dropdown on Outbound Route Summary page
    And User searches for door DOOR02 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And User clicks door "DOOR02" dropdown on Outbound Route Summary page
    And User searches for door DOOR03 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Filling route start date "01/01/2022" and end date "01/02/2022" on Outbound Route Summary page
    And User clicks door "DOOR03" dropdown on Outbound Route Summary page
    And User searches for door DOOR04 on Outbound Route Summary page
    And Validates No Record Outbound Route Summary grid on Outbound Route Summary page

  Scenario: Checking Product Filter functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    Then Filling route start date "01/01/2018" and end date "03/31/2022" on Outbound Route Summary page
    And Types valid product on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Deletes product on Outbound Route Summary page
    And User clicks on search for product button on Outbound Route Summary page
    And Validates search for product window on Outbound Route Summary page
    And Searches product on Outbound Route Summary page
    And Selects product by index 0 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page

  Scenario: Checking Order Display Grid functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    And Validates change status is not active on Outbound Route Summary page
    And Validates work item is not active on Outbound Route Summary page
    And Validates assign item is not active on Outbound Route Summary page
    Then Filling route start date "01/01/2018" and end date "03/31/2022" on Outbound Route Summary page
    And Selects route with index 0 on Outbound Route Summary page
    And Validates change status is active on Outbound Route Summary page
    And Validates work item is active on Outbound Route Summary page
    And Validates assign item is active on Outbound Route Summary page
    And Validates Routes, Order, Quantity, Lines, Pallets, Cube, Weight and Amount columns displayed on Outbound Route Summary page
    And Validates Shipped, Audit, Picked, Unallocated, Shorts, Waiting inbound and Remainder status displayed on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are enabled on Outbound Route Summary page
    And Validates that time for route 0 is displayed on Outbound Route Summary page