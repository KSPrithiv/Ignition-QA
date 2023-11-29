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

  Scenario: Check every screen should have warehouse at top
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    And Validates warehouse dropdown is displayed on Inbound Load Summary page
    When Go to Inbound Orders page
    And User waits for Inbound Order Summary page to load
    And Validates warehouse dropdown is displayed on Inbound Load Summary page
    And Go to Counting Count page
    And Waits for Counting Count page to load
    And Validates warehouse dropdown is displayed on Inbound Load Summary page
    Then Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates warehouse dropdown is displayed on Inbound Load Summary page
    And Go to Work Queue Assign Work page
    And Waits for Work Queue Work Assign page to load
    And Validates warehouse dropdown is displayed on Inbound Load Summary page