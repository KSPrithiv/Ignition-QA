@WorkQueue @Regression
Feature: Testing of Work Queue LoggedIn User functionality
  Scenario: Checking Navigate of Work Queue LoggedIn User screen functionality
    Given User signs in the application
    And Main page is loaded
    
    When Go to Work Queue Logged-in users page
    And Waits for Work Queue Logged In Users page to load
    Then Validates User Logged In title is displayed on Work Queue Logged In Users page
    And Validates table columns are displayed on Work Queue Logged In Users page

  Scenario: Checking Summary Details of Work Queue LoggedIn User screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Logged-in users page
    And Waits for Work Queue Logged In Users page to load
    When User scrolls till end of grid table on Work Queue Logged In Users page
    Then Validates Table End is displayed on Work Queue Logged In Users page

  Scenario: Checking Sorting Of All Columns of Work Queue LoggedIn User screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Logged-in users page
    And Waits for Work Queue Logged In Users page to load
    When User clicks on User Id Header on Work Queue Logged In Users page
    And Validates User Id Column Sorting Result on Work Queue Logged In Users page
    And User clicks on User Id Header on Work Queue Logged In Users page
    And Validates User Id Column Sorting Result on Work Queue Logged In Users page
    Then User clicks on User Name Header on Work Queue Logged In Users page
    And Validates User Name Column Sorting Result on Work Queue Logged In Users page
    And User clicks on User Name Header on Work Queue Logged In Users page
    And Validates User Name Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Computer Header on Work Queue Logged In Users page
    And Validates Computer Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Computer Header on Work Queue Logged In Users page
    And Validates Computer Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Equipment Header on Work Queue Logged In Users page
    And Validates Equipment Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Equipment Header on Work Queue Logged In Users page
    And Validates Equipment Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Printer Header on Work Queue Logged In Users page
    And Validates Printer Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Printer Header on Work Queue Logged In Users page
    And Validates Printer Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Login Date Header on Work Queue Logged In Users page
    And Validates Login Date Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Login Date Header on Work Queue Logged In Users page
    And Validates Login Date Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Break Date Header on Work Queue Logged In Users page
    And Validates Break Date Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Break Date Header on Work Queue Logged In Users page
    And Validates Break Date Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Labor Code Header on Work Queue Logged In Users page
    And Validates Labor Code Column Sorting Result on Work Queue Logged In Users page
    And User clicks on Labor Code Header on Work Queue Logged In Users page
    And Validates Labor Code Column Sorting Result on Work Queue Logged In Users page

  Scenario: Checking Search Control of Work Queue LoggedIn User screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Logged-in users page
    And Waits for Work Queue Logged In Users page to load
    When User searches for user by index 0 on Work Queue Logged In Users page
    Then Validates Grid items are present on Work Queue Logged In Users page

  Scenario: Checking Add Filter of Work Queue LoggedIn User screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Logged-in users page
    And Waits for Work Queue Logged In Users page to load
    And User clicks Add filter button on Work Queue Logged In Users page
    And User clicks Clear All button on Work Queue Logged In Users page
    And User clicks Add filter button on Work Queue Logged In Users page
    And Checks User Id Checkbox on Work Queue Logged In Users page
    When Types User Id by index 0 on Work Queue Logged In Users page
    And Clicks Apply Button on Work Queue Logged In Users page
    And Validates Grid items are present on Work Queue Logged In Users page
    And User clicks Add filter button on Work Queue Logged In Users page
    And User clicks Clear All button on Work Queue Logged In Users page
    And User clicks Add filter button on Work Queue Logged In Users page
    Then Checks User Name Checkbox on Work Queue Logged In Users page
    And Types User Name by index 0 on Work Queue Logged In Users page
    And Clicks Apply Button on Work Queue Logged In Users page
    And Validates Grid items are present on Work Queue Logged In Users page
    And User clicks Add filter button on Work Queue Logged In Users page
    And User clicks Clear All button on Work Queue Logged In Users page
    And User clicks Add filter button on Work Queue Logged In Users page
    And Checks Computer Checkbox on Work Queue Logged In Users page
    And Types Computer by index 0 on Work Queue Logged In Users page
    And Clicks Apply Button on Work Queue Logged In Users page
    And User clicks Add filter button on Work Queue Logged In Users page
    And User clicks Clear All button on Work Queue Logged In Users page
    And Validates Grid items are present on Work Queue Logged In Users page

  Scenario: Checking Logout User of Work Queue LoggedIn User screen functionality
    Given User signs in the application
    And Main page is loaded
    
    And Go to Work Queue Logged-in users page
    And Waits for Work Queue Logged In Users page to load
    When Selects Logout User by index 0 Dropdown on Work Queue Logged In Users page
    And Validates Logout User label is enabled on Work Queue Logged In Users page
    And Clicks Logout User label on Work Queue Logged In Users page
    And Validates OK and Cancel buttons are present on Work Queue Logged In Users page
    And Selects Logout reason by index 0 on Work Queue Logged In Users page
    Then Clicks OK button on Work Queue Logged In Users page

  Scenario: Checking list of logged in users of Work Queue LoggedIn User screen functionality
    Given User signs in the application
    And Main page is loaded
    
    When Go to Work Queue Logged-in users page
    And Waits for Work Queue Logged In Users page to load
    Then Validates User Logged In title is displayed on Work Queue Logged In Users page
    And Validates currently logged in users are displayed on Work Queue Logged In Users page
