Feature: Disconnected mode
  Used for Performing different operations in disconnected mode

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for DM
    When User is on Home Page for DM
    Then User navigate to Client side for DM
    Then User should select Order Entry tab for DM

  @DMDeleteProductCard
  Scenario: Test scenario for deleting product from Product card
    Given User should be in Order entry page
    When User Clicks on network symbol and click on taggle button to navigate to disconnected mode
    And Then User selects Go offline option in Disconnected mode popup
    Then User should get Customer account# popup
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized
    Then User must be on Order Entry Page in disconnected mode
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters different Product# in Search bar and enter Qty by clicking image and click Delete product
      |60|
      |100|
      |70|
      |60|
      |80|
    Then User click on cart in catalog and click on Gotocart and select existing order
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @DMValidateShippingAddress
  Scenario: Test scenario to validate whether default shipping address is selected or not in payment page
    Given User should be in Order entry page
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
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |80|80|
    Then Click on Next button and validate shipping address
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @DMQuickProduct
  Scenario: For adding comment to order
    Given User should be in Order entry page
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
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |10|20|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @DMToConnected
  Scenario: for Disconnected mode to connected mode
    Given User should be in OE page in DM
    When User clicks on network symbol and click on taggle button drop down should appear
    And Then User should Click on taggle button to go online

  @DMTwoCustomerTwoDeliveryDate
  Scenario: Test scenario for selecting 2 customer accounts and 2 delivery date and navigate to connected mode
    Given User should be in Order entry page
    When User Clicks on network symbol and click on taggle button to navigate to disconnected mode for two customer account selection
    And Then User selects Go offline option in Disconnected mode popup for two customer account selection
    Then User should get Customer account# popup
    And User should select two Customer Account# from popup and select two delivery date from popup wait till synchronized
    Then User must be on Order Entry Page in disconnected mode
    And User should verify visibility of customer account#
    Then User must be on Order Entry Page in disconnected mode
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |10|20|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Then User clicks on network symbol and click on taggle button drop down should appear
    And Then User should Click on taggle button to go online

