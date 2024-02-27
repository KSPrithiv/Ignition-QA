Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side, For Order entry test scenario

  @ExistingOrderFoundDisabled
  Scenario Outline: Test scenario to verify functionality when orders exist before order submission is disabled
    #Given User enters URL and is on login page and entered credentials
    #When User is on Home Page
    #Then User navigate to Client side
    #Then User should select Order Entry tab for admin
    #Then User selects Account# for Admin side setting
    #Then User should find out whether orders are already created or not
    #Then User sign out from client side and sign in to admin side
    #Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    #And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    #Then User should navigate to "<Horizontal tab>" and validate it
    #Then User should disable "<Setting>" in admin side by using "<Identifier>", "<IdentifierForSetting>"
    #And User logs out from Admin site, logs in to client credentials
    #Then User navigate to Client side
    #Then User should select Order Entry tab for admin
    #Then User selects Account# for Admin side setting
    #Then User must click Start Order button
    #Then User should make selection between Pending order or Start New order
    #Then User should select Note from popup and Order guide from popup
    #Then Enter PO# for New order
    #  |PO123|
    #Then Enter Pro# in Quick Product Entry area
    #And Check for Case and Unit input box enabled or not based on that enter value
    #  |80|70|
    #Then Click on Next button
    #And Click on SubmitOrder button to verify Existing order dialog box
    #Then User should be navigated to Order Entry page
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
      |80|70|
    Then Click on Next button
    And Click on SubmitOrder button to verify Existing order dialog box
    Then User should be navigated to Order Entry page
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |Main menu    |Sub menu          |  Setting                                               | Identifier   |          Key                         | Horizontal tab  |
      |Web Ordering |Order Entry       | Validate if other orders exist before order submission |     id       | CPValidateOtherOrdersBeforeSubmission| Order options   |

    @ExistingOrderFoundEnabled
    Scenario Outline: Test scenario to verify functionality when orders exist before order submission is enabled
      #Given User enters URL and is on login page for admin and client Test scenarios
      #When User should land on landing page and verify
      #Then User Clicks on Permissions by drop down to select Customer Account# for admin security
      #And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
      #Then User should navigate to "<Horizontal tab>" and validate it
      #Then User should enable "<Setting>" in admin side by using "<Identifier>", "<IdentifierForSetting>"
      #And User logs out from Admin site, logs in to client credentials
      #Then User navigate to Client side
      #Then User should select Order Entry tab for admin
      #Then User selects Account# for Admin side setting
      #Then User must click Start Order button
      #Then User should make selection between Pending order or Start New order
      #Then User should select Note from popup and Order guide from popup
      #Then Enter PO# for New order
      #  |PO123|
      #Then Enter Pro# in Quick Product Entry area
      #And Check for Case and Unit input box enabled or not based on that enter value
      #  |80|70|
      #Then Click on Next button
      #And Click on SubmitOrder button to display of Existing order dialog box after enabling admin setting
      #Then User should be navigated to Order Entry page
      Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
      Then User enters URL and is on login page and entered credentials for admin setting
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
        |80|70|
      Then Click on Next button
      And Click on SubmitOrder button to display of Existing order dialog box after enabling admin setting
      Then User should be navigated to Order Entry page
      Then User sign out from client side for Admin setting changes
      And User should set admin setting "<Setting>" "<Key>" as default before making changes
      Examples:
        |Main menu    |Sub menu          |  Setting                                               | Identifier   |             Key                      | Horizontal tab  |
        |Web Ordering |Order Entry       | Validate if other orders exist before order submission |     id       | CPValidateOtherOrdersBeforeSubmission| Order options   |

   @ExistingOrderFoundCancel
   Scenario Outline: Test scenario to verify functionality when orders exist before order submission is enabled and click on cancel button, in Order exists dialog box
     #Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
     #Then User enters URL and is on login page and entered credentials for admin setting
     #When User is on Home Page
     #Then User navigate to Client side
     #Then User should select Order Entry tab for admin
     #Then User selects Account#
     #And User should handle different dialog box that appears before creating order
     #Then User must click Start Order button
     #Then User should make selection between Pending order or Start New order
     #Then User should select Note from popup and Order guide from popup
     #Then Enter PO# for New order
     #  |PO123|
     #Then Enter Pro# in Quick Product Entry area
     #And Check for Case and Unit input box enabled or not based on that enter value
     #  |80|70|
     #Then Click on Next button
     #And Click on SubmitOrder button and click on cancel button when Order exists dialog box appears
     #Then User should be navigated to Order Entry page
     #Then User sign out from client side for Admin setting changes
     #And User should set admin setting "<Setting>" "<Key>" as default before making changes
     Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
     Then User enters URL and is on login page and entered credentials for admin setting
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
       |80|70|
     Then Click on Next button
     And Click on SubmitOrder button and click on cancel button when Order exists dialog box appears
     Then User should be navigated to Order Entry page
     Then User sign out from client side for Admin setting changes
     And User should set admin setting "<Setting>" "<Key>" as default before making changes

     Examples:
       |  Setting                                               |              Key                      |
       | Validate if other orders exist before order submission |  CPValidateOtherOrdersBeforeSubmission|

  @ExistingOrderFoundNo
  Scenario Outline: Test scenario to verify functionality when orders exist before order submission is enabled and click on No button, in Order exists dialog box
    #Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    #Then User enters URL and is on login page and entered credentials for admin setting
    #When User is on Home Page
    #Then User navigate to Client side
    #Then User should select Order Entry tab for admin
    #Then User selects Account#
    #And User should handle different dialog box that appears before creating order
    #Then User must click Start Order button
    #Then User should make selection between Pending order or Start New order
    #Then User should select Note from popup and Order guide from popup
    #Then Enter PO# for New order
    #  |PO123|
    #Then Enter Pro# in Quick Product Entry area
    #And Check for Case and Unit input box enabled or not based on that enter value
    #  |80|70|
    #Then Click on Next button
    #And Click on SubmitOrder button and click on No button when Order exists dialog box appears
    #Then User should be navigated to Order Entry page
    #Then User sign out from client side for Admin setting changes
    #And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
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
      |80|70|
    Then Click on Next button
    And Click on SubmitOrder button and click on No button when Order exists dialog box appears
    Then User should be navigated to Order Entry page
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                                               |              Key                      |
      | Validate if other orders exist before order submission |  CPValidateOtherOrdersBeforeSubmission|