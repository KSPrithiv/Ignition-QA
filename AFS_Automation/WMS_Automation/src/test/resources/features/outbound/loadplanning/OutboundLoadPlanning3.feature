@Outbound @Regression
Feature: Testing of Outbound Load Planning functionality
   Scenario: Checking Route Weight on Outbound Truck Info page
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
    Then Selects Route by index 4 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates Route Weight is present

  Scenario: Checking Right and Left sides of Truck
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
    Then Selects Route by index 4 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates Route label, Ship Date and Time, Trailer and Door dropdowns, Inbound and Shorts links are present
    And Validates Type label, Positions label, Trailer and Route cubes, Trailer and Route weights are present
    And Validates Trailer Cube is present
    And Validates Route Cube is present
    And Validates Trailer Weight is present
    And Validates Route Weight is present

  Scenario: Checking Assignments/Pallets of Truck
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
    Then Selects Route by index 4 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates assignments are present
    And Validates Position and Pallets are present

  Scenario: Checking Assignment Movement to different Empty position
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
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates assignments are present
    And Drag and drop assignment from position "5" to position "4" on Truck Info page

  Scenario: Checking Assignment movement to different position which already has data in it
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
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates assignments are present
    And Drag and drop assignment from position "5" to not empty position "4" on Truck Info page

  Scenario: Checking Warning Message if Assignments are not released
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
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page
    And Validates Yes and No buttons are present
    And Validates Yes button is active
    And Clicks Yes button on Warning Message

  @issue
  Scenario: Checking Warning message if Assignment Cube/Weight is more than Assignment type Cube/Weight
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
    And Deletes cookies on application
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
 #   And Clicks Exit button on Truck Info pageAnd Validates Warning Message popup content for Exit button
 #   And Validates Warning Message that Assignment cube and weight exceeds max cube and weight for Exit button
 #   And Clicks No button on Warning Message

  @issue
  Scenario: Checking Warning message if right and left side of Trailer not balanced
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
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Drag and drop assignment from position "5" to position "1" on Truck Info page
  #  And Clicks Yes button on Move Assignment
  #  And Clicks Exit button on Truck Info page
 #   And Validates Warning Message 'Right and left sides of trailer are not balanced.' for Exit button

  @issue
  Scenario: Checking Warning message if Route Cube/Weight is more then Trailer cube/weight
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
    Then Selects Route by index 6 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page
  #  And Validates Warning Message popup content for Exit button
    # Should display message “Route cube/weight exceeds trailer cube/weight. Continue?” with Yes/No buttons.
    #Should default to YES
    #Note: Should display this message only if the route cube/Weight exceeds the trailer cube/weight.
    # User can identify this by seeing the values of labels Route cube and Route weight in truck info,
    # if any of those are in RED then system should display this message.