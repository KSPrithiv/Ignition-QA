@Inbound @Regression
Feature: Testing of Inbound Orders functionality
  Scenario: Checking Navigate to Inbound Order Summary screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    Then Validates Inbound Order Summary Page contains all web elements

  Scenario: Checking Review on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    Then Check order with index 0 on Inbound Order Summary page
    And User applies order "Review" option on Inbound Order Summary page
    And Validates Inbound order summary Review page is displayed

  Scenario: Checking Product Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    And Types Valid product code by index 0 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    Then Deletes product on Inbound Order Summary page
    And Types invalid product code "Fr56I8" on Inbound Order Summary page

  Scenario: Checking Buyer Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    And Clicks buyer dropdown by index 0 on Inbound Order Summary page
    And Selects buyer by index 1 dropdown on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page
    Then Clicks buyer dropdown by index 1 on Inbound Order Summary page
    And Selects buyer by index 0 dropdown on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page

  Scenario: Checking Supplier Name Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    And Types supplier name by index 1 on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page
    And Cleans supplier name on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page
    Then Cleans supplier name on Inbound Order Summary page
    And Types supplier name "Hgr88Jd" on Inbound Order Summary page
    And Validates orders are not present on Inbound Order Summary page

  Scenario: Checking Supplier Code Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    And Types supplier name by index 0 on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page
    Then Cleans supplier code on Inbound Order Summary page
    And Types supplier code "Hgr88Jd" on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page

  Scenario: Checking Order Type on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    And Clicks order type by index 0 dropdown on Inbound Order Summary page
    And Selects order type by index 4 dropdown on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    Then Clicks order type by index 4 dropdown on Inbound Order Summary page
    And Selects order type by index 6 dropdown on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Customer Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    And Validates orders are present on Inbound Order Summary page
    Then Clicks customer option by index 0 on Inbound Order Summary page
    And Selects customer option by index 2 on Inbound Order Summary page

  Scenario: Checking Door Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from start date by index 4
    And Validates orders are present on Inbound Order Summary page
    When Clicks "Select door" door option on Inbound Order Summary page
    And Selects "DOOR" door option on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    Then Clicks "DOOR" option on Inbound Order Summary page
    And Selects "DR01" door option on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Carrier Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0
    And Validates orders are present on Inbound Order Summary page
    And Clicks carrier by index 0 on Inbound Order Summary page
    And Selects carrier by index 3 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    Then Clicks carrier by index 3 on Inbound Order Summary page
    And Selects carrier by index 0 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page