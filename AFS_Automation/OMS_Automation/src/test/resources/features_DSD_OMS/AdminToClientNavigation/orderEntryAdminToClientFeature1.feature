Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side, For Order entry test scenario

  @CatalogDonotAutoLoadEnableCardView
  Scenario Outline: Test scenario for enable auto loading of products in catalog dialog box, in card view
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to catalog search
    Then User should select "<CatalogSearchLayout>" in Catalog search layout and enable Do not load full catalog automatically
    And User should save all the details
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select catalog option for admin setting
    And User should verify products are not auto loaded select Product from catalog and Enter Qty for the products
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Examples:
      |Option             |   CatalogSearchLayout |
      |Catalog Search     |    Card layout        |

  @CatalogDonotAutoLoadDisableCardView
  Scenario Outline: Test scenario for disable auto loading of products in catalog dialog box, in card view
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to catalog search
    Then User should select "<CatalogSearchLayout>" in Catalog search layout and disable Do not load full catalog automatically
    And User should save all the details
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select catalog option for admin setting
    And User should verify products are auto loaded select Product from catalog and Enter Qty for the products
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Examples:
      |Option             |   CatalogSearchLayout |
      |Catalog Search     |    Card layout        |

  @PrimarySalesRepSubmittingOrdersDisabled
  Scenario Outline: Test scenario for Use of primary sales rep when submitting orders disabled
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    And User should change sales rep other than primary sales rep
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    And User should verify Sales rep value
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                                               |          Key                         |
      | Use of primary sales rep when submitting orders        | CPUsePrimarySalesRepForNewOrder      |

  @PrimarySalesRepSubmittingOrdersEnabled
  Scenario Outline: Test scenario for Use of primary sales rep when submitting orders Enabled
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    And User should change sales rep other than primary sales rep
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    And User should verify Sales rep value
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                                               |          Key                         |
      | Use of primary sales rep when submitting orders        | CPUsePrimarySalesRepForNewOrder      |

  @CustomerSelectionGridDisabled
  Scenario Outline: Test case for Displaying customer Account index dialog box without any filter, addfilter button etc
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User clicks on customer account index icon and verify the customer account index dialog box
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                               |          Key                     |
      | Full customer selection grid in header | CPUseFullCustomerSelectionGrid   |

  @CustomerSelectionGridEnabled
  Scenario Outline: Test case for Displaying customer Account index dialog box with filter, addfilter button etc
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User clicks on customer account index icon and verify the customer account index dialog box displaying addfilter and filter headers
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                               |          Key                     |
      | Full customer selection grid in header | CPUseFullCustomerSelectionGrid   |

  @DisablePaymentOption
  Scenario Outline: Test case for disabling payment option, so that we can avoid display of payment option in order entry module
    Given User enters URL and is on login page for admin and client Test scenarios
    When User should land on landing page and verify
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User changes the value of Default workflow method to none
    And User should enter menu "<Main menu1>" in search bar and select "<Sub menu1>"
    Then User searches for "<AdminControl>" "<AdminControlId>" and disable admin setting
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Inventory for admin setting
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
    Then User should be navigated to Order Entry page
    Then Enter Order# in Search box in Order Entry page
    Then Click on Order number in Order Entry page and check for New OE page payment page is not visible
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Examples:
      |Main menu    |Sub menu    | Main menu1   | Sub menu1  |                   AdminControl                        |           AdminControlId             |
      |Web Ordering |Order Entry | Security     | Permission | Allow user to change the shipping address of the order| accessorderentrychangeshippingaddress|

  @EnablePaymentOption
  Scenario Outline: Test case for disabling payment option, so that we can avoid display of payment option in order entry module
    Given User enters URL and is on login page for admin and client Test scenarios
    When User should land on landing page and verify
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User changes the value of Default workflow method to none
    And User should enter menu "<Main menu1>" in search bar and select "<Sub menu1>"
    Then User searches for "<AdminControl>" "<AdminControlId>" and enable admin setting
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Inventory for admin setting
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
    Then User should be navigated to Order Entry page
    Then Enter Order# in Search box in Order Entry page
    Then Click on Order number in Order Entry page and check for New OE page payment page visible
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Examples:
      |Main menu    |Sub menu    | Main menu1   | Sub menu1  |                   AdminControl                        |           AdminControlId             |
      |Web Ordering |Order Entry | Security     | Permission | Allow user to change the shipping address of the order| accessorderentrychangeshippingaddress|