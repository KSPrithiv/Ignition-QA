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
    When User finds all orders from start date by index 0 to end date by index 0
    Then Check order with index 0 on Inbound Order Summary page
    And User applies order "Review" option on Inbound Order Summary page
    And Validates Inbound order summary Review page is displayed

  #issue
  Scenario: Checking Product Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 0
    And Types Valid product code by index 0 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    Then Deletes product on Inbound Order Summary page
    And Types invalid product code "Fr56I8" on Inbound Order Summary page
    And Validates orders are not present on Inbound Order Summary page

  Scenario: Checking Buyer Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 0
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
    When User finds all orders from start date by index 0 to end date by index 0
    And Types supplier name by index 1 on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page
    And Cleans supplier name on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page
    Then Cleans supplier name on Inbound Order Summary page
    And Types supplier name "Hgr88Jd" on Inbound Order Summary page
    And Validates orders are not present on Inbound Order Summary page

  #issue
  Scenario: Checking Supplier Code Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 3 to end date by index 0
    And Types supplier name by index 0 on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    Then Cleans supplier code on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Types supplier code "Hgr88Jd" on Inbound Order Summary page
    And Validates orders are not present on Inbound Order Summary page

  Scenario: Checking Order Type on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 3 to end date by index 0
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
    When User finds all orders from start date by index 0 to end date by index 0
    And Validates orders are present on Inbound Order Summary page
    Then Clicks customer option by index 0 on Inbound Order Summary page
    And Selects customer option by index 2 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Door Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from start date by index 0 to end date by index 0
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
    When User finds all orders from start date by index 0 to end date by index 0
    And Validates orders are present on Inbound Order Summary page
    And Clicks carrier by index 0 on Inbound Order Summary page
    And Selects carrier by index 3 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    Then Clicks carrier by index 3 on Inbound Order Summary page
    And Selects carrier by index 0 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Status Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from start date by index 0 to end date by index 0
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

  Scenario: Checking Order Filter on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4 to end date by index 4
    And Validates orders are present on Inbound Order Summary page
    Then Select order by index 0 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clear order name on Inbound Order Summary page
    And Select order by index 1 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Summary totals on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4 to end date by index 5
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
    When User finds all orders from start date by index 4 to end date by index 5
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
    When User finds all orders from start date by index 4 to end date by index 5
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
    When User finds all orders from start date by index 0 to end date by index 1
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
    When User finds all orders from start date by index 4 to end date by index 1
    Then Validates orders are present on Inbound Order Summary page
    And Validates Received, Staged, Over and Remainder are present on Inbound Order Summary page with correct color
    And Validates items are present on Inbound Order Summary page

  Scenario: Checking Source option on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4 to end date by index 1
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
    When User finds all orders from start date by index 4 to end date by index 1
    And Validates orders are present on Inbound Order Summary page
    Then Selects Order with index 1 and apply "Receive" Order Option on Inbound Order Summary page
    And Receiving page loads
    And Receiving page contains all web elements
    And Clicks Route Back button on Inbound Order Summary page
    And Checks Order with index 2 on Inbound Order Summary page
    And Clicks Order Option on Inbound Order Summary page
    And Validates Order option "Receive" on Inbound Order Summary page is disabled

  Scenario: Checking Edit option on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 4 to end date by index 1
    And Validates orders are present on Inbound Order Summary page
    And Selects Order with index 1 and apply "Edit" Order Option on Inbound Order Summary page
    And Validates Edit load popup on Inbound Order Summary page
    Then Filling scheduled date by index 2 and scheduled time "5:00" on Edit popup on Inbound Order Summary page
    And Validates scheduled date by index 2 and scheduled time "5:00" on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page
    And Checks Order with index 2 on Inbound Order Summary page
    And Clicks Order Option on Inbound Order Summary page
    And Validates Order option "Edit" on Inbound Order Summary page is disabled

  Scenario: Checking Data option on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from start date by index 4 to end date by index 4
    And Validates orders are present on Inbound Order Summary page
    When Checks Order with index 1 on Inbound Order Summary page
    And Clicks data option on Inbound Order Summary page
    And Validates Enter data screen on Inbound Order Summary page
    And Types temperature by index 0 on Inbound Order Summary page
    Then Types seal number by index 0 on Inbound Order Summary page
    And Clicks Add Product Cancel Button on Inbound Order Summary page
    And Clicks Yes Button on Inbound Order Summary page
    And Checks Order with index 2 on Inbound Order Summary page
    And Validates Data option on Inbound Order Summary page is disabled

  Scenario: Checking Door option on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from start date by index 2 to end date by index 1
    And Validates orders are present on Inbound Order Summary page
    When Checks Order with index 1 on Inbound Order Summary page
    And Clicks door option on Inbound Order Summary page
    And Validates popup Assign door title for Inbound Order Summary
    And Clicks door on Assign door popup on Inbound Order Summary page
    And Clicks door "DR01" on Inbound Order Summary page
    And Clicks Save button on Inbound Order Summary page
    And Validates "Success" notification is displayed on Inbound Order Summary page
    Then Clicks door option on Inbound Order Summary page
    And Validates popup Assign door title for Inbound Order Summary
    And Clicks door on Assign door popup on Inbound Order Summary page
    And Clicks door "DR02" on Inbound Order Summary page
    And Clicks Save button on Inbound Order Summary page
    And Validates "Success" notification is displayed on Inbound Order Summary page
    And Clicks door option on Inbound Order Summary page
    And Validates popup Assign door title for Inbound Order Summary
    And Clicks door on Assign door popup on Inbound Order Summary page
    And Clicks door "DOOR" on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page

  Scenario: Checking Log option on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 4
    And Validates orders are present on Inbound Order Summary page
    Then Selects Order with index 1 and apply "Log" Order Option on Inbound Order Summary page
    And Validates popup Receiver details on Inbound Order Summary page
    And Clicks Add Filter button on Inbound Order Summary page
    And Validates popup Add Filter on Inbound Order Summary page
    And Clicks Ok button on Inbound Order Summary page

  Scenario: Checking Move option on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 4
    And Validates orders are present on Inbound Order Summary page
    Then Selects Order with index 1 and apply "Move" Order Option on Inbound Order Summary page
    And Validates Move popup on Inbound Order Summary page
    And Validates Save Button on Inbound Order Summary page is disabled
    And Types Ship Date by index 1 to move Order to Load on Inbound Order Summary page
    And Types Load name by index 1 to move Order to Load on Inbound Order Summary page
    And Validates Save button is enabled on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page
    And Checks Order with index 2 on Inbound Order Summary page
    And User applies order "Move" option on Inbound Order Summary page
    And Validates Move popup on Inbound Order Summary page
    And Types Ship Date by index 1 to move Order to Load on Inbound Order Summary page
    And Types Load name by index 1 to move Order to Load on Inbound Order Summary page
    And Validates Save button is enabled on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page

  Scenario: Checking Add/Delete Image option on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 0
    And Validates orders are present on Inbound Order Summary page
    Then Selects Order with index 1 and apply "Image" Order Option on Inbound Order Summary page
    And Validates Load Images on Inbound Order Summary page
    And Validates Save and Cancel buttons for Load image on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page

  Scenario: Checking The Linked order on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from start date by index 0 to end date by index 0
    And Validates orders are present on Inbound Order Summary page
    Then Selects order with index 0 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Validates Inbound Order Details Page contains all web elements