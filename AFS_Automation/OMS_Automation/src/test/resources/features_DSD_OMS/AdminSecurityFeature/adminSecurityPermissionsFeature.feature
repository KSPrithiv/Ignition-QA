Feature: scenarios for admin security and submenu permission, for creating role, editing etc

  Background: For login to application and selecting Account# for Admin Security
    Given User enters URL and is on login page and entered credentials for Admin setting for admin security
    When User is on Home Page for Admin setting for admin security

  @CreatingNewRolePermission
  Scenario Outline: Test scenario for creating role in Admin security
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User clicks on plus symbol to create new role, popup will appear enter all required fields, "<Managable Role>" and save in Permission
    And User confirm that newly added role is displayed in grid in Permission
    Examples:
      |Main menu|Sub menu      |Managable Role |
      |Security |Permissions   |CompanyAdmin   |

  @EditRolePermission
  Scenario Outline: Test scneario for editing newly added role
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User selects role from the grid and clicks on edit button in Permission
    Examples:
      |Main menu|Sub menu      |
      |Security |Permissions   |

  @CopyRolePermission
  Scenario Outline: Test scenario for creating copy of role
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User should create copy of role in Permission by selecting "<Role>"
    Examples:
      |Main menu|Sub menu      | Role    |
      |Security |Permissions   |custadmin|

  @SearchSomeSettingPermission
  Scenario Outline: Test scenario for searching any admin settings from search box
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User should enter admin setting value "<Setting>" in search bar
    Examples:
      |Main menu|Sub menu      | Setting                                    |
      |Security |Permissions   |Allow user to access Administration - Login.|

  @AddPermissionByUser
  Scenario Outline: Test scenario for navigating to By user and add permission
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User should navigate to "<Navigate to>" card
    Then User should enter "<Role>" and "<User>" in add user to table
    Examples:
      |Main menu|Sub menu      | Navigate to |Role     |User     |
      |Security |Permissions   | By user     |custadmin|Divya_DSD|

  @SearchPermissionByUser
  Scenario Outline: Test scenario for searching in By user tab
    Given User is on Home Page for Admin setting to select Admin option for admin security
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User should navigate to "<Navigate to>" card
    Then User should enter "<Role>" and "<User>" in add user to table
    And User selects admin permission "<Admin permission>" to be searched in search bar
    Examples:
      |Main menu|Sub menu      | Navigate to |Role     |User     |Admin permission                                         |
      |Security |Permissions   | By user     |custadmin|Divya_dsd|Allow user to access Administration - General - Punchout.|