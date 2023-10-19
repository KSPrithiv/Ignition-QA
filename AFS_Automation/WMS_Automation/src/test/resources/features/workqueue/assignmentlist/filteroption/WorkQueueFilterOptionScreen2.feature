@WorkQueue @Regression
Feature: Testing of Work Queue Assignment functionality
  Scenario: Checking Filter option In Use By of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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

  Scenario: Checking Filter option Percent Picked of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Percent Picked Filter on Work Queue Assignments page
    Then Types Percent Picked by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Weight of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Weight Filter on Work Queue Assignments page
    Then Types Weight by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Shipper of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Shipper Filter on Work Queue Assignments page
    Then Types Shipper by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Ship To of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Ship To Filter on Work Queue Assignments page
    Then Types Ship To by index 3 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Assignment type of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Assignment Type Filter on Work Queue Assignments page
    And Checks Assignment type Pick Dry on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Remaining of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Remaining Filter on Work Queue Assignments page
    And Types Remaining by index 1 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Estimate Time of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Estimated Time Filter on Work Queue Assignments page
    Then Types Est Time by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Standard Time of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Standard Time Filter on Work Queue Assignments page
    Then User clicks Is Empty radio button on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Actual Time of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Actual Time Filter on Work Queue Assignments page
    And Types Actual Time by index 1 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page