#@Outbound @Regression
Feature: Testing of Outbound Load Planning functionality
  @1
  Scenario: Checking Route Weight on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    #And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    When Selects Ship Date by index 0 on Load Planning popup
    Then Clicks Route dropdown on Load Planning popup
    And Selects Route by index 1 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates Route Weight is present

  @2
  Scenario: Checking Right and Left sides of Truck
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
#    And Waits for Outbound Truck Info page to load
    And Validates Route label, Ship Date and Time, Trailer and Door dropdowns, Inbound and Shorts links are present
    And Validates Type label, Positions label, Trailer and Route cubes, Trailer and Route weights are present
    And Validates Trailer Cube is present
    And Validates Route Cube is present
    And Validates Trailer Weight is present
    And Validates Route Weight is present

  @3
  Scenario: Checking Assignments/Pallets of Truck
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
#    And Waits for Outbound Truck Info page to load
    And Validates assignments are present
    And Validates Position and Pallets are present

  @4
  Scenario: Checking Assignment Movement to different Empty position
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
#    And Waits for Outbound Truck Info page to load
    And Validates assignments are present
    And Drag and drop assignment from position "5" to position "4" on Truck Info page

  @5
  Scenario: Checking Assignment movement to different position which already has data in it
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
#    And Waits for Outbound Truck Info page to load
    And Validates assignments are present
    And Drag and drop assignment from position "5" to not empty position "4" on Truck Info page


  @6
  Scenario: Checking Warning Message if Assignments are not released
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
    And Clicks Exit button on Truck Info page
    #code to handle warning message YES/NO to "release Assignments"
 #   And Validates Yes and No buttons are present
 #   And Validates Yes button is active
    And Clicks No button on Warning Message


  @7
  Scenario: Checking Warning message if Assignment Cube/Weight is more than Assignment type Cube/Weight
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

  @8
  Scenario: Checking Warning message if right and left side of Trailer not balanced
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
    #Drag and Drop scenarios are removed from automation task
    #And Drag and drop assignment from position "5" to position "1" on Truck Info page

  @9
  Scenario: Checking Warning message if Route Cube/Weight is more then Trailer cube/weight
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
    And Clicks Exit button on Truck Info page