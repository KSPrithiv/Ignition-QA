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

  @ActiveToInactive
  Scenario Outline: Test scenario for active to inactive role
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User selects role from the grid and clicks on edit button and then in popup click on Active check box to deactivate it
    Examples:
      |Main menu|Sub menu|
      |Security |Roles   |

  @CheckForEnabledModules
  Scenario Outline: Test scenario for verifying modules that appears under roles
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User clicks on In Modules input box and verify the modules enabled
    Examples:
      |Main menu|Sub menu    |
      |Security |Permissions |

  @EnableAndDisableModules
  Scenario Outline: Test scenario for enabling and disabling modules
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User clicks on In Modules input box and verify the modules enabled and disable "<Module>"
    Examples:
      |Main menu|Sub menu    | Module       |
      |Security |Permissions |Administration|

  @SettingsInGrid
  Scenario Outline: Test scenario for verifying Drop down for admin settings in settings grid
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User reads all setting names and finds whether they are expanded or not
    Examples:
      |Main menu|Sub menu    |
      |Security |Permissions |
