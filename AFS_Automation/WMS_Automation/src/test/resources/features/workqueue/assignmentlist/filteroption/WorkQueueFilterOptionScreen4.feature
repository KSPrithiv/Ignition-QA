@WorkQueue @Regression
Feature: Testing of Work Queue Assignment functionality
  Scenario: Checking In Use By filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks In Use By Filter on Work Queue Assignments page
    And Types In Use By by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Route filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Route Filter on Work Queue Assignments page
    Then Types Route by index 3 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Stops filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Stops Filter on Work Queue Assignments page
    And Types Stop by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Tasks filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Tasks Filter on Work Queue Assignments page
    And Types filter "0" on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Cube filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Cube Filter on Work Queue Assignments page
    And Types Cube by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Released filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Released Filter on Work Queue Assignments page
    Then User clicks from Date "2" on Work Queue Assignments page
    And User clicks till Date "22" on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Assign to filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Assign To Filter on Work Queue Assignments page
    Then Types Assign To by index 4 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Picked filter option of Work Queue Assignments screen functionality
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

  Scenario: Checking Weight filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Weight Filter on Work Queue Assignments page
    Then Types Weight by index 5 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Shipper filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Shipper Filter on Work Queue Assignments page
    Then Types Shipper by index 4 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page



  Scenario: Checking Clear all the filters of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And DockManagement Summary Page is validated
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
    And DockManagement Summary Page is validated
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