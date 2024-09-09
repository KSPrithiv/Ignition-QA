Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side, For Order entry test scenario

#  @ShippingAddressDisabled
#  Scenario Outline: Test scenario for verifying shipping address should not be selected by default
#    Given User enters URL and is on login page for admin and client Test scenarios
#    When User should land on landing page and verify
#    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
#    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
#    And User should disable admin settings "<AdminControl>" "<Id>", for permission
#    And User logs out from Admin site, logs in to client credentials
#    When User is on Home Page
#    Then User navigate to Client side
#    Then User should select Order Entry tab for admin
#    Then User selects Account# for Inventory for admin setting
#    Then User must click Start Order button
#    Then User should make selection between Pending order or Start New order
#    Then User should select Note from popup and Order guide from popup
#    Then Enter PO# for New order
#      |PO123|
#    Then Enter Pro# in Quick Product Entry area
#    And Check for Case and Unit input box enabled or not based on that enter value
#      |1|1|
#    Then Click on Next button
#    And Click on SubmitOrder button
#    Then User should be navigated to Order Entry page
#    Then Enter Order# in Search box in Order Entry page
#    Then Click on Order number in Order Entry page and check for New OE page for payment page visible
#    Then Click on Next button and validate that checkout order page not visible
#    And Click on SubmitOrder button
#    Then User should be navigated to Order Entry page
#    Examples:
#      |Main menu|Sub menu    | AdminControl                                          |Id                                   |
#      |Security |Permissions | Allow user to change the shipping address of the order|accessorderentrychangeshippingaddress|
#
#  @ShippingAddressEnabled
#  Scenario Outline: Test scenario for verifying shipping address should be selected by default
#    Given User enters URL and is on login page for admin and client Test scenarios
#    When User should land on landing page and verify
#    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
#    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
#    And User should enabled admin settings "<AdminControl>" "<Id>", for permission
#    And User logs out from Admin site, logs in to client credentials
#    When User is on Home Page
#    Then User navigate to Client side
#    Then User should select Order Entry tab for admin
#    Then User selects Account# for Inventory for admin setting
#    Then User must click Start Order button
#    Then User should make selection between Pending order or Start New order
#    Then User should select Note from popup and Order guide from popup
#    Then Enter PO# for New order
#      |PO123|
#    Then Enter Pro# in Quick Product Entry area
#    And Check for Case and Unit input box enabled or not based on that enter value
#      |1|1|
#    Then Click on Next button
#    And Click on SubmitOrder button
#    Then User should be navigated to Order Entry page
#    Then Enter Order# in Search box in Order Entry page
#    Then Click on Order number in Order Entry page and check for New OE page for payment page visible
#    Then Click on Next button and validate that checkout order page is visible
#    And Click on SubmitOrder button
#    Then User should be navigated to Order Entry page
#    Examples:
#      |Main menu|Sub menu    | AdminControl                                          |Id                                   |
#      |Security |Permissions | Allow user to change the shipping address of the order|accessorderentrychangeshippingaddress|


  # Admin setting for hiding zero's=>'Hide leading zeros', Scenario only for DSD
  @HideZerosEnabled
  Scenario Outline: HideZeros that appears in Account# or product#, Admin setting is enabled. Zeros should not be displayed
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    And User should verify the account_No
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      | PO123 |
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      | 1 | 1 |
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Examples:
      | Setting            | Key                       |
      | Hide leading zeros | CPGeneralHideLeadingZeros |

    # Admin setting for hiding zero's=>'Hide leading zeros', Scenario only for DSD
  @HideZerosDisabled
  Scenario Outline: HideZeros that appears in Account# or product#, Admin setting is enabled. Zeros should be displayed
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    And User should verify the account_No should have zeros
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      | PO123 |
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      | 1 | 1 |
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Examples:
      | Setting            | Key                       |
      | Hide leading zeros | CPGeneralHideLeadingZeros |
