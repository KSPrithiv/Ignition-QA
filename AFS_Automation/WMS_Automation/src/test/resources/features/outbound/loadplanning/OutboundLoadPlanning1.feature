@Outbound @Regression
Feature: Testing of Outbound Load Planning functionality
  Scenario: Checking Load Planning login screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    When Selects Ship Date by index 0 on Load Planning popup
    Then Clicks Route dropdown on Load Planning popup
    And Selects Route by index 1 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Clicks Trailer dropdown on Truck Info page
    And Validates Truck Info trailers exist
    And Selects random trailer on Truck Info page

  Scenario: Checking Truck top information
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    When Selects Ship Date by index 0 on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    Then Selects Route by index 1 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Validates Exit, Work, Edit, Reprocess, Recalculate and Key buttons are present
    And Clicks Truck Info Arrow button
    And Validates Exit, Work, Edit, Reprocess, Recalculate and Key buttons are not present

  Scenario: Checking Exit information
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    When Selects Ship Date by index 0 on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    Then Selects Route by index 1 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page

  Scenario: Checking Release functionality when click on Exit button
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Deletes cookies on application
    When Selects Ship Date by index 0 on Load Planning popup
    Then Clicks Route dropdown on Load Planning popup
    And Selects Route by index 1 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page

  Scenario: Checking work option functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Deletes cookies on application
    When Selects Ship Date by index 0 on Load Planning popup
    Then Clicks Route dropdown on Load Planning popup
    And Selects Route by index 1 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Work button on Truck Info page
    And Waits for Outbound Assignments page to load
    And Validates Assignments page title is correct
    And Clicks Back button on Assignments page
    And Waits for Outbound Truck Info page to load

  Scenario: Checking back functionality on Outbound Assignments page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Deletes cookies on application
    When Selects Ship Date by index 0 on Load Planning popup
    Then Clicks Route dropdown on Load Planning popup
    And Selects Route by index 1 for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And User gets all assignments from Truck diagram
    And Clicks Work button on Truck Info page
    And Waits for Outbound Assignments page to load
    And Validates Assignments page title is correct
    And Clicks Back button on Assignments page
    And Waits for Outbound Truck Info page to load
    And Validates Exit, Work, Edit, Reprocess, Recalculate and Key buttons are present
    And Validates Route label, Ship Date and Time, Trailer and Door dropdowns, Inbound and Shorts links are present
    And Validates Type label, Positions label, Trailer and Route cubes, Trailer and Route weights are present
    And Validates Truck diagram with details is displayed

  Scenario: Checking Edit functionality on Outbound Truck Info page
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
    And Clicks Edit button on Truck Info page
    And Validates Edit route fields popup is displayed
    And Validates Edit Form Control is displayed
    And Validates Save and Cancel buttons are displayed on Truck Info Page
    And Clicks Save button on Edit Route popup

  Scenario: Checking Reprocess functionality on Outbound Truck Info page
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
    And Validates Yes and No buttons are present
    And Clicks Yes button on Rebuilding Assignments popup
    And Clicks Ok button on Truck Info
    And Validates Truck diagram with details is displayed
    And Clicks Reprocess button on Truck Info page
    And Validates Yes and No buttons are present
    And Clicks No button on Warning Message
    And Validates Exit, Work, Edit, Reprocess, Recalculate and Key buttons are present
    And Validates Route label, Ship Date and Time, Trailer and Door dropdowns, Inbound and Shorts links are present
    And Validates Type label, Positions label, Trailer and Route cubes, Trailer and Route weights are present
    And Validates Truck diagram with details is displayed

  Scenario: Checking Key functionality on Outbound Truck Info page
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
    And Clicks Key button on Truck Info page
    And Validates Pallet key popup

  Scenario: Checking Change Route functionality on Outbound Truck Info page
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
    And Clicks Edit button on Truck Info page
    And Validates Edit route fields popup is displayed
    And Validates Save and Cancel buttons are displayed on Truck Info Page
    And Clicks Save button on Edit Route popup
    And Clicks Edit button on Truck Info page
    And Edit route "JUNE292"
    And Clicks Save button on Edit Route popup
    And Clicks Edit button on Truck Info page
    And Edit route by index 4
    And Clicks Save button on Edit Route popup