Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

  @StandingOrderHideZeroEnable
  Scenario Outline: Test scenario for verifying hide zero in product number and enter it in quick product it should be added in grid
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    And User should navigate to Standing Order tab for admin setting
    And User click on Start standing order button and selects Start date 2 and End date 3 day from current date
    Then User enters Product# in Quick product entry inputbox in admin setting
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting             |              Key          |
      | Hide leading zeros   |  CPGeneralHideLeadingZeros|

  @StandingOrderHideZeroInCatalogEnable
  Scenario Outline: Test scenario for verifying hide zero in product number and verify it in catalog dialog box
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    And User should navigate to Standing Order tab for admin setting
    And User click on Start standing order button and selects Start date 2 and End date 3 day from current date
    Then User click on Add Product button in Standing order page and select catalog option
    And User checks for catalog popup and searches for product in catalog for admin setting
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting             |              Key          |
      | Hide leading zeros   |  CPGeneralHideLeadingZeros|

  @StandingOrderHideZeroDisable
  Scenario Outline: Test scenario for verifying hide zero in product number and enter it in quick product it should be added in grid
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    And User should navigate to Standing Order tab for admin setting
    And User click on Start standing order button and selects Start date 2 and End date 3 day from current date
    Then User enters Product# in Quick product entry inputbox in admin setting for disabling
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting             |              Key          |
      | Hide leading zeros   |  CPGeneralHideLeadingZeros|

  @HideZeroInCatalogDisable
  Scenario Outline: Test scenario for verifying hide zero in product number and verify it in catalog dialog box
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    And User should navigate to Standing Order tab for admin setting
    And User click on Start standing order button and selects Start date 2 and End date 3 day from current date
    Then User click on Add Product button in Standing order page and select catalog option
    And User checks for catalog popup and searches for product in catalog for admin setting zero preceding product number in OMS env
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting             |              Key          |
      | Hide leading zeros   |  CPGeneralHideLeadingZeros|