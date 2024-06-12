@WorkQueue @Regression
Feature: Testing of Work Queue Assignment functionality
  Scenario: Checking Filter option In Use By of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks In Use By Filter on Work Queue Assignments page
    Then Types In Use By by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Shipper of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page

  Scenario: Checking Filter option Assignment type of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Assignment Type Filter on Work Queue Assignments page

  Scenario: Checking Delete all of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    Then User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page