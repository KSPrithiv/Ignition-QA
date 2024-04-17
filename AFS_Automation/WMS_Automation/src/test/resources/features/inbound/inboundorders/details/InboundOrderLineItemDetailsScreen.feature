@Inbound @Regression
Feature: Testing of Inbound Orders Line Item details screen
  Scenario: Checking Navigate to Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And Validates Inbound Order Summary Page contains all web elements
    Then User finds all orders from start date by index 4
    And Selects order with index 0 on Inbound Order Summary page
    And Validates Inbound Order Details Page contains all web elements
    And Select Order Line Item with index 0 on Inbound Order Details page
    And Validates Inbound Order Line Item Details page contains all web elements

  Scenario: Checking Product details and UPC on Inbound Load order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    Then User finds all orders from start date by index 4
    And Selects order with index 0 on Inbound Order Summary page
    And Validates Inbound Order Details Page contains all web elements
    And Select Order Line Item with index 0 on Inbound Order Details page
    And Validates Inbound Order Line Item Details page contains all web elements
    And Validates Product details and UPC on Inbound Order Line Items Details page


  Scenario: Checking Navigate to Lookup location on Inbound Order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    Then User finds all orders from start date by index 4
    And Selects order with index 2 on Inbound Order Summary page
    And Select Order Line Item with index 0 on Inbound Order Details page
    And Validates Inbound Order Line Item Details page contains all web elements
    And Validates Product details and UPC on Inbound Order Line Items Details page
    And Clicks Order Location Link on Inbound Order Line Items Details Screen page
    And Waits For Inbound Order Location Lookup page to load
    And Validates Inbound Order Location Lookup page contains all web elements

  Scenario: Checking Back button on Inbound Order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    Then User finds all orders from start date by index 4
    And Selects order with index 0 on Inbound Order Summary page
    And Validates Inbound Order Details Page contains all web elements
    And Select Order Line Item with index 0 on Inbound Order Details page
    And Validates Inbound Order Line Item Details page contains all web elements
    And Clicks Route Back button on Inbound Order Line Items Details Screen page
    And Validates Inbound Order Details Page contains all web elements


  Scenario: Checking Data option on Inbound Order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    Then User finds all orders from start date by index 4
    And Selects order with index 0 on Inbound Order Summary page
    And Validates Inbound Order Details Page contains all web elements
    And Select Order Line Item with index 0 on Inbound Order Details page
    And Validates Inbound Order Line Item Details page contains all web elements
    And Clicks Order Line Data button on Inbound Order Line Items Details Screen page
    And Validates Inbound Order data screen on Inbound Order Line Items Details page


  Scenario: Checking Edit option on Inbound Order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    Then User finds all orders from start date by index 4
    And Selects order with index 0 on Inbound Order Summary page
    And Validates Inbound Order Details Page contains all web elements
    And Select Order Line Item with index 0 on Inbound Order Details page
    And Validates Inbound Order Line Item Details page contains all web elements
    And Clicks Order Line Edit button on Inbound Order Line Items Details Screen page
    And Validates Edit order line popup on Inbound Order Line Items Details page


  Scenario: Checking Image option on Inbound Order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    Then User finds all orders from start date by index 4
    And Selects order with index 0 on Inbound Order Summary page
    And Validates Inbound Order Details Page contains all web elements
    And Select Order Line Item with index 0 on Inbound Order Details page
    And Validates Inbound Order Line Item Details page contains all web elements
    And Clicks Order Line Image button on Inbound Order Line Items Details Screen page
    And Validates Order Images on Inbound Order Line Items Details page
    And Validates Save and Cancel buttons for Load image on Inbound Order Line Items Details page
    And Clicks Cancel on Edit order line popup on Inbound Order Line Items Details Screen page
    And Validates Product details and UPC on Inbound Order Line Items Details page

  Scenario: Checking Comments on Inbound Order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    Then User finds all orders from start date by index 4
    And Selects order with index 0 on Inbound Order Summary page
    And Validates Inbound Order Details Page contains all web elements
    And Select Order Line Item with index 0 on Inbound Order Details page
    And Validates Inbound Order Line Item Details page contains all web elements
    And Validates Comments Button is displayed on Inbound Order Line Items Details page

  Scenario: Checking Images on Inbound Order line item details page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    Then User finds all orders from start date by index 4
    And Selects order with index 0 on Inbound Order Summary page
    And Validates Inbound Order Details Page contains all web elements
    And Select Order Line Item with index 0 on Inbound Order Details page
    And Validates Inbound Order Line Item Details page contains all web elements
    And Validates Images Button is displayed on Inbound Order Line Items Details page