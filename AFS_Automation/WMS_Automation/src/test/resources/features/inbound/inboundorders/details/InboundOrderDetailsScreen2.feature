@Inbound @Regression
Feature: Testing of Inbound Orders details screen
  Scenario: Checking Comments on Inbound Order details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And Validates Inbound Order Summary Page contains all web elements
    When User finds all orders from start date by index 0 to end date by index 0
    Then Selects order with index 0 on Inbound Order Summary page
    And User waits for Inbound Order Details page to load
    And Validates items are present on Inbound Order Details page
    And Validates Comments Button is present on Inbound Order Details page

  Scenario: Checking Images on Inbound Order details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 0
    Then Selects order with index 0 on Inbound Order Summary page
    And User waits for Inbound Order Details page to load
    And Validates items are present on Inbound Order Details page
    And Validates Images Button is present on Inbound Order Details page

  Scenario: Checking Change Door on Inbound Order details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 0
    Then Selects order with index 0 on Inbound Order Summary page
    And User waits for Inbound Order Details page to load
    And Validates items are present on Inbound Order Details page
    And Clicks door option on Inbound Order Details page
    And Clicks Select door option on Inbound Order Details page
    And Selects DR01 option on Inbound Order Details page
    And Clicks Save button on Inbound Order Details page
    And Clicks door option on Inbound Order Details page
    And Clicks Select door option on Inbound Order Details page
    And Selects DOOR option on Inbound Order Details page
    And Clicks Save button on Inbound Order Details page

  Scenario: Checking Order details on Inbound Order details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 0
    Then Selects order with index 0 on Inbound Order Summary page
    And User waits for Inbound Order Details page to load
    And Validates items are present on Inbound Order Details page
    And Validates Inbound Order Details page contains all web elements
    And Validates Received, Staged, Over and Remainder are present on Inbound Order Details page with correct color
    And Validates Status, Door and Data on Inbound Order Details page

  Scenario: Checking Log Details on Inbound Order details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 0
    Then Selects order with index 0 on Inbound Order Summary page
    And User waits for Inbound Order Details page to load
    And Validates items are present on Inbound Order Details page
    And User applies order "Log" option on Inbound Order Details page
    And Validates popup Receiver details on Inbound Order Details page
    And Clicks Add Filter button on Inbound Order Details page
    And Validates popup Add Filter on Inbound Order Details page

  Scenario: Checking Move Order to a Load on Inbound Order details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 0
    Then Selects order with index 0 on Inbound Order Summary page
    And User waits for Inbound Order Details page to load
    And Validates items are present on Inbound Order Details page
    And User applies order "Move" option on Inbound Order Details page
    And Validates Save button is disabled on Inbound Order Details page
    And Types Ship Date by index 5 on Inbound Order Details page
    And Types Load name by index 0 on Inbound Order Details page
    And Validates Save button is enabled on Inbound Order Details page

  Scenario: Checking Back button on Inbound Order details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 0
    Then Selects order with index 0 on Inbound Order Summary page
    And User waits for Inbound Order Details page to load
    And Validates Inbound Order Details Page contains all web elements
    And Clicks Route Back button on Inbound Order Details page
    And Validates Inbound Order Summary Page contains all web elements

  Scenario: Checking Add/Delete Images on Inbound Order details page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 0
    Then Selects order with index 0 on Inbound Order Summary page
    And User waits for Inbound Order Details page to load
    And Validates Inbound Order Details Page contains all web elements
    And Select Order Product with index 0 on Inbound Order Details page
    And Clicks Order Line Image button on Inbound Order Details page
    And Validates Load Images on Inbound Order Details page