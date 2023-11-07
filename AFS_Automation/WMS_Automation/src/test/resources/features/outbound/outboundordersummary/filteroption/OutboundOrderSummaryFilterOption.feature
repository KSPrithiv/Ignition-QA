@Outbound @Regression
Feature: Testing of Outbound Summary Filter Option functionality
  Scenario: Checking Filtering Start and End Date
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Outbound Order Summary page is displayed
    And Validates Outbound Order Summary dates
    When Filling start date "01/01/2022" and end date "01/31/2022" on Outbound Order Summary page
    Then Validates Outbound Order Summary start date "01/01/2022" and end date "01/31/2022"

  @isofailed2
  Scenario: Checking Filtering Enter Order Data
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    Then Searches for order by index 6 on Outbound Order Summary page
    And Validates Outbound Order Summary grid with order by index 6
    And Searches for order "454577" on Outbound Order Summary page

  Scenario: Checking Filtering Get Status
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And User clicks All Statuses dropdown on Outbound Order Summary page
    And Validates Open status
    And Validates Closed status
    And Validates Shipment In Progress status
    When Filling start date by index 2 on Outbound Order Summary page
    And Select Outbound Order Closed status
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order Status is Closed
    And Click Back button on Outbound Order Summary page
    And Select Outbound Order Shipment In Progress status
    And Select Outbound Order Open status
    And Select Order checkbox with index 0 on Outbound Order Summary page
    And Select Order checkbox with index 1 on Outbound Order Summary page
    And Selecting Outbound Order Release option on Outbound Order Summary page
    And Validates popup Release assignment title on Outbound Order Summary page
    And Click Cancel button on Outbound Order Summary page

  Scenario: Checking Filtering Account Index Search
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Account Field contains "Enter a account" text
    When Filling start date by index 2 on Outbound Order Summary page
    And Clears Account field on Outbound Order Summary page
    And Selects Account by index 5 on Outbound Order Summary page
    Then Selects first order on Outbound Order Summary page
    And Validates Account value by index 5 is correct on Outbound Order Summary page
    And Click Back button on Outbound Order Summary page
    And Clears Enter Account field on Outbound Order Summary page
    And Click Search account on Outbound Order Summary page
    And Searches account "test" on Outbound Order Summary page
    And Validates account "test" on Outbound Order Summary page
    And Click Clear account index on Outbound Order Summary page
    And Searches account by index 3 on Outbound Order Summary page
    And Validates Adjust filter to display data on Outbound Order Summary grid
    And Click Cancel button on Outbound Order Summary page

  @isofailed2
  Scenario: Checking Filtering Search by door
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And Validates default "Select door" door dropdown value
    And Selects "DOOR" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR" option
    And Click Back button on Outbound Order Summary page

  Scenario: Check Order type functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And User clicks order type dropdown on Outbound Order Summary page
    Then Validates Order types are not empty on Outbound Order Summary page
    And User selects option by index 0 on Outbound Order Summary page
    And Validates orders are found on Outbound Order Summary page
    And User clicks order type dropdown on Outbound Order Summary page
    And User selects option by index 1 on Outbound Order Summary page
    And Validates orders are found on Outbound Order Summary page

  @isofailed2
  Scenario: Check Get Filter product
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates default "Enter a product" product value
    And Validates Outbound Order Summary dates
    When Filling start date by index 2 on Outbound Order Summary page
    And Enters Product by index 2 on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Click Back button on Outbound Order Summary page
    And Filling current start date and tomorrow end date on Outbound Order Summary page
    And Enters Product by index 3 on Outbound Order Summary page

  @isofailed2
  Scenario: Check Get Order Display Grid Data
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And Selects "DOOR" door option on Outbound Order Summary page
    And Validates All Filters Panel is not active on Outbound Order Summary page
    Then Validates order columns are displayed on Outbound Order Summary page
    And Select Order checkbox with index 0 on Outbound Order Summary page
    And Validates Order Statuses are displayed on Outbound Order Summary page
    And Validates Orders Count is displayed on Outbound Order Summary page

  Scenario: Check Get Order Route Status
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And Validates Outbound Order Summary status default value
    And Select Outbound Order Open status
    And Validates orders are found on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Open status for order
    And Click Back button on Outbound Order Summary page
    Then Select Order checkbox with index 0 on Outbound Order Summary page
    And Selecting Outbound Order DOOR option on Outbound Order Summary page
    And Validates popup Assign doors title on Outbound Order Summary page
    And Click Cancel button on Outbound Order Summary page