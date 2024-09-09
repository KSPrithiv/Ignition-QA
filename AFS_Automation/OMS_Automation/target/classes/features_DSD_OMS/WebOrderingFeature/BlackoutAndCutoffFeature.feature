Feature: Admin setting blackouts
  Verifying Admin setting features for Blackouts

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Admin setting
    When User is on Home Page for Admin setting
    Then User Clicks on Permissions by drop down to select Customer Account#

  @AddBlackoutDate
  Scenario Outline: Test scenario for adding new blackout date
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder
    And User should navigate to "<Option>" tab
    Then User should click on Add blackout button and enter all required value in dialog box
    Examples:
      | Option              |
      | Blackouts & Cutoffs |

  @EditBlackoutDate
  Scenario Outline: Test scenario for editing new blackout date
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder
    And User should navigate to "<Option>" tab
    Then User clicks on Edit button and change message and save blackouts
    Examples:
      | Option              |
      | Blackouts & Cutoffs |

  @DeleteBlackoutDate
  Scenario Outline: Test scenario for Deleting new blackout date
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder
    And User should navigate to "<Option>" tab
    Then User clicks on Delete button and save changes
    Examples:
      | Option              |
      | Blackouts & Cutoffs |

  @AddBlackoutDateForCustomer
  Scenario Outline: Test scenario for adding blackout for particular customer Editing and deleting of blacckout date
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder
    And User should navigate to "<Option>" tab
    Then User should select customer account# in blackout
    Then User should click on Add blackout button and enter all required value in dialog box
    Then User clicks on Edit button for customer account and change message and save blackouts
    Then User clicks on Delete button and save changes for blackouts
    Examples:
      | Option              |
      | Blackouts & Cutoffs |