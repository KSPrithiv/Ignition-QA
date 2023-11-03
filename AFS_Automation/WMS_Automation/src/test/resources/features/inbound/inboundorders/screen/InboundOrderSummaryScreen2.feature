@Inbound @Regression
Feature: Testing of Inbound Orders functionality
  Scenario: Checking Status Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from start date by index 4
    And Validates orders are present on Inbound Order Summary page
    When Clicks order status "All statuses" on Inbound Order Summary page
    And Selects order status "Ready To Receive" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    Then Clicks order status "Ready To Receive" on Inbound Order Summary page
    And Selects order status "Received Order" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "Received Order" on Inbound Order Summary page
    And Selects order status "Cancelled" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  @isofailed2
  Scenario: Checking Order Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    And Validates orders are present on Inbound Order Summary page
    Then Select order by index 0 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clear order name on Inbound Order Summary page
    And Select order by index 1 on Inbound Order Summary page

  Scenario: Checking Summary totals on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "All statuses" on Inbound Order Summary page
    And Selects order status "Ready To Receive" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "Ready To Receive" on Inbound Order Summary page
    And Selects order status "All statuses" on Inbound Order Summary page
    Then Clicks carrier by index 0 on Inbound Order Summary page
    And Selects carrier by index 1 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clicks carrier by index 1 on Inbound Order Summary page
    And Selects carrier by index 0 on Inbound Order Summary page
    And Clicks "Select door" door option on Inbound Order Summary page
    And Selects "DOOR" door option on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Status change from Received order to ReOpen on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "All statuses" on Inbound Order Summary page
    And Selects order status "Received Order" on Inbound Order Summary page
    Then Check order with index 0 on Inbound Order Summary page
    And Clicks change status option on Inbound Order Summary page
    And Validates popup Change status title for Inbound Order Summary page
    And Validates Change status popup with Reopen Order status on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page

  Scenario: Checking Status change from Open to Ready to Receive on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "All statuses" on Inbound Order Summary page
    And Selects order status "Open" on Inbound Order Summary page
    Then Check order with index 0 on Inbound Order Summary page
    And Clicks change status option on Inbound Order Summary page
    And Validates popup Change status title for Inbound Order Summary page
    And Validates Change status popup with Ready To Receive Order status on Inbound Order Summary page
    And Validates Change status popup with Cancel Order status on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page

  Scenario: Checking Status change from Ready to Receive to Finish on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "All statuses" on Inbound Order Summary page
    Then Selects order status "Ready To Receive" on Inbound Order Summary page
    And Checks Order with index 0 on Inbound Order Summary page
    And Clicks change status option on Inbound Order Summary page
    And Validates popup Change status title for Inbound Order Summary page
    And Validates Change status popup with Finish Receiving Order status on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page

  Scenario: Checking Progress bar colors on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    Then Validates orders are present on Inbound Order Summary page
    And Validates Received, Staged, Over and Remainder are present on Inbound Order Summary page with correct color
    And Validates items are present on Inbound Order Summary page

  Scenario: Checking Source option on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    Then Validates orders are present on Inbound Order Summary page
    And Selects Order with index 1 and apply "Source" Order Option on Inbound Order Summary page
    And Validates Source order screen on Inbound Order Summary page
    And Validates Received, Staged and Remainder are present on Inbound Order Summary Source page with correct color
    And Clicks Route Back button on Inbound Order Summary page

  Scenario: Checking Receive option on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    And Validates orders are present on Inbound Order Summary page
    Then Selects Order with index 0 and apply "Receive" Order Option on Inbound Order Summary page
    And Receiving page loads
    And Receiving page contains all web elements
    And Clicks Route Back button on Inbound Order Summary page
    And Checks Order with index 1 on Inbound Order Summary page
    And Clicks Order Option on Inbound Order Summary page
    And Validates Order option "Receive" on Inbound Order Summary page is disabled

 Scenario: Checking Edit option on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4
    And Validates orders are present on Inbound Order Summary page
    And Selects Order with index 1 and apply "Edit" Order Option on Inbound Order Summary page
    And Validates Edit load popup on Inbound Order Summary page
    Then Filling scheduled date by index 2 and scheduled time "5:00" on Edit popup on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page
    And Checks Order with index 2 on Inbound Order Summary page
    And Clicks Order Option on Inbound Order Summary page
    And Validates Order option "Edit" on Inbound Order Summary page is disabled