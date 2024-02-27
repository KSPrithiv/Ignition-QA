#@Outbound @Regression
Feature: Testing of Outbound Summary order Edit option functionality

  @1
  Scenario: Checking Order Edit option functionality
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Outbound Order page
    #And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And Searches for order by index 6 on Outbound Order Summary page
    Then Selects first order on Outbound Order Summary page
    And Select Outbound Order Edit option
    And Validates Edit Order popup
    And Validates Edit Order by index 6
    And Filling scheduled date by index 3 and scheduled time "5:00"
    And Filling scheduled date by index 3 and scheduled time "5:00"
    And Validates scheduled date by index 3 and scheduled time "5:00"
    And Validates Carrier dropdown is displayed
    And Validates Carrier dropdown default option "(None)"
    And Validates Payment type dropdown is displayed
    And User add comments "Test comments"
    And Clicks Save button on Outbound order summary page
    And Validates correct comments "Test comments" are displayed

  @2
  Scenario: Checking Order Release option functionality
#    Given User signs in the application
#    And Main page is loaded
    #And DockManagement Summary Page is validated
#    And Go to Outbound Order page
    And Click Back button on Outbound Order Source page
    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page

    And Searches for order by index 5 on Outbound Order Summary page
    Then Selects order checkbox with index 0 on Outbound Order Summary page
    And Selecting Outbound Order Release option on Outbound Order Summary page
    And Validates popup Release assignment title on Outbound Order Summary page
    And Validates scheduled date and scheduled time are displayed
    And Clicks Save button on Outbound order summary page
    And Validates successful message "Success" on Outbound Order Summary page

  @3
  Scenario: Checking Order Door option functionality
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Outbound Order page
#    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And Clears Account field on Outbound Order Summary page
    And Searches for order by index 5 on Outbound Order Summary page
    Then Selects order checkbox with index 0 on Outbound Order Summary page
    And Selecting Outbound Order DOOR option on Outbound Order Summary page
    And Validates popup Assign doors title on Outbound Order Summary page
    And Selecting Door List "DR01" option on Outbound order summary page
    And Clicks Save button on Outbound order summary page
    And Validates successful message "Success" on Outbound Order Summary page

  @4
  Scenario: Checking Order Data option functionality
#    Given User signs in the application
#    And Main page is loaded
#    #And DockManagement Summary Page is validated
#    And Go to Outbound Order page
#    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And Searches for order by index 5 on Outbound Order Summary page
    Then Selects order checkbox with index 0 on Outbound Order Summary page
    And Selecting Outbound Order Data option on Outbound Order Summary page
    And Validates Order Data page is displayed
    And Click Cancel button on Outbound Order Summary page
    And Clears Search on Outbound Order Summary page
    And Filling start date by index 2 on Outbound Order Summary page
#    And Selects order checkbox with index 2 on Outbound Order Summary page
#    And Selects order checkbox with index 3 on Outbound Order Summary page
#    And Selects order checkbox with index 4 on Outbound Order Summary page
    And Clicks Order option on Outbound Order Summary page
    And Validates "Data" option is not active

  @5
  Scenario: Checking Order Log option functionality
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Outbound Order page
#    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And Searches for order by index 5 on Outbound Order Summary page
    Then Selects order checkbox with index 0 on Outbound Order Summary page
    And Selecting Outbound Order Log option on Outbound Order Summary page
    And Validates popup Shipper title on Outbound Order Summary page
    And Validates popup Shipper columns on Outbound Order Summary page
    And Clicks Ok on Outbound Order Summary page

  @6
  Scenario: Checking Order Source option functionality
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Outbound Order page
#    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And Searches for order by index 5 on Outbound Order Summary page
    Then Selects order checkbox with index 0 on Outbound Order Summary page
    And Selecting Outbound Order Source option on Outbound Order Summary page
    And Validates popup Source columns on Outbound Order Summary page
    And Click Back button on Outbound Order Source page
    And Clear order input on Outbound Order Summary page
#    And Selects order checkbox with index 1 on Outbound Order Summary page
#    And Selects order checkbox with index 2 on Outbound Order Summary page
#    And Selects order checkbox with index 3 on Outbound Order Summary page
#    And Selects order checkbox with index 4 on Outbound Order Summary page
    And Clicks Order option on Outbound Order Summary page
    And Validates "Source" option is not active

  @7
  Scenario: Checking Order Move option functionality
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Outbound Order page
#    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And Searches for order by index 5 on Outbound Order Summary page
    Then Selects order checkbox with index 0 on Outbound Order Summary page
    And Selecting Outbound Order Move option on Outbound Order Summary page
    And Validates Move popup on Outbound Order Summary page
    And Validates Save button is disabled on Outbound Order Summary page
    And Types "12" route on Move popup
    And Validates Save button is enabled on Outbound Order Summary page
    And Clicks Save button on Outbound order summary page

  @8
  Scenario: Checking Order Image option functionality
#    Given User signs in the application
#    And Main page is loaded
#    #And DockManagement Summary Page is validated
#    And Go to Outbound Order page
#    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    Then Selects order checkbox with index 0 on Outbound Order Summary page
    And Selecting Outbound Order Image option on Outbound Order Summary page
    And Validates Image upload is displayed
    And Click Cancel button on Outbound Order Summary page
    And Waits for Outbound Order Summary page to load
    And Selects order checkbox with index 1 on Outbound Order Summary page
    And Clicks Order option on Outbound Order Summary page
    And Validates "Image" option is not active

  @9
  Scenario: Checking Order Review option functionality
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Outbound Order page
#    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    Then Selects order checkbox with index 0 on Outbound Order Summary page
    And Selecting Outbound Order Review option on Outbound Order Summary page
    And Validates Review page is displayed
    And Validates Review page table is displayed
    And Click Cancel button on Outbound Order Summary page