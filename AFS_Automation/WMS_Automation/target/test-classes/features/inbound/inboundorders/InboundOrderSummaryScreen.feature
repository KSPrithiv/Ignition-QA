@Inbound @Regression
Feature: Testing of Inbound Orders functionality

  Scenario: Checking Navigate to Inbound Order Summary screen functionality
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And Validates Inbound Order Summary Page contains all web elements

  Scenario: Checking Review on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from "01/01/2018" to "06/01/2022"
    Then Check order with index 0 on Inbound Order Summary page
    And User applies order "Review" option on Inbound Order Summary page
    And Validates Inbound order summary Review page is displayed
  #issue
  Scenario: Checking Product Filter on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds all orders from "01/01/2018" to "06/01/2023"
    And Types Valid product code "200033" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Deletes product on Inbound Order Summary page
    And Types invalid product code "Fr56I8" on Inbound Order Summary page
    And Validates orders are not present on Inbound Order Summary page

  Scenario: Checking Buyer Filter on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2018" to "06/01/2023"
    And Clicks buyer "Select buyer" dropdown on Inbound Order Summary page
    And Selects buyer "MIKEM - Mike - Mover" dropdown on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page
    And Clicks buyer "MIKEM - Mike - Mover" dropdown on Inbound Order Summary page
    And Selects buyer "Select buyer" dropdown on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page

  Scenario: Checking Supplier Name Filter on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2018" to "06/01/2026"
    And Types supplier name "ASD PRODUCE" on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page
    And Cleans supplier name on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page
    And Cleans supplier name on Inbound Order Summary page
    And Types supplier name "Hgr88Jd" on Inbound Order Summary page
    And Validates orders are not present on Inbound Order Summary page
  #issue
  Scenario: Checking Supplier Code Filter on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Types supplier code "10001" on Inbound Order Summary page
    And Validates items are present on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Cleans supplier code on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Types supplier code "Hgr88Jd" on Inbound Order Summary page
    And Validates orders are not present on Inbound Order Summary page

  Scenario: Checking Order Type on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Clicks order type "Select order type" dropdown on Inbound Order Summary page
    And Selects order type "Inbound Transfer" dropdown on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clicks order type "Inbound Transfer" dropdown on Inbound Order Summary page
    And Selects order type "Purchase Order" dropdown on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Owner Filter on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2018" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Clicks "Select owner" option on Inbound Order Summary page
    And Selects "ABC Company" owner option on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Door Filter on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2018" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Clicks "Select door" door option on Inbound Order Summary page
    And Selects "DOOR" door option on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clicks "DOOR" option on Inbound Order Summary page
    And Selects "DR01" door option on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Carrier Filter on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Clicks carrier "Select carrier" on Inbound Order Summary page
    And Selects carrier "Backhaul" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clicks carrier "Backhaul" on Inbound Order Summary page
    And Selects carrier "Inbound Freight Expense" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Status Filter on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "All statuses" on Inbound Order Summary page
    And Selects order status "Ready To Receive" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "Ready To Receive" on Inbound Order Summary page
    And Selects order status "Received Order" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "Received Order" on Inbound Order Summary page
    And Selects order status "Cancelled" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Order Filter on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2020"
    And Validates orders are present on Inbound Order Summary page
    And Select order "R00001000" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clear order name on Inbound Order Summary page
    And Select order "R00001006" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Summary totals on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "All statuses" on Inbound Order Summary page
    And Selects order status "Ready To Receive" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "Ready To Receive" on Inbound Order Summary page
    And Selects order status "All statuses" on Inbound Order Summary page
    And Clicks carrier "Select carrier" on Inbound Order Summary page
    And Selects carrier "Backhaul" on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Clicks carrier "Backhaul" on Inbound Order Summary page
    And Selects carrier "Select carrier" on Inbound Order Summary page
    And Clicks "Select door" door option on Inbound Order Summary page
    And Selects "DOOR" door option on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page

  Scenario: Checking Status change from Received order to ReOpen on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "All statuses" on Inbound Order Summary page
    And Selects order status "Received Order" on Inbound Order Summary page
    And Check order with index 0 on Inbound Order Summary page
    And Clicks change status option on Inbound Order Summary page
    And Validates popup Change status title for Inbound Order Summary page
    And Validates Change status popup with Reopen Order status on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page

  Scenario: Checking Status change from Open to Ready to Receive on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "All statuses" on Inbound Order Summary page
    And Selects order status "Open" on Inbound Order Summary page
    And Check order with index 0 on Inbound Order Summary page
    And Clicks change status option on Inbound Order Summary page
    And Validates popup Change status title for Inbound Order Summary page
    And Validates Change status popup with Ready To Receive Order status on Inbound Order Summary page
    And Validates Change status popup with Cancel Order status on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page

  Scenario: Checking Status change from Ready to Receive to Finish on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Clicks order status "All statuses" on Inbound Order Summary page
    And Selects order status "Ready To Receive" on Inbound Order Summary page
    And Select order "3942" on Inbound Order Summary page
    And Checks Order with index 0 on Inbound Order Summary page
    And Clicks change status option on Inbound Order Summary page
    And Validates popup Change status title for Inbound Order Summary page
    And Validates Change status popup with Finish Receiving Order status on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page

  Scenario: Checking Progress bar colors on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Validates Received, Staged, Over and Remainder are present on Inbound Order Summary page with correct color
    And Validates items are present on Inbound Order Summary page

  Scenario: Checking Source option on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Selects Order with index 1 and apply "Source" Order Option on Inbound Order Summary page
    And Validates Source order screen on Inbound Order Summary page
    And Validates Received, Staged and Remainder are present on Inbound Order Summary Source page with correct color
    And Clicks Route Back button on Inbound Order Summary page

  Scenario: Checking Receive option on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Selects Order with index 1 and apply "Receive" Order Option on Inbound Order Summary page
    And Receiving page loads
    And Receiving page contains all web elements
    And Clicks Route Back button on Inbound Order Summary page
    And Checks Order with index 2 on Inbound Order Summary page
    And Clicks Order Option on Inbound Order Summary page
    And Validates Order option "Receive" on Inbound Order Summary page is disabled

  Scenario: Checking Edit option on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Selects Order with index 1 and apply "Edit" Order Option on Inbound Order Summary page
    And Validates Edit load popup on Inbound Order Summary page
    And Filling scheduled date "11/11/2022" and scheduled time "5:00" on Edit popup on Inbound Order Summary page
    And Validates scheduled date "11/11/2022" and scheduled time "5:00" on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page
    And Checks Order with index 2 on Inbound Order Summary page
    And Clicks Order Option on Inbound Order Summary page
    And Validates Order option "Edit" on Inbound Order Summary page is disabled

  Scenario: Checking Data option on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2010" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Checks Order with index 1 on Inbound Order Summary page
    And Clicks data option on Inbound Order Summary page
    And Validates Enter data screen on Inbound Order Summary page
    And Types "44" temperature on Inbound Order Summary page
    And Types "55" seal number on Inbound Order Summary page
    And Clicks Add Product Cancel Button on Inbound Order Summary page
    And Clicks Yes Button on Inbound Order Summary page
    And Checks Order with index 2 on Inbound Order Summary page
    And Validates Data option on Inbound Order Summary page is disabled

  Scenario: Checking Door option on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2022" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Checks Order with index 1 on Inbound Order Summary page
    And Clicks door option on Inbound Order Summary page
    And Validates popup Assign door title for Inbound Order Summary
    And Clicks door on Assign door popup on Inbound Order Summary page
    And Clicks door "DR01" on Inbound Order Summary page
    And Clicks Save button on Inbound Order Summary page
    And Validates "Success" notification is displayed on Inbound Order Summary page
    And Clicks door option on Inbound Order Summary page
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
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2018" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Selects Order with index 1 and apply "Log" Order Option on Inbound Order Summary page
    And Validates popup Receiver details on Inbound Order Summary page
    And Clicks Add Filter button on Inbound Order Summary page
    And Validates popup Add Filter on Inbound Order Summary page
    And Clicks Ok button on Inbound Order Summary page

  Scenario: Checking Move option on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2018" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Selects Order with index 1 and apply "Move" Order Option on Inbound Order Summary page
    And Validates Move popup on Inbound Order Summary page
    And Validates Save Button on Inbound Order Summary page is disabled
    And Types Ship Date "04/14/2022" to move Order to Load on Inbound Order Summary page
    And Types Load "__20651" to move Order to Load on Inbound Order Summary page
    And Validates Save button is enabled on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page
    And Checks Order with index 2 on Inbound Order Summary page
    And User applies order "Move" option on Inbound Order Summary page
    And Validates Move popup on Inbound Order Summary page
    And Types Ship Date "04/14/2022" to move Order to Load on Inbound Order Summary page
    And Types Load "__20651" to move Order to Load on Inbound Order Summary page
    And Validates Save button is enabled on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page

  Scenario: Checking Add/Delete Image option on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2018" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Selects Order with index 1 and apply "Image" Order Option on Inbound Order Summary page
    And Validates Load Images on Inbound Order Summary page
    And Validates Save and Cancel buttons for Load image on Inbound Order Summary page
    And Clicks Cancel button on Inbound Order Summary page

  Scenario: Checking The Linked order on Inbound Order Summary screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from "01/01/2022" to "06/01/2023"
    And Validates orders are present on Inbound Order Summary page
    And Selects order with index 0 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    And Validates Inbound Order Details Page contains all web elements