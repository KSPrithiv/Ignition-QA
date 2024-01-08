@WorkQueue @Regression
Feature: Testing of Work Queue Assignment functionality
  Scenario: Checking Filter option Assignment number of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Assignment number on Work Queue Assignments page
    Then Types Assignment Number by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Status of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Status Filter on Work Queue Assignments page
    And Clicks Completed status on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Task group of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Task Group Filter on Work Queue Assignments page
    And Checks Count task group on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Route of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Route Filter on Work Queue Assignments page
    And Types Route by index 1 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Stops of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Stops Filter on Work Queue Assignments page
    And Types Stop by index 3 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Tasks of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Tasks Filter on Work Queue Assignments page
    And Types Task by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Release of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Released Filter on Work Queue Assignments page
    And User clicks from Date "2" on Work Queue Assignments page
    And User clicks till Date "22" on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Assign to of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    Then User clicks Add Filter on Work Queue Assignments page
    And User checks Assign To Filter on Work Queue Assignments page
    And Types Assign To by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page