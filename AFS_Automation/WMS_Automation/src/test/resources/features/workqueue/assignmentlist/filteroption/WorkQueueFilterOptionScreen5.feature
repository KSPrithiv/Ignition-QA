@WorkQueue @Regression
Feature: Testing of Work Queue Assignment functionality
  Scenario: Checking Clear all the filters of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    And User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page
    When User clicks Add Filter on Work Queue Assignments page
    And User checks Assignment number on Work Queue Assignments page
    And Types filter "0000" on Work Queue Assignments page
    Then Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are not present on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Tap Assignment # of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page
    Then User clicks on Assignment Number Column Header on Work Queue Assignments page
    And Validates Assignment Number Column Sorting Result on Work Queue Assignments page
    And User clicks on Assignment Number Column Header on Work Queue Assignments page
    And Validates Assignment Number Column Sorting Result on Work Queue Assignments page
    And User clicks on Shipper Column Header on Work Queue Assignments page
    And Validates Shipper Column Sorting Result on Work Queue Assignments page
    And User clicks on Shipper Column Header on Work Queue Assignments page
    And Validates Shipper Column Sorting Result on Work Queue Assignments page
    And User clicks on Tasks Column Header on Work Queue Assignments page
    And Validates Tasks Column Sorting Result on Work Queue Assignments page
    And User clicks on Tasks Column Header on Work Queue Assignments page
    And Validates Tasks Column Sorting Result on Work Queue Assignments page
    And User clicks on Assign To Column Header on Work Queue Assignments page
    And Validates Assign To Column Sorting Result on Work Queue Assignments page
    And User clicks on Assign To Column Header on Work Queue Assignments page
    And Validates Assign To Column Sorting Result on Work Queue Assignments page
    And User clicks on Released Column Header on Work Queue Assignments page
    And Validates Released Column Sorting Result on Work Queue Assignments page
    And User clicks on Released Column Header on Work Queue Assignments page
    And Validates Released Column Sorting Result on Work Queue Assignments page
    And User clicks on Qty Column Header on Work Queue Assignments page
    And Validates Qty Column Sorting Result on Work Queue Assignments page
    And User clicks on Qty Column Header on Work Queue Assignments page
    And Validates Qty Column Sorting Result on Work Queue Assignments page
    And User clicks on Cube Column Header on Work Queue Assignments page
    And Validates Cube Column Sorting Result on Work Queue Assignments page
    And User clicks on Cube Column Header on Work Queue Assignments page
    And Validates Cube Column Sorting Result on Work Queue Assignments page
    And User clicks on Weight Column Header on Work Queue Assignments page
    And Validates Weight Column Sorting Result on Work Queue Assignments page
    And User clicks on Weight Column Header on Work Queue Assignments page
    And Validates Weight Column Sorting Result on Work Queue Assignments page
    And User clicks on Assignment Type Header Column on Work Queue Assignments page
    And Validates Assignment Type Column Sorting Result on Work Queue Assignments page
    And User clicks on Assignment Type Header Column on Work Queue Assignments page
    And Validates Assignment Type Column Sorting Result on Work Queue Assignments page
    And User clicks on Task Group Header Column on Work Queue Assignments page
    And Validates Task Group Column Sorting Result on Work Queue Assignments page
    And User clicks on Task Group Header Column on Work Queue Assignments page
    And Validates Task Group Column Sorting Result on Work Queue Assignments page
    And User clicks on Picked Column Header on Work Queue Assignments page
    And Validates Picked Column Sorting Result on Work Queue Assignments page
    And User clicks on Picked Column Header on Work Queue Assignments page
    And Validates Picked Column Sorting Result on Work Queue Assignments page

  Scenario: Checking Assignment # and Search input field filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Assignment number on Work Queue Assignments page
    Then Types Assignment Number by index 2 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page