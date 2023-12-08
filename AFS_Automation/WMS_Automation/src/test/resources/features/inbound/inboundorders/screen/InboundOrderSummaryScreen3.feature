@Inbound @Regression
Feature: Testing of Inbound Orders functionality
  Scenario: Checking Data option on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And User finds all orders from start date by index 4
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
    And User finds all orders from start date by index 2
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
    When User finds all orders from start date by index 0
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
    When User finds all orders from start date by index 0
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

  Scenario: Move Order to a Load on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds orders from date by index 4 on Inbound Order summary page
    Then Checks Order with index 0 on Inbound Order Summary page
    And Checks Order with index 1 on Inbound Order Summary page
    And User applies order "Move" option on Inbound Order Summary page
    And Types Load name by index 2 on Inbound Order Details page
    And Validates Save button is enabled on Inbound Order Details page
    And Clicks Cancel button on Inbound Order Details page
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates default values of Start Date and End date on Inbound Load Summary page

  Scenario: Check Searching on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds orders from date by index 4 on Inbound Order summary page
    And Types Valid product code by index 1 on Inbound Order Summary page
    And Validates orders are present on Inbound Order Summary page
    Then Deletes product on Inbound Order Summary page
    And Types invalid product code "Ht5frK" on Inbound Order Summary page

  Scenario: Check Uploading images on Inbound Order Summary screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    When User finds orders from date by index 4 on Inbound Order summary page
    And Selects order with index 1 on Inbound Order Summary page
    Then Validates Images Button is present on Inbound Order Details page
    And Clicks Images button on Inbound Order Summary page
    And Validates Load Images on Inbound Order Details page