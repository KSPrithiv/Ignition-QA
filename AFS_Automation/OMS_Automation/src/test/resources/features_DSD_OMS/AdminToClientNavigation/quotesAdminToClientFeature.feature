Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

  @QuoteHideZeroEnable
  Scenario Outline: Test scenario for verifying hide zero in product number and enter it in quick product it should be added in Quotes grid
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit for Admin settings
      |1|1|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing

    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting             |              Key          |
      | Hide leading zeros   |  CPGeneralHideLeadingZeros|

  @QuoteHideZeroDisable
  Scenario Outline: Test scenario for verifying hide zero in product number and enter it in quick product it should be added in Quotes grid
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit for Admin disable settings
      |1|1|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting             |              Key          |
      | Hide leading zeros   |  CPGeneralHideLeadingZeros|