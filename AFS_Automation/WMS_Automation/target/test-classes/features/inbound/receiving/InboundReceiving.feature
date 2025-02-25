@Inbound @Regression
Feature: Testing of Receiving functionality
  Scenario: Checking Receiving Navigation functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When User searches for Loads starting from date by index 4
    And Inbound Load Summary page main elements are present
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Checks Load with index 0 and apply "Receive" Load Option for Load
    And Receiving page loads
    And Receiving page contains all web elements
    And Back button is clickable on Receiving page
    And Go to Inbound Orders page
    And User finds orders from date by index 4 on Inbound Order summary page
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects order status "Ready To Receive" on Inbound Order Summary page

  Scenario: Checking Navigate to Staging screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When User searches for Loads starting from date by index 4
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Checks Load with index 0 and apply "Review" Load Option for Load
    And Inbound Load Summary Staging screen with elements is displayed

  Scenario: Checking Navigate to Staging screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When User searches for Loads starting from date by index 4
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Checks Load with index 0 and apply "Receive" Load Option for Load
    And Receiving page loads
    And Receiving page contains all web elements
    And Back button is clickable on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Review button on Receiving page
    And Validates table is displayed on Staging screen
    And Validates Back button is displayed on Stage page
    And Validates Receive button is displayed on Stage page
    And Validates Cancel button is displayed on Stage page
    And Validates Next button is displayed on Stage page
    And Validates Delete button is displayed on Stage page

  Scenario: Checking Back button in Staging screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When User searches for Loads starting from date by index 4
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Checks Load with index 0 and apply "Receive" Load Option for Load
    And Receiving page loads
    And Receiving page contains all web elements
    And Back button is clickable on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Review button on Receiving page
    And Validates table is displayed on Staging screen
    And Validates Back button is displayed on Stage page

  Scenario: Checking Receive staged qty - Select pallet/pallets
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When User searches for Loads starting from date by index 4
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Checks Load with index 0 and apply "Receive" Load Option for Load
    And Receiving page loads
    And Receiving page contains all web elements
    And Back button is clickable on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Review button on Receiving page


  Scenario: Checking delete selected unit/pallet from staging screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When User searches for Loads starting from date by index 4
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Checks Load with index 0 and apply "Receive" Load Option for Load
    And Receiving page loads
    And Receiving page contains all web elements
    And User clicks Next button on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Review button on Receiving page
    And Validates Staging screen summary details on Receiving page

  Scenario: Checking Next to stage more pallets from the Staging screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When User searches for Loads starting from date by index 4
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Checks Load with index 0 and apply "Receive" Load Option for Load
    And Receiving page loads
    And Receiving page contains all web elements
    And User clicks Next button on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Review button on Receiving page
    And Validates Staging screen summary details on Receiving page
    And User clicks Cancel button on Receiving page
    And Receiving page loads
    And Receiving page contains all web elements

  Scenario: Checking Receiving main screen validations
    Given User signs in the application
    And Main page is loaded
    
    And Go to Inbound Receiving page
    And Receiving page loads
    And Receiving page contains all web elements
    When Selects "DR01" dock door on Receiving page
    And Validates "Select load" title on dialog popup on Receiving page
    Then Selects 0 load on Select load popup on Receiving page
    And Validates Receiving page values on Receiving page
    And Types "STAGE" Location on Receiving page
    And Validates "STAGE" Location on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Review button on Receiving page
    And Validates table is displayed on Staging screen

  Scenario: Checking Receiving screen validations
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When User searches for Loads starting from date by index 4
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Checks Load with index 0 and apply "Receive" Load Option for Load
    And Receiving page loads
    And Receiving page contains all web elements
    And Back button is clickable on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Next button on Receiving page
    And Types "0011" LPN on Receiving page
    And User clicks Next button on Receiving page
    And Validates "Invalid pallet number 0011" message content on dialog popup on Receiving page
    And Clicks Ok button on Warning on Receiving page
    And Types "0011001100110011001100" LPN on Receiving page
    And User clicks Next button on Receiving page
    And Validates "Invalid pallet number 0011001100110011001100" message content on dialog popup on Receiving page
    And Clicks Ok button on Warning on Receiving page
    And Clears LPN on Receiving page
    And Types "0900022330" LPN on Receiving page
    And Types "00493" product on Receiving page

  Scenario: Checking Receiving Product functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When User searches for Loads starting from date by index 4
    And Clicks load status "All statuses" on Inbound Load Summary page
    And Selects load status "Ready To Receive" on Inbound Load Summary page
    Then Checks Load with index 0 and apply "Receive" Load Option for Load
    And Receiving page loads
    And Receiving page contains all web elements
    And Back button is clickable on Receiving page
    And User clicks Next button on Receiving page
    And User clicks Next button on Receiving page
    And Types "0900022330" LPN on Receiving page
    And User clicks Next button on Receiving page