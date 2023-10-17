Feature: scenarios for admin security and submenu roles, for creating role, editing etc

  Background: For login to application and selecting Account# for admin security
    Given User enters URL and is on login page and entered credentials for Admin setting for admin security
    When User is on Home Page for Admin setting for admin security

  @CreatingNewRole
  Scenario Outline: Test scenario for creating role in Admin security
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User clicks on plus symbol to create new role, popup will appear enter all required fields, "<Managable Role>" and save
    And User confirm that newly added role is displayed in grid
    Examples:
      |Main menu|Sub menu|Managable Role |
      |Security |Roles   |CompanyAdmin   |

  @EditRole
  Scenario Outline: Test scneario for editing newly added role
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User selects role from the grid and clicks on edit button
    Examples:
      |Main menu|Sub menu|
      |Security |Roles   |

