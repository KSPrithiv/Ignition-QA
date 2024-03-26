Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

  @HidePriceEnabled
  Scenario Outline: Test scenario for enabling Hide prices in offline mode
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for DM
    Then User navigate to Client side for DM
    Then User should select Order Entry tab for DM
    When User Clicks on network symbol and click on taggle button to navigate to disconnected mode
    And Then User selects Go offline option in Disconnected mode popup
    Then User should get Customer account# popup
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized
    Then User must be on Order Entry Page in disconnected mode
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User enters Product# in Search box
    Then Check for Catalog popup and check for price column in catalog in Disconnected mode
    Then Enter the Qty in the Product grid Case and Unit
      | 60| 60 |
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    When User clicks on network symbol and click on taggle button drop down should appear
    And Then User should Click on taggle button to go online
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                        |               Key           |
      | Hide prices in offline mode     | CPHidePriceInOfflineMode    |

  @HidePriceDisable
  Scenario Outline: Test scenario for enabling Hide prices in offline mode
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for DM
    Then User navigate to Client side for DM
    Then User should select Order Entry tab for DM
    When User Clicks on network symbol and click on taggle button to navigate to disconnected mode
    And Then User selects Go offline option in Disconnected mode popup
    Then User should get Customer account# popup
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized
    Then User must be on Order Entry Page in disconnected mode
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User enters Product# in Search box
    Then Check for Catalog popup and check for price column existence in catalog in Disconnected mode
    Then Enter the Qty in the Product grid Case and Unit
      | 60| 60 |
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    When User clicks on network symbol and click on taggle button drop down should appear
    And Then User should Click on taggle button to go online
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                        |               Key           |
      | Hide prices in offline mode     | CPHidePriceInOfflineMode    |