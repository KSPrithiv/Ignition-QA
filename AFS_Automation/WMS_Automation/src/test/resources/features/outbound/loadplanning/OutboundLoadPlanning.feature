@Outbound @Regression
Feature: Testing of Outbound Load Planning functionality

  Scenario: Checking Load Planning login screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "05/24/2023" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "ROUTE1" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Clicks Trailer dropdown on Truck Info page
    And Validates Truck Info trailers exist
    And Selects random trailer on Truck Info page
    And Validates Change trailer popup
    And Clicks No button on Change trailer popup

  Scenario: Checking Truck top information
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Validates Exit, Work, Edit, Reprocess, Recalculate and Key buttons are present
    And Clicks Truck Info Arrow button
    And Validates Exit, Work, Edit, Reprocess, Recalculate and Key buttons are not present

  Scenario: Checking Exit information
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page
    And Validates Warning Message popup content for Exit button
    And Validates Yes and No buttons are present
    And Validates Yes button is active
    And Validates Warning Message popup content for Exit button
    And Clicks Yes button on Warning Message
    And Validates Release assignments notification
    And Validates Yes button is active
    And Clicks Yes button on Warning Message

  Scenario: Checking Release functionality when click on Exit button
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page
    And Validates Warning Message popup content for Exit button
    And Validates Yes and No buttons are present
    And Validates Yes button is active
    And Clicks No button on Warning Message
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page
    And Validates Warning Message popup content for Exit button
    And Clicks Yes button on Warning Message
    And Validates Release assignments notification
    And Validates Yes and No buttons are present
    And Validates Yes button is active
    And Clicks Yes button on Warning Message
    And Validates "Assignment(s) released successfully" notification is displayed for Exit Load Planning
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed

  Scenario: Checking work option functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Work button on Truck Info page
    And Waits for Outbound Assignments page to load
    And Validates Assignments page title is correct
    And Validates table with assignments exist
    And Validates that assignments in truck and assignments in Work queue are matched
    And Clicks Back button on Assignments page
    And Waits for Outbound Truck Info page to load
    And Validates that Route "JUNE29" for Truck Info is correct

  Scenario: Checking back functionality on Outbound Assignments page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And User gets all assignments from Truck diagram
    And Clicks Work button on Truck Info page
    And Waits for Outbound Assignments page to load
    And Validates Assignments page title is correct
    And Validates table with assignments exist
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
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Clicks Edit button on Truck Info page
    And Validates Edit route fields popup is displayed
    And Validates Edit Form Control is displayed
    And Validates Edit Form Control Input "JUNE29" value is correct
    And Validates Save and Cancel buttons are displayed on Truck Info Page
    And Clicks Save button on Edit Route popup
    And Validates "Success" notification is displayed for Edit Route
    And Clicks Edit button on Truck Info page
    And Validates Edit route fields popup is displayed
    And Validates Edit Form Control Input "JUNE29" value is correct
    And Clicks Save button on Edit Route popup
    And Validates "Success" notification is displayed for Edit Route

  Scenario: Checking Reprocess functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Validates Rebuilding assignments popup is displayed
    And Validates Rebuilding Assignments is displayed
    And Validates Yes and No buttons are present
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Validates Truck diagram with details is displayed
    And Clicks Reprocess button on Truck Info page
    And Validates Rebuilding assignments popup is displayed
    And Validates Rebuilding Assignments is displayed
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
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Key button on Truck Info page
    And Validates Pallet key popup

  Scenario: Checking Change Route functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Clicks Edit button on Truck Info page
    And Validates Edit route fields popup is displayed
    And Validates Edit Form Control is displayed
    And Validates Edit Form Control Input "JUNE29" value is correct
    And Validates Save and Cancel buttons are displayed on Truck Info Page
    And Clicks Save button on Edit Route popup
    And Validates "Success" notification is displayed for Edit Route
    And Clicks Edit button on Truck Info page
    And Edit route "JUNE292"
    And Clicks Save button on Edit Route popup
    And Validates "Success" notification is displayed for Edit Route
    And Clicks Edit button on Truck Info page
    And Validates Edit Form Control Input "JUNE29" value is correct
    And Edit route "JUNE29"
    And Clicks Save button on Edit Route popup
    And Validates "Success" notification is displayed for Edit Route

  Scenario: Checking Trailer type functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates Type label and Type value are present
    And Validates Trailer Type value is not empty

  Scenario: Checking Changing Ship date/time functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Validates that Ship date and time displayed on Truck Info Page
    And Type "06/30/2022" Ship Date on Truck Info page
    And Validates change Ship Date notification
    And Clicks Yes button on Change Ship Date popup
    And Validates Ship Date "06/30/2022" value
    And Type "06/29/2022" Ship Date on Truck Info page
    And Validates change Ship Date notification
    And Clicks Yes button on Change Ship Date popup
    And Validates Ship Date "06/29/2022" value
    And Type "11:10 AM" Ship Time on Truck Info page
    And Validates change Ship Time notification
    And Clicks Yes button on Change Ship Time popup
    And Validates Ship Time "11:10 AM" value

  Scenario: Checking Trailer in functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Clicks Trailer dropdown on Truck Info page
    And Validates Truck Info trailers exist

  Scenario: Checking Door functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Clicks Door dropdown on Truck Info page
    And Selects door "DOOR01" on Truck Info page
    And Validates change Door notification
    And Clicks Yes button on Change Door popup
    And Validates Door "DOOR01" value
    And Clicks Door dropdown on Truck Info page
    And Selects door "DOOR" on Truck Info page
    And Validates change Door notification
    And Clicks Yes button on Change Door popup
    And Validates Door "DOOR" value

  Scenario: Checking Inbound functionality on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
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
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
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
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates Position and Pallets are present

  Scenario: Checking Trailer Cube on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates Trailer Cube is present

  Scenario: Checking Route Cube on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates Route Cube is present

  Scenario: Checking Trailer Weight on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates Trailer Weight is present

   Scenario: Checking Route Weight on Outbound Truck Info page
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates Route Weight is present
    And Validates Route Weight is displayed in RED color if Route Weight is greater than Trailer Weight

  Scenario: Checking Right and Left sides of Truck
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
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
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates assignments are present
    And Validates Position and Pallets are present

  Scenario: Checking Assignment Movement to different Empty position
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates assignments are present
    And Drag and drop assignment from position "1" to position "5" on Truck Info page
    And Validates Move to new position notification
    And Validates Yes and No buttons are displayed
    And Clicks No button on Move Assignment
    And Drag and drop assignment from position "3" to position "12" on Truck Info page
    And Validates Move to new position notification
    And Clicks Yes button on Move Assignment

  Scenario: Checking Assignment movement to different position which already has data in it
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Waits for Outbound Truck Info page to load
    And Validates assignments are present
    And Drag and drop assignment from position "1" to not empty position "7" on Truck Info page
    And Validates Move to new position notification
    And Validates Yes and No buttons are displayed
    And Clicks No button on Move Assignment
    And Drag and drop assignment from position "1" to not empty position "7" on Truck Info page
    And Validates Move to new position notification
    And Clicks Yes button on Move Assignment
    And Drag and drop assignment from position "5" to position "1" on Truck Info page
    And Validates Move to new position notification
    And Clicks Yes button on Move Assignment

  Scenario: Checking Warning Message if Assignments are not released
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page
    And Validates Warning Message popup content for Exit button
    And Validates Yes and No buttons are present
    And Validates Yes button is active
    And Clicks Yes button on Warning Message
    And Validates Release assignments notification
    And Clicks Yes button on Warning Message
    And Validates "Assignment(s) released successfully" notification is displayed for Exit Load Planning
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Exit button on Truck Info page
    And Validates Warning Message popup content for Exit button
    And Validates Yes and No buttons are present
    And Validates Yes button is active
    And Clicks No button on Warning Message
    And Waits for Outbound Truck Info page to load

  Scenario: Checking Warning message if Assignment Cube/Weight is more than Assignment type Cube/Weight
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page
    And Validates Warning Message popup content for Exit button
    And Validates Warning Message that Assignment cube and weight exceeds max cube and weight for Exit button
    And Clicks No button on Warning Message

  Scenario: Checking Warning message if right and left side of Trailer not balanced
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Drag and drop assignment from position "2" to position "9" on Truck Info page
    And Clicks Yes button on Move Assignment
    And Clicks Exit button on Truck Info page
    And Validates Warning Message 'Right and left sides of trailer are not balanced.' for Exit button
    And Clicks No button on Warning Message
    And Drag and drop assignment from position "9" to position "2" on Truck Info page
    And Clicks Yes button on Move Assignment

  @todo
  Scenario: Checking Warning message if Route Cube/Weight is more then Trailer cube/weight
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Clicks Exit button on Truck Info page
    And Validates Warning Message popup content for Exit button
    # Should display message “Route cube/weight exceeds trailer cube/weight. Continue?” with Yes/No buttons.
    #Should default to YES
    #Note: Should display this message only if the route cube/Weight exceeds the trailer cube/weight.
    # User can identify this by seeing the values of labels Route cube and Route weight in truck info,
    # if any of those are in RED then system should display this message.

  Scenario: Checking Exit label and icon displayed on the Truck Info
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Validates Exit button is present
    And Clicks Exit button on Truck Info page

  @todo
  Scenario: Checking Warning message if Assignments are not printed
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
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
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Select first assignment on Truck Info page
    And Validates First Assignment popup is present
    And Validates Assignment details on popup

  @todo
  Scenario: Checking Load Planning - split product pick task assignment details edit
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    And Select first assignment on Truck Info page
    And Validates First Assignment popup is present
    And Validates Assignment details on popup
    And Clicks edit icon for first assignment on Assignments popup
    And Validates Split task popup displayed
    And Clicks decrease quantity on Split task popup
    And Clicks Save button on Split task popup
    And Validates "Reason is required" notification is displayed on Split Task
    And Clicks reason dropdown on Split task popup
    And Selects reason "Short Order" from dropdown on Split task popup
    And Clicks Save button on Split task popup
    And Validates "Success" notification is displayed for Exit Load Planning
   # And  from a single task for 4, you will change quantity to 3 to create 2 tasks for 3 and 1.
  #   Verify that when hit save based on the example mentioned the task are split from one to two like 3 and 1
  # Verify that spilted task quantity is reflected on outbound order/route task screen
  #   Verify that spilted task quantity is reflected Workqueue task screen edit

  @todo
  Scenario: Checking Load Planning - split product pick task edit 003
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
    # click on the Stop on the assignment
    # Verify that when click on the Stop /task details pop up is displayed
    #Verify that all the product details are displayed related to that assignment
    #Verify that EDIT icon is displayed against each task/product in the assignment pop up displayed
    And Select first assignment on Truck Info page
    And Validates First Assignment popup is present
    And Validates Assignment details on popup
    And Clicks edit icon for first assignment on Assignments popup
    And Validates Split task popup displayed
    And Clicks decrease quantity on Split task popup
    And Clicks Save button on Split task popup
    And Validates "Reason is required" notification is displayed on Split Task
    And Clicks reason dropdown on Split task popup
    And Selects reason "Short Order" from dropdown on Split task popup
    And Clicks Save button on Split task popup
    And Validates "Success" notification is displayed for Exit Load Planning
    # Verify that splited task should also be reflected in assignment details screen
    # Verify that spilted task quantity is reflected on outbound order/route task screen
    #   Verify that spilted task quantity is reflected Workqueue task screen edit

  @todo
  Scenario: Checking Load Planning - Recalculate based on selected Assignments
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And Validates Load Planning popup title is displayed
    And Validates Load Planning popup Ship Date is current date
    Then Selects "06/29/2022" Ship Date on Load Planning popup
    And Clicks Route dropdown on Load Planning popup
    And Validates Load Planning routes exist for selected Ship Date
    And Selects "JUNE29" Route for Load Planning
    And Clicks Done button on Load Planning page
    And Waits for Outbound Truck Info page to load
    And User gets all assignments from Truck diagram
    And Clicks Reprocess button on Truck Info page
    And Clicks Yes button on Rebuilding Assignments popup
    And Validates Rebuilding assignments complete popup is displayed
    And Clicks Ok button on Truck Info
   # When