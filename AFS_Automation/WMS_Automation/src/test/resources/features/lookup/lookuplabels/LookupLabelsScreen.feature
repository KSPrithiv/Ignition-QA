@Lookup @Regression
Feature: Testing of Lookup Labels functionality

  Scenario: Checking Labels action item exist on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    When User types location by index 4 on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    Then Validates Print Label on Location Lookup page is displayed

  Scenario: Checking Location Label on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    And Deletes cookies on application
    And User types location by index 1 on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    And User checks Location Product 0 on Lookup Location page
    And User clicks Labels button on Lookup Location page
    And Validates Labels window title "Labels" on Location Lookup page

    And User selects Label type "Product" on Lookup Location page

    And User selects Printer "Printer5" on Lookup Location page
    And User clicks OK button on Lookup Location page
    And Validates "Success" notification is displayed on Lookup Location page
    And User clicks Labels button on Lookup Location page
    And Validates Labels window title "Labels" on Location Lookup page
    And User clicks Cancel button on Lookup Location page

    @issue
  Scenario: Checking Location Shipping on Lookup Location screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User types location "101.056.80" on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    And User checks Location Product 1 on Lookup Location page

  Scenario: Checking Unit, Receiving Unit, Product on Lookup Location screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User types location "101.056.80" on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    And User checks Location Product 1 on Lookup Location page
    And User clicks Labels button on Lookup Location page
    And Validates Labels window title "Labels" on Location Lookup page
    And Clicks Label type dropdown on Lookup Location page
    And Validates Label type "Unit" exists in dropdown on Location Lookup page
    And Validates Label type "Receiving Unit" exists in dropdown on Location Lookup page
    And Validates Label type "Product" exists in dropdown on Location Lookup page
    And Clicks Label type dropdown on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded

  Scenario: Checking menu options under Lookup icon
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Clicks Lookup icon
    And Validates Location, Product, Dock management and Labels are displayed

  @issue
  Scenario: Checking Location Label validation on Lookup Location screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User types location "101.056.80" on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    And User checks Location Product 1 on Lookup Location page
    And User clicks Labels button on Lookup Location page
    And Validates Labels window title "Labels" on Location Lookup page

  @issue
  Scenario: Checking Pallet Label on Lookup Location screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User types location "101.056.80" on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    And User checks Location Product 1 on Lookup Location page
    And User clicks Labels button on Lookup Location page
    And Validates Labels window title "Labels" on Location Lookup page

  @issue
  Scenario: Checking Picking Label on Lookup Location screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User types location "101.056.80" on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    And User checks Location Product 1 on Lookup Location page
    And User clicks Labels button on Lookup Location page
    And Validates Labels window title "Labels" on Location Lookup page

  @issue
  Scenario: Checking Product Label on Lookup Location screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User types location "101.056.80" on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    And User checks Location Product 1 on Lookup Location page
    And User clicks Labels button on Lookup Location page
    And Validates Labels window title "Labels" on Location Lookup page

  @issue
  Scenario: Checking Receiving Label on Lookup Location screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User types location "101.056.80" on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    And User checks Location Product 1 on Lookup Location page
    And User clicks Labels button on Lookup Location page
    And Validates Labels window title "Labels" on Location Lookup page

  @issue
  Scenario: Checking Unit Label on Lookup Location screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User types location "101.056.80" on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    And User checks Location Product 1 on Lookup Location page
    And User clicks Labels button on Lookup Location page
    And Validates Labels window title "Labels" on Location Lookup page

  @issue
  Scenario: Checking Shipping Label on Lookup Location screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User types location "101.056.80" on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    And User checks Location Product 1 on Lookup Location page
    And User clicks Labels button on Lookup Location page
    And Validates Labels window title "Labels" on Location Lookup page

  Scenario: Checking Label Configuration on Lookup Location screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Setup System page
    And Validates Setup System page is displayed
    And Clicks Label format on Setup System page
    And Validates Add, Edit, Delete buttons are displayed on Setup System page
    And Clicks Label file on Setup System page
    And Validates Add, Edit, Delete buttons are displayed on Setup System page
    And Clicks Printer Label on Setup System page
    And Validates Add, Edit, Delete buttons are displayed on Setup System page

