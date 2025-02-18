Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

  @HidePriceEnabled
  Scenario Outline: Test scenario for enabling Hide prices in offline mode
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for DM for admin setting
    Then User navigate to Client side for DM for admin setting
    Then User should select Order Entry tab for DM for admin setting
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode for admin setting
    And Then User selects Go offline option in Disconnected mode popup for admin setting
    Then User should get Customer account# popup for admin setting
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized for admin setting
    Then User must be on Order Entry Page in disconnected mode
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User enters Product# in Search box
    Then Check for Catalog popup and check for no price column in catalog in Disconnected mode
    Then Enter the Qty in the Product grid Case and Unit
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    When User clicks on network symbol and click on toggle button drop down should appear
    And Then User should Click on toggle button to go online
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                        |               Key           |
      | Hide prices in offline mode     | CPHidePriceInOfflineMode    |

  @HidePriceDisable
  Scenario Outline: Test scenario for disabling Hide prices in offline mode
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for DM for admin setting
    Then User navigate to Client side for DM for admin setting
    Then User should select Order Entry tab for DM for admin setting
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode for admin setting
    And Then User selects Go offline option in Disconnected mode popup for admin setting
    Then User should get Customer account# popup for admin setting
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized for admin setting
    Then User must be on Order Entry Page in disconnected mode
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User enters Product# in Search box
    Then Check for Catalog popup and check for price column existence in catalog in Disconnected mode
    Then Enter the Qty in the Product grid Case and Unit
     |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    When User clicks on network symbol and click on toggle button drop down should appear
    And Then User should Click on toggle button to go online
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                        |               Key           |
      | Hide prices in offline mode     | CPHidePriceInOfflineMode    |

  @HidePriceCatalogEnabledCard
  Scenario Outline: Test scenario for enabling Hide prices in offline mode and verifying in catalog card view
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for DM for admin setting
    Then User navigate to Client side for DM for admin setting
    Then User should select Order Entry tab for DM for admin setting
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode for admin setting
    And Then User selects Go offline option in Disconnected mode popup for admin setting
    Then User should get Customer account# popup for admin setting
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized for admin setting
    Then User must be on Order Entry Page in disconnected mode
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User should verify for price of product detail not existence
    When User clicks on network symbol and click on toggle button drop down should appear
    And Then User should Click on toggle button to go online
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                        |               Key           |
      | Hide prices in offline mode     | CPHidePriceInOfflineMode    |

  @HidePriceCatalogDisabledCard
  Scenario Outline: Test scenario for disable Hide prices in offline mode and verifying in catalog card view
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for DM for admin setting
    Then User navigate to Client side for DM for admin setting
    Then User should select Order Entry tab for DM for admin setting
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode for admin setting
    And Then User selects Go offline option in Disconnected mode popup for admin setting
    Then User should get Customer account# popup for admin setting
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized for admin setting
    Then User must be on Order Entry Page in disconnected mode
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User should verify for price of product detail existence
    When User clicks on network symbol and click on toggle button drop down should appear
    And Then User should Click on toggle button to go online
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                        |               Key           |
      | Hide prices in offline mode     | CPHidePriceInOfflineMode    |

  @HidePriceCatalogEnabledGrid
  Scenario Outline: Test scenario for enabling Hide prices in offline mode and verifying in catalog List view
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for DM for admin setting
    Then User navigate to Client side for DM for admin setting
    Then User should select Order Entry tab for DM for admin setting
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode for admin setting
    And Then User selects Go offline option in Disconnected mode popup for admin setting
    Then User should get Customer account# popup for admin setting
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized for admin setting
    Then User must be on Order Entry Page in disconnected mode
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in List view in Catalog page
    Then User should verify for price of product detail not existence
    When User clicks on network symbol and click on toggle button drop down should appear
    And Then User should Click on toggle button to go online
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                        |               Key           |
      | Hide prices in offline mode     | CPHidePriceInOfflineMode    |

  @HidePriceCatalogDisabledGrid
  Scenario Outline: Test scenario for disable Hide prices in offline mode and verifying in catalog List view
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for DM for admin setting
    Then User navigate to Client side for DM for admin setting
    Then User should select Order Entry tab for DM for admin setting
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode for admin setting
    And Then User selects Go offline option in Disconnected mode popup for admin setting
    Then User should get Customer account# popup for admin setting
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized for admin setting
    Then User must be on Order Entry Page in disconnected mode
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in List view in Catalog page
    Then User should verify for price of product detail existence
    When User clicks on network symbol and click on toggle button drop down should appear
    And Then User should Click on toggle button to go online
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                        |               Key           |
      | Hide prices in offline mode     | CPHidePriceInOfflineMode    |

  @PriceHavingTwoDecimalValues
  Scenario Outline: Test scenario for Price having 2 decimal values
    Given User enters URL and is on login page for admin and client Test scenarios
    When User should land on landing page and verify
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User should set the value for Number of decimal places shown in prices as two
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page for DM for admin setting
    Then User navigate to Client side for DM for admin setting
    Then User should select Order Entry tab for DM for admin setting
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode for admin setting
    And Then User selects Go offline option in Disconnected mode popup for admin setting
    Then User should get Customer account# popup for admin setting
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized for admin setting
    Then User must be on Order Entry Page in disconnected mode
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User should verify Whether price is having two decimal values
    When User clicks on network symbol and click on toggle button drop down should appear
    And Then User should Click on toggle button to go online
    Then User sign out from client side for Admin setting changes
    Examples:
      |Main menu    |Sub menu  |
      |Web Ordering |General   |


