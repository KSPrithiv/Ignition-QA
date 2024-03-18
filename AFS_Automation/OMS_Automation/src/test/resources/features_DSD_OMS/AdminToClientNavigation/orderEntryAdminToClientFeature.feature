Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side, For Order entry test scenario

  @ExistingOrderFoundDisabled
  Scenario Outline: Test scenario to verify functionality when orders exist before order submission is disabled
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
     |  Setting                                               |          Key                         |
     | Validate if other orders exist before order submission | CPValidateOtherOrdersBeforeSubmission|

    @ExistingOrderFoundEnabled
    Scenario Outline: Test scenario to verify functionality when orders exist before order submission is enabled
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
        |  Setting                                               |             Key                      |
        | Validate if other orders exist before order submission | CPValidateOtherOrdersBeforeSubmission|

   @ExistingOrderFoundCancel
   Scenario Outline: Test scenario to verify functionality when orders exist before order submission is enabled and click on cancel button, in Order exists dialog box
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

    @EnablePO
    Scenario Outline: Test scenario to verify functionality for enable admin setting for PO#
      Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
      When User enters URL and is on login page and entered credentials for admin setting
      When User is on Home Page
      Then User navigate to Client side
      Then User should select Order Entry tab for admin
      Then User selects Account# for Admin side setting
      Then User must click Start Order button
      Then User should make selection between Pending order or Start New order
      Then User should select Note from popup and Order guide from popup
      Then Enter PO# for New order and Po mandatory message should display
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
        |  Setting                         |          Key          |
        | Input required for the PO# field | CPRequirePONumber     |

  @DisablePO
  Scenario Outline: Test scenario to verify functionality for disabled admin setting for PO#
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order and Po mandatory message should not display
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
      |  Setting                         |          Key          |
      | Input required for the PO# field | CPRequirePONumber     |

  @DisableMultipleOrder
  Scenario Outline: Test scenario to disable Multiple orders per delivery day
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User must click Start Order button should be disabled
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                         |          Key                   |
      | Multiple orders per delivery day | CPEnableMultipleOrdersPerDay   |

  @EnableMultipleOrder
  Scenario Outline: Test scenario to enable multiple orders per delivery day
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User should check start order button enabled click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |80|70|
    Then Click on Next button
    And Click on SubmitOrder button to verify Existing order dialog box
    Then User should be navigated to Order Entry page and display all orders created
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                         |          Key                   |
      | Multiple orders per delivery day | CPEnableMultipleOrdersPerDay   |

  @CatalogDonotAutoLoadCardView
  Scenario Outline: Test scenario for not displaying catalog with auto loading of products in catalog dialog box(Card view)
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Inventory for admin setting
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select catalog option
    And User should verify products are not auto loaded select Product from catalog and Enter Qty for the products
      |50|60|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    And User should disable admin setting "<Setting>" using "<Key>"
    Examples:
      |  Setting                               |               Key           |
      | Do not load full catalog automatically | CPCatalogSearchDoNotAutoLoad|

  @CatalogAutoLoadCardView
  Scenario Outline: Test scenario for displaying products in catalog dialog with auto loading of products card view
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Inventory for admin setting
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select catalog option
    And User should verify products are not auto loaded select Product from catalog and Enter Qty for the products
      |50|60|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    And User should disable admin setting "<Setting>" using "<Key>"
    Examples:
      |  Setting                               |               Key           |
      | Do not load full catalog automatically | CPCatalogSearchDoNotAutoLoad|

  @CatalogDonotAutoLoadGridView
  Scenario Outline: Test scenario for disabling auto loading of products in catalog dialog box, in grid view
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder
    And User should enter menu "<Option>" in search bar to navigate to catalog search

    Examples:
      |Option             |
      |Catalog Search     |

