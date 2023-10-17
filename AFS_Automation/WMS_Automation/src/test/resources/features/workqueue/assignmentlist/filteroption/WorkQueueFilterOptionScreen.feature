@WorkQueue @Regression
Feature: Testing of Work Queue Assignment functionality
  Scenario: Checking Filter option Assignment number of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And DockManagement Summary Page is validated
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
    And DockManagement Summary Page is validated
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
    And DockManagement Summary Page is validated
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
    And DockManagement Summary Page is validated
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
    And DockManagement Summary Page is validated
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

  Scenario: Checking Filter option Qty of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    And User checks Qty Filter on Work Queue Assignments page
    Then Types Qty by index 0 on Work Queue Assignments page
    And Types filter "10" on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Filter option Cube of Work Queue Assignments screen functionality
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

  Scenario: Checking Filter option Release of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    Then User clicks Add Filter on Work Queue Assignments page
    And User checks Assign To Filter on Work Queue Assignments page
    And Types Assign To by index 0 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

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

  Scenario: Checking Delete all of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    Then User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Assignment Edit of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    And Checks assignment with index 0 on Work Queue Assignments page
    And User clicks Edit Assignment on Work Queue Assignments page
    And Validates Edit Assignment popup items are present on Work Queue Assignments page
    When Enters calendar day "10" for Edit Assignment on Work Queue Assignments page
    And Enters time "2:00" for Edit Assignment on Work Queue Assignments page
    And Clicks Save Button for Assignment on Work Queue Assignments page
    And Checks assignment with index 1 on Work Queue Assignments page
    Then User clicks Edit Assignment on Work Queue Assignments page
    And User selects Task group by index 0 for Assignment on Work Queue Assignments page
    And Clicks Save Button for Assignment on Work Queue Assignments page
    And Checks assignment with index 2 on Work Queue Assignments page
    And User clicks Edit Assignment on Work Queue Assignments page
    And User selects Task group by index 1 for Edit Assignment on Work Queue Assignments page
    And Clicks Save Button for Assignment on Work Queue Assignments page
    And Checks assignment with index 1 on Work Queue Assignments page
    And Checks assignment with index 4 on Work Queue Assignments page
    And Checks assignment with index 2 on Work Queue Assignments page
    And User clicks Edit Assignment on Work Queue Assignments page
    And Validates current date and time for Edit Assignment on Work Queue Assignments page

    #issue
  Scenario: Checking Assignment Delete of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When Checks assignment with index 0 on Work Queue Assignments page
    And User clicks Delete Assignment on Work Queue Assignments page
    And Validates "Delete selected assignment?" message content on dialog popup on Work Queue Assignments page
    And Validates Assignment popup Cancel and OK buttons are present on Work Queue Assignments page
    And Clicks Cancel Button for Assignment on Work Queue Assignments page
    Then Checks assignment with index 1 on Work Queue Assignments page
    And Checks assignment with index 2 on Work Queue Assignments page
    And User clicks Delete Assignment on Work Queue Assignments page
    And Validates "Delete selected assignments?" message content on dialog popup on Work Queue Assignments page
    And Validates Assignment popup Cancel and OK buttons are present on Work Queue Assignments page
    And Clicks Cancel Button for Assignment on Work Queue Assignments page

  Scenario: Checking Assignment Release of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When Checks assignment with index 0 on Work Queue Assignments page
    And User clicks Release Assignment on Work Queue Assignments page
    And Validates Release Assignment elements are present on Work Queue Assignments page
    And Validates "Assignments" title on dialog popup on Work Queue Assignments page
    And Validates Assignment popup Cancel and Save buttons are present on Work Queue Assignments page
    Then User enters calendar day "13" for Assignment Release Date on Work Queue Assignments page
    And User enters calendar time "14:00" for Assignment Release Date on Work Queue Assignments page
    And Clicks Save Button for Assignment on Work Queue Assignments page
    And Checks assignment with index 0 on Work Queue Assignments page
    And User clicks Release Assignment on Work Queue Assignments page
    And Clicks Cancel Button for Assignment on Work Queue Assignments page
    And Checks assignment with index 1 on Work Queue Assignments page
    And Checks assignment with index 2 on Work Queue Assignments page
    And User clicks Release Assignment on Work Queue Assignments page
    And User clicks Clear Release for Assignment on Work Queue Assignments page
    And Validates empty date and time for Release Assignment on Work Queue Assignments page
    And Clicks Save Button for Assignment on Work Queue Assignments page
    And Checks assignment with index 2 on Work Queue Assignments page
    And User clicks Release Assignment on Work Queue Assignments page
    And User clicks Clear Release for Assignment on Work Queue Assignments page
    And Validates empty date and time for Release Assignment on Work Queue Assignments page
    And Clicks Cancel Button for Assignment on Work Queue Assignments page
    And Checks assignment with index 1 on Work Queue Assignments page
    And User clicks Release Assignment on Work Queue Assignments page
    And User selects user by index 0 for Assignment on Work Queue Assignments page
    And Clicks Cancel Button for Assignment on Work Queue Assignments page
    And Checks assignment with index 0 on Work Queue Assignments page
    And Checks assignment with index 1 on Work Queue Assignments page
    And User clicks Release Assignment on Work Queue Assignments page
    And Validates Assignment popup Cancel and Save buttons are present on Work Queue Assignments page
    And User selects user by index 1 for Assignment on Work Queue Assignments page
    And Clicks Save Button for Assignment on Work Queue Assignments page
    And Checks assignment with index 0 on Work Queue Assignments page
    And Checks assignment with index 1 on Work Queue Assignments page
    And User clicks Release Assignment on Work Queue Assignments page
    And Validates Assignment popup Cancel and Save buttons are present on Work Queue Assignments page
    And User selects user by index 2 for Assignment on Work Queue Assignments page
    And Clicks Cancel Button for Assignment on Work Queue Assignments page

   Scenario: Checking Assignment Labels of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When Checks assignment with index 0 on Work Queue Assignments page
    And User clicks Print Assignment on Work Queue Assignments page
    And Validates Successful message "Success" on Work Queue Assignments page
    Then Checks assignment with index 1 on Work Queue Assignments page
    And Checks assignment with index 2 on Work Queue Assignments page
    And User clicks Print Assignment on Work Queue Assignments page
    And Validates Successful message "Success" on Work Queue Assignments page

  Scenario: Checking Assignment Details of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When Clicks assignment with index 0 on Work Queue Assignments page
    And Validates Assignment details on Work Queue Assignments page
    Then User clicks Close on Work Queue Assignments page
    And Work Queue Assignments Page is validated

  Scenario: Checking Assignment QTY filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Qty Filter on Work Queue Assignments page
    And Types Qty by index 3 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Assignment Task Group filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    Then User clicks Add Filter on Work Queue Assignments page
    And User checks Task Group Filter on Work Queue Assignments page
    And Checks Default task group on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Assignment Status filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Status Filter on Work Queue Assignments page
    And Clicks Not started status on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

  Scenario: Checking Assignment number filter option of Work Queue Assignments screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assignments page
    And Waits for Work Queue Assignments page to load
    When User clicks Add Filter on Work Queue Assignments page
    And User clicks Clear All on Work Queue Assignments page
    And User clicks Add Filter on Work Queue Assignments page
    Then User checks Assignment number on Work Queue Assignments page
    And Types Assignment Number by index 3 on Work Queue Assignments page
    And Clicks Apply button on Work Queue Assignments page
    And User clicks Assignments Title on Work Queue Assignments page
    And Validates Grid items are present on Work Queue Assignments page

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