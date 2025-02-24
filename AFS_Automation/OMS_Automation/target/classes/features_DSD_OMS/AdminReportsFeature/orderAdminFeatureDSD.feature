Feature: Test scenarios for Order in Admin login, Order related reports

  Background: For login to application and selecting Account# for order Admin
    Given User enters URL and is on login page and entered credentials for Admin setting for Admin reports
    When User is on Home Page for Admin setting for Admin reports

  @OrderExceptionAdminReport
  Scenario Outline: Test scenario for verifying functionality of Order Exception tab
#    Given User enters URL and is on login page and entered credentials for Admin setting for Admin reports
#    When User is on Home Page for Admin setting for Admin reports
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Orders tab
    Then User selects "<Orders Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Order tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu|   Orders Options   | Add filter |
      | Reports    |  Orders  |   Order exception  |  Account # |

  @AutoGenerateOverride
  Scenario Outline: Test scenario for verifying functionality of Auto generate override tab
#    Given User enters URL and is on login page and entered credentials for Admin setting for Admin reports
#    When User is on Home Page for Admin setting for Admin reports
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Orders tab
    Then User selects "<Orders Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Order tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu|   Orders Options          | Add filter |
      | Reports    |  Orders  |   Auto generated override | Account #  |