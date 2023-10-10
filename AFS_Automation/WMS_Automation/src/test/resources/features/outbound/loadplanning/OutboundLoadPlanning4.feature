@Outbound @Regression
Feature: Testing of Outbound Load Planning functionality
  Scenario: Checking Exit label and icon displayed on the Truck Info
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    And Deletes cookies on application
    When Selects Ship Date by index 6 on Load Planning popup
    And Deletes cookies on application
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Validates Exit button is present
    And Clicks Exit button on Truck Info page

  @issue
  Scenario: Checking Warning message if Assignments are not printed
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    And Deletes cookies on application
    When Selects Ship Date by index 6 on Load Planning popup
    And Deletes cookies on application
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page
    # Should display message “Print pick labels?” Yes/No.
    # Note: If the following conditions are true
    #1. Pick labels are configured under label rule, 2. Assignment type configured for print pick labels set to on assignment release,
    #3. Assignments released,
    #4. and labels not already printed,
    # Should not display message, if Pick labels not configured under label rule, irrespective of other conditions.
   # Should not display the message if, Assignments are not released.
   # Should not display the message if the assignments are already printed.
   # YES ->   Assignments should be printed sucessfully, only the assignmnet belongs to the Assignment types which are configured for On release assignmnet.

  Scenario: Checking Load Planning - split product pick task
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    And Deletes cookies on application
    When Selects Ship Date by index 6 on Load Planning popup
    And Deletes cookies on application
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Select first assignment on Truck Info page
    And Validates First Assignment popup is present
    And Validates Assignment details on popup

  Scenario: Checking Load Planning - split product pick task assignment details edit
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    And Deletes cookies on application
    When Selects Ship Date by index 6 on Load Planning popup
    And Deletes cookies on application
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Select first assignment on Truck Info page
    And Validates First Assignment popup is present
    And Validates Assignment details on popup
    And Clicks edit icon for first assignment on Assignments popup
    And Validates Split task popup displayed
    And Clicks decrease quantity on Split task popup
    And Clicks Save button on Split task popup
    And Validates "Reason is required." notification is displayed on Split Task
    And Clicks reason dropdown on Split task popup
    And Selects reason "Short Order" from dropdown on Split task popup
    And Clicks Save button on Split task popup
    And Validates "Success" notification is displayed for Exit Load Planning

  Scenario: Checking Load Planning - split product pick task edit 003
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    And Deletes cookies on application
    When Selects Ship Date by index 6 on Load Planning popup
    And Deletes cookies on application
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Select first assignment on Truck Info page
    And Validates First Assignment popup is present
    And Clicks edit icon for first assignment on Assignments popup
    And Validates Split task popup displayed
    And Clicks decrease quantity on Split task popup
    And Clicks Save button on Split task popup
    And Clicks reason dropdown on Split task popup
    And Selects reason "Short Order" from dropdown on Split task popup
    And Clicks Save button on Split task popup

  Scenario: Checking Load Planning - Recalculate based on selected Assignments
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    And Deletes cookies on application
    When Selects Ship Date by index 6 on Load Planning popup
    And Deletes cookies on application
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Clicks assignment popup header on Truck Info page
    And Validates Assignment is selected with the blue border on Split Task