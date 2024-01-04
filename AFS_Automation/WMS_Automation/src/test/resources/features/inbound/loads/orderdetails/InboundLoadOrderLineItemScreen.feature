@Inbound @Regression
Feature: Testing of Inbound Load Order Line Item screen functionality
  Scenario: Checking Navigate to Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Select Order Product with index 0 on Inbound Load Order Summary page
    And Validates Inbound Load Order Line Items page contains all web elements

  Scenario: Checking Product details and UPC on Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Select Order Product with index 0 on Inbound Load Order Summary page
    And Validates Product details and UPC on Inbound Load Order Line Items page
    And Validates Product UPC is displayed on Inbound Load Order Line Items page

  Scenario: Checking Navigate to lookup Location on Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 2 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Select Order Product with index 0 on Inbound Load Order Summary page
    And Validates Product details and UPC on Inbound Load Order Line Items page
    And Clicks Order Location Link on Inbound Load Order Line Items page
    And Waits For Inbound Load Location Lookup page to load
    And Validates Inbound Load Location Lookup page contains all web elements

  Scenario: Checking Back button on Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    Then Select Load Order with index 0 on Inbound Load Summary page
    And Select Order Product with index 0 on Inbound Load Order Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Validates Inbound Load Order details page contains all web elements

  Scenario: Checking Data option on Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 2 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Select Order Product with index 0 on Inbound Load Order Summary page
    And Inbound Load Order Line Items Page appears
    And Clicks Order Line Data button on Inbound Load Order Line Items page
    And Validates Load Order data screen on Inbound Load Order Line Items page

  Scenario: Checking Edit option on Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Select Order Product with index 0 on Inbound Load Order Summary page
    And Inbound Load Order Line Items Page appears
    And Clicks Order Line Edit button on Inbound Load Order Line Items page
    And Validates Edit order line popup on Inbound Load Order Line Items page
    And Clicks Cancel on Edit order line popup on Inbound Load Order Line Items page

  Scenario: Checking Image option on Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Select Order Product with index 0 on Inbound Load Order Summary page
    And Inbound Load Order Line Items Page appears
    And Clicks Order Line Image button on Inbound Load Order Line Items page
    And Validates Load Images on Inbound Load Order Details page
    And Validates Save and Cancel buttons for Load image on Inbound Load Order Line Items page
    And Clicks Cancel on Edit order line popup on Inbound Load Order Line Items page
    And Validates Inbound Load Order Line Items page contains all web elements
    And Validates Product details and UPC on Inbound Load Order Line Items page
    And Validates Product UPC is displayed on Inbound Load Order Line Items page

  Scenario: Checking Comments on Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Select Order Product with index 0 on Inbound Load Order Summary page
    And Validates Comments Button is displayed on Inbound Load Order Line Items page

  Scenario: Checking Images on Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Select Order Product with index 0 on Inbound Load Order Summary page
    And Validates Images Button is displayed on Inbound Load Order Line Items page

  Scenario: Searching order details on Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 0 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Validates Inbound Load Order details page contains all web elements

  Scenario: Verification of image link on Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Select Order Product with index 0 on Inbound Load Order Summary page
    And Clicks Images button on Inbound Load Summary page
    And Validates Load Images on Inbound Load Order Details page