Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side, For Order entry test scenario

  @ShowModificationWarehouseDisable
  Scenario Outline: Test scenario to verify functionality for Disabling Show and allow modification of warehouse
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User must click Start Order button validate no Warehouse is displayed
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                                 |          Key                  |
      | Show and allow modification of warehouse | CPShowAndModifyWarehouse      |

  @ShowModificationWarehouseEnable
  Scenario Outline: Test scenario to verify functionality for enabling Show and allow modification of warehouse
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User must click Start Order button validate Warehouse is displayed
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                                   |             Key          |
      | Show and allow modification of warehouse   | CPShowAndModifyWarehouse |