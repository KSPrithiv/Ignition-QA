@Outbound @Regression
Feature: Testing of Outbound Load Planning functionality
  Scenario: Checking Trailer type functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And Validates Type label and Type value are present
    And Validates Trailer Type value is not empty

  Scenario: Checking Changing Ship date/time functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    When Selects Ship Date by index 0 on Load Planning popup
    Then Clicks Route dropdown on Load Planning popup
    And Selects Route by index 1 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Validates that Ship date and time displayed on Truck Info Page
    And Type Ship Date by index 5 on Truck Info page
    And Validates change Ship Date notification
    And Clicks No button on Change Ship Time popup

  Scenario: Checking Trailer in functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And Clicks Trailer dropdown on Truck Info page
    And Validates Truck Info trailers exist

  Scenario: Checking Door functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And Deletes cookies on application
    And Clicks Door dropdown on Truck Info page
    And Selects door "DR01" on Truck Info page
    And Clicks Door dropdown on Truck Info page
    And Selects door "DOOR" on Truck Info page
    And Clicks Yes button on Change Door popup

  Scenario: Checking Inbound functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And Validates Inbound link is present
    And Clicks Inbound on Truck Info page
    And Validates Expected inbound popup is displayed
    And Validates Expected inbound table is displayed
    And Clicks OK button on Expected inbound popup

  Scenario: Checking Shorts functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And Validates Shorts link is present
    And Clicks Shorts on Truck Info page
    And Validates Shorts popup is displayed
    And Validates Shorts table is displayed
    And Clicks OK button on Shorts popup

  Scenario: Checking Positions and Pallets on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And Validates Position and Pallets are present

  Scenario: Checking Trailer Cube on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And Validates Trailer Cube is present

  Scenario: Checking Route Cube on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And Validates Route Cube is present

  Scenario: Checking Trailer Weight on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And Validates Trailer Weight is present