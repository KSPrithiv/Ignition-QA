@Outbound @Regression
Feature: Testing of Outbound Load Planning functionality

  @1
  Scenario: Checking Exit label and icon displayed on the Truck Info
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    When Selects Ship Date by index 0 on Load Planning popup
    Then Clicks Route dropdown on Load Planning popup
    And Selects Route by index 0 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Validates Exit button is present
    #And Clicks Exit button on Truck Info page

  @2
  Scenario: Checking Warning message if Assignments are not printed
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Outbound Load Planning page
#    And Waits for Outbound Load Planning page to load
#    When Selects Ship Date by index 0 on Load Planning popup
#    Then Clicks Route dropdown on Load Planning popup
#    And Selects Route by index 0 for Load Planning
#    And Clicks Done button on Load Planning page
#    And Waits for Outbound Truck Info page to load
#    And User gets all assignments from Truck diagram
#    And Clicks Reprocess button on Truck Info page
#    And Clicks Yes button on Rebuilding Assignments popup
#    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page
    #code to handle warning message YES/NO to "release Assignments"
    And Validates Yes and No buttons are present
    And Validates Yes button is active
    And Clicks Yes button on Warning Message

  @3
  Scenario: Checking Load Planning - split product pick task
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Outbound Load Planning page
#    And Waits for Outbound Load Planning page to load
    When Selects Ship Date by index 0 on Load Planning popup
    Then Clicks Route dropdown on Load Planning popup
    And Selects Route by index 0 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Select first assignment on Truck Info page
    And Validates First Assignment popup is present
    And Validates Assignment details on popup

  @4
  Scenario: Checking Load Planning - split product pick task assignment details edit
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Outbound Load Planning page
#    And Waits for Outbound Load Planning page to load
#    When Selects Ship Date by index 0 on Load Planning popup
#    Then Clicks Route dropdown on Load Planning popup
#    And Selects Route by index 0 for Load Planning
#    And Clicks Done button on Load Planning page
#    And Waits for Outbound Truck Info page to load
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

  @5
  Scenario: Checking Load Planning - split product pick task edit 003
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Outbound Load Planning page
#    And Waits for Outbound Load Planning page to load
#    When Selects Ship Date by index 0 on Load Planning popup
#    Then Clicks Route dropdown on Load Planning popup
#    And Selects Route by index 0 for Load Planning
#    And Clicks Done button on Load Planning page
#    And Waits for Outbound Truck Info page to load
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

  @6
  Scenario: Checking Load Planning - Recalculate based on selected Assignments
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Outbound Load Planning page
#    And Waits for Outbound Load Planning page to load
#    When Selects Ship Date by index 0 on Load Planning popup
#    Then Clicks Route dropdown on Load Planning popup
#    And Selects Route by index 0 for Load Planning
#    And Clicks Done button on Load Planning page
#    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Clicks assignment popup header on Truck Info page
    And Validates Assignment is selected with the blue border on Split Task