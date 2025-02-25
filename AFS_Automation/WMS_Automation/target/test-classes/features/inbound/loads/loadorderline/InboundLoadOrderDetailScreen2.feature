@Inbound @Regression
Feature: Testing of Inbound Load Order Details screen functionality
  Scenario: Checking Edit option on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And User applies order "Edit" option on Inbound Load Order Summary page
    And Clicks Cancel button on Inbound Load Order Summary page

  Scenario: Checking Door option on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Clicks door option on Inbound Load Order Summary page
    And Validates popup Assign doors title for Inbound Load Order Summary page
    And Clicks door on Assign doors popup on Inbound Load Order Summary page
    And Clicks door "DR01" on Inbound Load Order Summary page
    And Clicks Save on Inbound Load Order Summary page

  Scenario: Checking Order details on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Validates Inbound Load Order details page contains all web elements

  Scenario: Checking Log Details on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 2 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page
    And User applies order "Log" option on Inbound Load Order Summary page
    And Validates popup Receiver title on Inbound Load Order Details page
    And Validates popup Receiver details on Inbound Load Order Details page
    And Clicks Ok button on Inbound Load Order Summary page

  Scenario: Checking Move Order to Load on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 2 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page
    And User applies order "Move" option on Inbound Load Order Summary page
    And Validates Move popup on Inbound Load Order Details page
    And Validates Save button is disabled for Move order to Load
    And Types Ship Date by index 5 to move Order to Load on Inbound Load Order Summary page
    And Types Load by index 0 to move Order to Load on Inbound Load Order Summary page
    And Validates Save button is enabled for Move order to Load
    And Clicks Cancel button on Inbound Load Order Summary page

  Scenario: Checking Add/Delete Image to the order on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page

  Scenario: Checking Back button on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 2 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Inbound Load Summary Details page main elements are present
    And Validates Received, Staged, Over and Remainder are present on Inbound Load Summary page with correct color

  Scenario: Checking Data Details on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 2 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page
    And Clicks data option on Inbound Load Order Summary page

  Scenario: Searching order details on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Types product code by index 5 on Inbound Load Summary page
    And Validates orders are present for load on Inbound Load Summary page
    And Clicks clear icon search input on Inbound Load Summary page
    And Types product name by index 0 on Inbound Load Summary page
    And Validates orders are present for load on Inbound Load Summary page
    And Clicks clear icon search input on Inbound Load Summary page
    And Types "DbK55Nfd" in Search Input on Inbound Load Summary page
    And Validates orders are not present for load on Inbound Load Summary page
    And Cleans search input on Inbound Load Summary page
    And Validates orders are present for load on Inbound Load Summary page