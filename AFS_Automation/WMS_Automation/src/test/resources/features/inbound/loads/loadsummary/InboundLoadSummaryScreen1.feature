#@Inbound @Regression
Feature: Testing of Inbound Load Summary screen functionality
  @1
  Scenario: Checking Load Summary screen
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    When Go to Loads page
    Then Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present

  @2
  Scenario: Checking Load Summary screen Date filter
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Selects 453 days ago from start date on Inbound Load Summary page
    When card body is closed do expand
    And Validates loads are present on Inbound Load Summary page
    Then Selects 25 days forward from start date on Inbound Load Summary page
    When card body is closed do expand
    And Selects 125 days forward from end date on Inbound Load Summary page
    When card body is closed do expand
    And Validates Items are displayed on Inbound Load Summary page

    And Selects 453 days ago from start date on Inbound Load Summary page

    And Selects 33 days ago from end date on Inbound Load Summary page

    When card body is closed do expand
    And Validates loads are present on Inbound Load Summary page

  @3
  Scenario: Checking Load Summary screen Load filter
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    When card body is closed do expand
    And Types load by index 1 on Inbound Load Summary page
    When card body is closed do expand
    And Validates loads are present on Inbound Load Summary page
    When card body is closed do expand
    And Cleans load input on Inbound Load Summary page
    When card body is closed do expand
    Then Types load by index 3 on Inbound Load Summary page
    When card body is closed do expand
    And Validates loads are present on Inbound Load Summary page
    When card body is closed do expand
    And Cleans load input on Inbound Load Summary page
    When card body is closed do expand
    And Types load "load" on Inbound Load Summary page
    When card body is closed do expand
    And Cleans load input on Inbound Load Summary page
    When card body is closed do expand
    And Types start date by index 0 on Inbound Load Summary page
    When card body is closed do expand
    And Types end date by index 4 on Inbound Load Summary page
    When card body is closed do expand
    And Types load by index 1 on Inbound Load Summary page
    When card body is closed do expand
    And Validates loads are present on Inbound Load Summary page

  @4
  Scenario: Checking Load Summary screen Status Filter
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    When card body is closed do expand
    And Clicks load status "All statuses" on Inbound Load Summary page
    When card body is closed do expand
    Then Selects load status "Ready To Receive" on Inbound Load Summary page
    When card body is closed do expand
    And Validates Items found is displayed on Inbound Load Summary page
    When card body is closed do expand
    And Clicks load status "Ready To Receive" on Inbound Load Summary page
    When card body is closed do expand
    And Selects load status "Received Order" on Inbound Load Summary page
    When card body is closed do expand
    And Validates Items found is displayed on Inbound Load Summary page

  @5
  Scenario: Checking Load Summary screen Carrier Filter
#    Given User signs in the application
#     And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Loads page
#    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    When card body is closed do expand
    And Types end date by index 4 on Inbound Load Summary page
    When card body is closed do expand
    And Clicks carrier by index 0 on Inbound Load Summary page
    When card body is closed do expand
    Then Selects carrier by index 3 on Inbound Load Summary page
    When card body is closed do expand
    And Validates Items found is displayed on Inbound Load Summary page
    When card body is closed do expand
    And Clicks carrier by index 3 on Inbound Load Summary page
    When card body is closed do expand
    And Selects carrier by index 2 on Inbound Load Summary page
    When card body is closed do expand
    And Validates Items found is displayed on Inbound Load Summary page

  @6
  Scenario: Checking Load Summary screen Door Filter
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Loads page
#    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    When card body is closed do expand
    And Types end date by index 4 on Inbound Load Summary page
    When card body is closed do expand
    And Clicks door "Select door" dropdown on Inbound Load Summary page
    When card body is closed do expand
    Then Clicks door "DOOR" on Inbound Load Summary page
    When card body is closed do expand
    And Validates Items found is displayed on Inbound Load Summary page
    When card body is closed do expand
    And Clicks door "DOOR" dropdown on Inbound Load Summary page
    And Clicks door "DR02" on Inbound Load Summary page
    When card body is closed do expand
    And Validates Items found is displayed on Inbound Load Summary page

 @7
  Scenario: Checking Load Summary screen Load type filter
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Loads page
#    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    When card body is closed do expand
    And Types end date by index 4 on Inbound Load Summary page
    When card body is closed do expand
    Then Clicks load type by index 0 dropdown on Inbound Load Summary page
    When card body is closed do expand
    And Clicks load type by index 1 on Inbound Load Summary page
    When card body is closed do expand
    And Validates Items found is displayed on Inbound Load Summary page

 @8
  Scenario: Checking Load Summary screen Supplier code filter
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Loads page
#    And Inbound Load Summary page appears
#    And Validates default values of Start Date and End date on Inbound Load Summary page
    When Types start date by index 4 on Inbound Load Summary page
    When card body is closed do expand
    Then Types supplier code by index 4 on Inbound Load Summary page
    When card body is closed do expand
    And Validates loads are present on Inbound Load Summary page

  @9
  Scenario: Checking Load Summary screen Supplier name filter
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Loads page
#    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    When card body is closed do expand
    Then Types supplier name "Jackson, Lincoln and Adams Atorneys at Law" on Inbound Load Summary page
    When card body is closed do expand
    And Validates loads are present on Inbound Load Summary page
    When card body is closed do expand
    And Clears supplier name on Inbound Load Summary page
    When card body is closed do expand
    And Types supplier name "DtdGe" on Inbound Load Summary page
    When card body is closed do expand
    And Validates Items found not displayed on Inbound Load Summary page

  @10
  Scenario: Checking Load Summary screen Product filter
    Given User signs in the application
    And Main page is loaded
#    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    When card body is closed do expand
    Then User types product code by index 0 on Inbound Load Summary page
    When card body is closed do expand
    And Validates loads are present on Inbound Load Summary page
    When card body is closed do expand
    And Clears product on Inbound Load Summary page
    When card body is closed do expand
    And Types product "208hi3" on Inbound Load Summary page
    When card body is closed do expand
   # And Validates Items found not displayed on Inbound Load Summary page

