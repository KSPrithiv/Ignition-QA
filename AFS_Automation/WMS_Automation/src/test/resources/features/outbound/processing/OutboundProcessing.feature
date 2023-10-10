@Processing @Regression
Feature: Testing of Receiving functionality
  Scenario: Checking Processing orders functionality
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Outbound Processing page
    And Wait for Processing page to load
    And Processing page contains all web elements
    And Validates default processing date on Processing page
    And User selects processing date "01/25/2022" on Processing page
    And Validates orders list on Processing page is displayed
    And Validates order section is displayed on Processing page
    And Validates all orders section is selected on Processing page
    And Validates date "01/25/2022" value is correct on Processing page
    And Validates order date "1/25/2022" on Processing page
    And User goes to Unbatched on Processing page
    And User selects processing date "01/24/2022" on Processing page
    And Validates order date "1/24/2022" on Processing page
    And Validates statuses colors on Processing page
    And Validates orders number in not "0" on Processing page
    And Validates orders list on Processing page is displayed
    And User selects processing date "01/24/2022" on Processing page
    And Validates order details on Processing page
    And Closes order details on Processing page

  Scenario: Checking Processing orders date filtering
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Outbound Processing page
    And Wait for Processing page to load
    And Processing page contains all web elements
    And Validates current date is correct on Processing page
    And User selects calendar on Processing page
    And Validates calendar is displayed on Processing page
    And User selects processing date "01/25/2022" on Processing page
    And User goes to All Orders on Processing page
    And Validates order details on Processing page
    And Closes order details on Processing page
    And User selects processing date "01/17/2022" on Processing page
    And User goes to Unbatched on Processing page
    And Validates order details on Processing page
    And Closes order details on Processing page
    And Validates batch list is displayed on Processing page

  Scenario: Checking Add processing new batch
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Outbound Processing page
    And Wait for Processing page to load
    And Processing page contains all web elements
    And User clicks add button on Processing page
    And Validate Add Allocation Batch page is displayed
    And Validates Add Allocation Batch page title is correct
    And User clicks on batch type
    And Validates Batch Type "PD PICKS" is displayed
    And Validates Batch Type "(Select batch type)" is displayed
    And User types batch code
    And Validates batch code value
    And Selects batch type PD PICKS
    And Clicks Save button
    And Validates Successful title "Success" and message "Batch created"
    And Validate batch is displayed on Processing page
    And User clicks add button on Processing page
    And Validate Add Allocation Batch page is displayed
    And Validates Add Allocation Batch page title is correct
    And Clicks Save button
    And Validate batch required error popup that batch is required on Processing page
    And Clicks Ok on Processing page
    And User types invalid batch code "Fh j5"
    And Validates invalid batch code "Fh j5"
    And Selects batch type PD PICKS
    And Clicks Save button
    And Validate batch name error popup that batch is required on Processing page
    And Clicks Ok on Processing page
    And Clicks Cancel on Add Allocation Batch page

  Scenario: Checking processing drag and drop batch
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Outbound Processing page
    And Wait for Processing page to load
    And Processing page contains all web elements
    And User selects processing date "01/17/2022" on Processing page
    And User clicks add button on Processing page
    And User clicks on batch type
    And Validates Batch Type "PD PICKS" is displayed
    And Validates Batch Type "(Select batch type)" is displayed
    And User types batch code
    And Validates batch code value
    And Selects batch type PD PICKS
    And Clicks Save button
    And Validates Successful title "Success" and message "Batch created"
    And Validate batch is displayed on Processing page
    And User selects batch by name on Processing page
    And Validate batch is selected on Processing page
    And User goes to Unbatched on Processing page
    And Check Unbatched Order with index 0 on Processing page
    And Validate Unbatched Order with index 0 is checked on Processing page
    And User selects processing date "01/26/2021" on Processing page
    And User clicks add button on Processing page
    And User clicks on batch type
    And Validates Batch Type "PD PICKS" is displayed
    And Validates Batch Type "(Select batch type)" is displayed
    And User types batch code
    And Selects batch type PD PICKS
    And Clicks Save button
    And Validates Successful title "Success" and message "Batch created"
    And User goes to All Orders on Processing page
    And Check All Orders By Order index 0 on Processing page
    And Drag and drop order by order index 0 on Processing page
    And Validates Successful title "Success" and message "Orders moved to batch"

  Scenario: Checking processing Delete batch
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Outbound Processing page
    And Wait for Processing page to load
    And Processing page contains all web elements
    And Validate batch section is displayed on Processing page
    And User clicks add button on Processing page
    And User clicks on batch type
    And Validates Batch Type "PD PICKS" is displayed
    And Validates Batch Type "(Select batch type)" is displayed
    And User types batch code
    And Validates batch code value
    And Selects batch type PD PICKS
    And Clicks Save button
    And Validates Successful title "Success" and message "Batch created"
    And Validate batch is displayed on Processing page
    And User selects batch by name on Processing page
    And Validate batch is selected on Processing page
    And Clicks delete button on Processing page
    And Validates batch is deleted on Processing page
    And Clicks Yes button on Processing page
    And Validates Successful title "Success" and message "Batch deleted"

  Scenario: Checking processing Filter batch
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Outbound Processing page
    And Wait for Processing page to load
    And Processing page contains all web elements
    And User clicks filtering order on Processing page
    And Validates Change View Parameters page
    And Validates start date is displayed on Change View Parameters page
    And Validates end date is displayed on Change View Parameters page
    And Validates Change View Parameters page title
    And Validates Ok button is active
    And User clicks Source option on Change View Parameters page
    And Validates source Default value
    And Validates other Source options on Change View Parameters page
    And Clicks Cancel on Change View Parameters page
    And User clicks filtering order on Processing page
    And Selects Source Account on Change View Parameters page
    And Enters Code "001001" on Change View Parameters page
    And Selects Start Date "2021-01-01" on Change View Parameters page
    And Clicks Ok on Change View Parameters page
    And Wait for Processing page to load
    And Validates filtered order details: start date "2022-01-01", source "001001", year "2022" on Processing page
    And User clicks filtering order on Processing page
    And Enters order "10616" on Change View Parameters page
    And Selects Start Date "01/01/2021" on Change View Parameters page
    And Clicks Ok on Change View Parameters page
    And User clicks filtering order on Processing page
    And Validates Change View Parameters page
    And Validates start date is displayed on Change View Parameters page
    And Validates end date is displayed on Change View Parameters page
    And Validates Change View Parameters page title
    And User clicks Source option on Change View Parameters page
    And Validates source Default value
    And Validates other Source options on Change View Parameters page
    And Clicks Cancel on Change View Parameters page
    And User clicks filtering order on Processing page
    And Selects Source Account on Change View Parameters page
    And Clears order on Change View Parameters page
    And Enters Code that does not exist in DB on Change View Parameters page
    And Clicks Ok on Change View Parameters page
    And Validates filtered order contains No Record on Processing page

  Scenario: Checking processing Grid details
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Outbound Processing page
    And Wait for Processing page to load
    And Validates statuses colors on Processing page

  Scenario: Checking Unprocessing batch
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Outbound Processing page
    And Wait for Processing page to load
    And Processing page contains all web elements
    And Validates default processing date on Processing page
    And User selects processing date "01/24/2022" on Processing page
    And Validates orders list on Processing page is displayed
    And Validates order section is displayed on Processing page
    And Validates all orders section is selected on Processing page
    And User goes to Batches on Processing page
    And User selects batch "NorthSanSide" on Processing page
    And Clicks Unprocess button on Processing page
    And Validates Yes and No buttons are displayed on Unprocess batch popup
    And Validates Unprocess batch popup text
    And Clicks Yes button on Processing page
    And Validates "Unprocessing complete" notification is displayed on Processing page
    And Clicks Unprocess button on Processing page
    And Validates Yes and No buttons are displayed on Unprocess batch popup
    And Validates Unprocess batch popup text
    And Clicks No button on Processing page
    And Check Unbatched Order with index 0 on Processing page
    And Check Unbatched Order with index 1 on Processing page
    And Clicks Unprocess button on Processing page
    And Clicks Yes button on Processing page
    And Validates "Unprocessing complete" notification is displayed on Processing page
    And Clicks Unprocess button on Processing page
    And Clicks Yes button on Processing page
    And Validates "Unprocessing complete" notification is displayed on Processing page
    # Unprocessing empty batch file
    And User goes to All Orders on Processing page
    And Clicks Unprocess button on Processing page
    And Validate batch required error popup that batch is required on Processing page