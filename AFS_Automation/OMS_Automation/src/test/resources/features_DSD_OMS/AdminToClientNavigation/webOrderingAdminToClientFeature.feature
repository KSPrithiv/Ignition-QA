Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side, For Order entry test scenario

  @EnableHideOrderSubmittingMessage
  Scenario Outline: Test scenario for verifying functionality of Order submitting message enabling
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button to verify error message on submitting
    Then User should be navigated to Order Entry page and verify the error submitting message
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                                 |           Key                         |
      | Hide \"Order submitting\" message        |  CPHideOrderSubmittingMessage         |

  @DisableHideOrderSubmittingMessage
  Scenario Outline: Test scenario for verifying functionality of Order submitting message Disabling
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page and verify the error submitting message is not displayed
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                               |           Key                         |
      | Hide \"Order submitting\"  message     |  CPHideOrderSubmittingMessage         |