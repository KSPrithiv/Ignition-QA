Feature: Admin setting for Cutoff Management
  Verifying Admin setting features for Cutoff management

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Admin setting
    When User is on Home Page for Admin setting
    Then User Clicks on Permissions by drop down to select Customer Account#

  @CutoffManagementForBranch
  Scenario Outline: Test scenario for adding Cutoff management for branch
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder
    And User should navigate to "<Option>" tab for Cutoff management
    Then User should select "<MenuOption>" from horizantal menu to select Cutoff management
    And User should click on Branch management toggle button select branch and set times for cutoff
    Examples:
      | Option              |   MenuOption    |
      | Blackouts & Cutoffs |Cutoff management|
