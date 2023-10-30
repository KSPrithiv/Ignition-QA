@Outbound @Regression
Feature: Testing of Outbound Route Summary Filter Option functionality
  Scenario: Checking Filtering Start and End Date functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date "03/01/2022" and end date "03/31/2022" on Outbound Route Summary page
    Then Validates Outbound Route Summary start date "03/01/2022" and end date "03/31/2022" on Outbound Route Summary page

  @isofailed
  Scenario: Checking Filtering Route Filter functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    And Validates Outbound Route is empty on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Types route by index 2 on Outbound Route Summary page
    And Route by index 2 is displayed on Outbound Route Summary page
    And Routes are displayed on Outbound Route Summary page
    And Routes are correct and equal route by index 2 on Outbound Route Summary page
    Then Deletes route input on Outbound Route Summary page
    And Types route "fevd" on Outbound Route Summary page
    And Deletes route input on Outbound Route Summary page
    And Types route by index 3 on Outbound Route Summary page
    And Route by index 3 is displayed on Outbound Route Summary page
    And Routes are displayed on Outbound Route Summary page
    And Routes are correct and equal route by index 3 on Outbound Route Summary page

  @isofailed
  Scenario: Checking Account Filter functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Types account by index 1 on Outbound Route Summary page
    And Account by index 1 is displayed on Outbound Route Summary page
    And Routes are displayed on Outbound Route Summary page
    And Deletes account input on Outbound Route Summary page
    Then Filling route start date by index 2 on Outbound Route Summary page
    And Types account by index 6 on Outbound Route Summary page
    And Deletes account input on Outbound Route Summary page
    And Waits for Outbound Route Summary page to load
    And Filling route start date by index 2 on Outbound Route Summary page
    And Types account "rrrrr" on Outbound Route Summary page
    And User clicks search for account button on Outbound Route Summary page
    And Validates Account Index popup on Outbound Route Summary page
    And Searches for account "111" on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Click Cancel button on Outbound Route Summary page

  Scenario: Checking Statuses Filter functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Status All status is displayed on Outbound Route Summary page
    Then User clicks status "All statuses" on Outbound Route Summary page
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
    And User clicks status "Shipment in Progress" on Outbound Route Summary page
    And User searches for status All status on Outbound Route Summary page
    And Selects route with index 0 on Outbound Route Summary page
    And Validates change status is active on Outbound Route Summary page
    And Selects route with index 2 on Outbound Route Summary page
    And Selects route with index 3 on Outbound Route Summary page
    And Validates change status is active on Outbound Route Summary page

  @isofailed
  Scenario: Checking Door Filter functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Status Select door is displayed on Outbound Route Summary page
    And User clicks door "Select door" dropdown on Outbound Route Summary page
    And User searches for door DOOR01 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    Then User clicks door "DR01" dropdown on Outbound Route Summary page
    And User searches for door DOOR02 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And User clicks door "DR02" dropdown on Outbound Route Summary page
    And User searches for door DOOR03 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page

  Scenario: Checking Product Filter functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Types valid product on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Deletes product on Outbound Route Summary page
    And User clicks on search for product button on Outbound Route Summary page
    And Validates search for product window on Outbound Route Summary page
    And Searches product on Outbound Route Summary page
    Then Selects product by index 0 on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page

  @isofailed
  Scenario: Checking Order Display Grid functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    And Validates change status is not active on Outbound Route Summary page
    And Validates work item is not active on Outbound Route Summary page
    And Validates assign item is not active on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Selects route with index 0 on Outbound Route Summary page
    And Validates change status is active on Outbound Route Summary page
    Then Validates work item is active on Outbound Route Summary page
    And Validates assign item is active on Outbound Route Summary page
    And Validates Shipped, Audit, Picked, Unallocated, Shorts, Waiting inbound and Remainder status displayed on Outbound Route Summary page
    And Validates Items Count on Outbound Route Summary page
    And Clicks Routes dropdown on Outbound Route Summary page
    And Validates Route options from Route dropdown are enabled on Outbound Route Summary page
    And Validates that time for route 0 is displayed on Outbound Route Summary page