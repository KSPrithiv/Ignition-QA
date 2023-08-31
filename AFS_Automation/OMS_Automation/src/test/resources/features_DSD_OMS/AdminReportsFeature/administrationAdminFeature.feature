Feature: Test scenarios for Administration, for Reports

  Background: For login to application and selecting Account# for Admin reports
    Given User enters URL and is on login page and entered credentials for Admin setting for Admin reports
    When User is on Home Page for Admin setting for Admin reports
    Then User Clicks on Permissions by drop down to select Customer Account# for Admin reports

@EventsActivitiesLog
Scenario Outline: Test scenario for verifying functionality of Event activities log tab
Given User is on Home Page for Admin setting to select Admin option for Admin reports
And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options
Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
And User selects User name and "<Event>" to genrate report
And User click on clicks on export .csv
Then User click on Download .pdf to download document
Then User click on reset button in Administration tab and all the webelement should be clear
Examples:
| Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event     |
| Reports    |  Administration  |   Events/ Activities log | Account #   |New order |

@PasswordRequest
Scenario Outline: Test scenario for verifying functionality of Password request tab
Given User is on Home Page for Admin setting to select Admin option for Admin reports
And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options
Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
  Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
  And User click on clicks on export .csv
  Then User click on Download .pdf to download document
  Then User click on reset button in Administration tab and all the webelement should be clear
  Examples:
| Main menu  |  Sub menu        |   Admin Options     |  Add filter |
| Reports    |  Administration  |   Password requests |  Account #  |

 @RegisteredUser
  Scenario Outline: Test scenario for verifying functionality of Registred users tab
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options     |  Add filter |
      | Reports    |  Administration  |  Registered users   |  Account #  |

  @LastLoginUser
  Scenario Outline: Test scenario for verifying functionality of Last user login dates tab
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects To dates for Creating reports on Last user login dates
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Last user login dates and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          |
      | Reports    |  Administration  |  Last user login dates   |

