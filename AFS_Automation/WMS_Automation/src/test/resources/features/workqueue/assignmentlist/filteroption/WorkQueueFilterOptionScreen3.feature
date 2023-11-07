@WorkQueue @Regression
Feature: Testing of Work Queue Assignment functionality
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

  @isofailed2
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