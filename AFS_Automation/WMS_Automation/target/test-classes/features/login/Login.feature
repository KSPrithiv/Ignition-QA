@Login
Feature: Testing of Login to AFS Application

  Scenario: Enter valid username and password, validate main page
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated

  Scenario: Enter not valid username and password, get error message
    Given User signs in the application with wrong credentials
    When Login page is displayed
    Then Wrong credentials notification error "Either Username or Password is incorrect. Please try again." is displayed

  @issue
  Scenario: Check every screen should have warehouse at top
    Given User signs in the application
    When Main page is loaded
    Then DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates warehouse dropdown is displayed on Inbound Load Summary page
    And User selects warehouse "Next Door" on Inbound Load Summary page
    And Inbound Load Summary page main elements are present
    And Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And Validates Inbound Order Summary Page contains all web elements
    And Validates warehouse dropdown is displayed on Inbound Order Summary page
    And User selects warehouse "Next Door" on Inbound Order Summary page
    And Validates Inbound Order Summary Page contains all web elements
    And Go to Inbound Receiving page
    And Receiving page loads
    And Receiving page contains all web elements
    And User selects warehouse "Next Door" on Receiving page
    And Receiving page contains all web elements
    # Inbound - Inbound reports
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And User selects warehouse "Next Door" on Outbound Route page
    And Validates Outbound Route Summary page is displayed
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Outbound Order Summary page is displayed
    And User selects warehouse "Next Door" on Outbound Order Summary page
    And Validates Outbound Order Summary page is displayed
    And Go to Outbound Load Planning page
    And Waits for Outbound Load Planning page to load
    And Validates Load Planning page is displayed
    And User selects warehouse "Next Door" on Load Planning page
    And Validates Load Planning page is displayed
    And Go to Outbound Processing page
    And Wait for Processing page to load
    And Processing page contains all web elements
    And User selects warehouse "Next Door" on Processing page
    And Processing page contains all web elements
    # Inbound - Outbound reports
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User selects warehouse "Next Door" on Lookup Location page
    And Waits for Location Lookup page to load
    And Go to Lookup Product page
    And Waits for Product Lookup page to load
    And Validates Product Lookup Page base elements are loaded
    And User selects warehouse "Next Door" on Lookup Product page
    And Waits for Product Lookup page to load
    And Go to Lookup DockManagement page
    And Waits for Dock Management Lookup page to load
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User selects warehouse "Next Door" on Dock Management page
    And Waits for Dock Management Lookup page to load
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    # Lookup - Lookup Reports
    And  Go to Work Queue Assign Work page
    And Waits for Work Queue Work Assign page to load
    And Validates Assign work screen is displayed on Work Queue Work Assign Page
    And User selects warehouse "Next Door" on Work Queue Work Assign page
    And Waits for Work Queue Work Assign page to load
    And Validates Assign work screen is displayed on Work Queue Work Assign Page
    And Go to Work Queue Logged-in users page
    And Waits for Work Queue Logged In Users page to load
    And Validates User Logged In title is displayed on Work Queue Logged In Users page
    And User selects warehouse "Next Door" on Work Queue Logged In Users page
    And Waits for Work Queue Logged In Users page to load
    And Validates User Logged In title is displayed on Work Queue Logged In Users page
    And Go to Work Queue User history page
    And Waits for Work Queue User History page to load
    And Validates User history is displayed on Work Queue User History page
    And User selects warehouse "Next Door" on Work Queue User History page
    And Waits for Work Queue User History page to load
    And Validates User history is displayed on Work Queue User History page
    And Waits for Work Queue User History page to load
    And Validates User history is displayed on Work Queue User History page
   # Work Queue - Work Queue Reports
    And Go to Counting Count page
    And Waits for Counting Count page to load
    And Validates Counting Count page is displayed
    And User selects warehouse "Next Door" on Counting Count page
    And Waits for Counting Count page to load
    And Validates Counting Count page is displayed
    And Go to Counting Dashboard page
    And Waits for Counting Dashboard page to load
    And Validates Counting Dashboard page is displayed
    And User selects warehouse "Next Door" on Counting Dashboard page
    And Waits for Counting Dashboard page to load
    And Validates Counting Dashboard page is displayed
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    And User selects warehouse "Next Door" on Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    # Counting - Counting Reports
    And Go to Setup System page
    And Waits for Setup System page to load
    And Validates Setup System page is displayed
    And User selects warehouse "Next Door" on Setup System page
    And Waits for Setup System page to load
    And Validates Setup System page is displayed
    # Setup - Warehouse
    # Setup - Configuration
    # Setup - Product
    # Setup - Screens