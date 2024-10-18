Feature: Disconnected mode
  Used for Performing different operations in disconnected mode

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for DM
    When User is on Home Page for DM
    Then User navigate to Client side for DM
    Then User should select Order Entry tab for DM

  @DMGoOfflineCancel
  Scenario: Test scenario for canceling navigating to disconnected mode
    Given User should be in Order entry page
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode for cancel option
    And Then User selects cancel option in Disconnected mode popup

  @DMGooffline
  Scenario: Go offline scenario
    Given User should be in Order entry page
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode
    And Then User selects Go offline option in Disconnected mode popup
    Then User should get Customer account# popup
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized
    Then User must be on Order Entry Page in disconnected mode

  @DMParOrder
  Scenario:Creating order using par order
    Given User should be in Order entry page
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode
    And Then User selects Go offline option in Disconnected mode popup
    Then User should get Customer account# popup
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized
    Then User must be on Order Entry Page in disconnected mode
    Then User clicks on drop down next to Start order button
    And Select Par Order from drop down options
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    And Enter Qty for the products in Product grid
      |1|1|
      |2|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

    @DMOrderOG
  Scenario: For creating order using OG
    Given User should be in Order entry page
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode
    And Then User selects Go offline option in Disconnected mode popup
    Then User should get Customer account# popup
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized
    Then User must be on Order Entry Page in disconnected mode
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select OrderGuide option
      |SampleOG|
    And Enter Qty for the products in Product grid
      |1|1|
      |2|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @DMSearchBarOrder
  Scenario: Creating Order in disconnected mode using product# search box
    Given User should be in Order entry page
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode
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
    Then Check for Catalog popup
    Then Enter the Qty in the Product grid Case and Unit
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @DMOrderComment
  Scenario: For adding comment to order
    Given User should be in Order entry page
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode
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
      |1|1|
    Then User should click on Comment icon in Order entry card
    And User should enter comment in comment popup
      |Comment at Order level|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @DMOrderCatalog
  Scenario: For creating order using catalog
    Given User should be in Order entry page
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode
    And Then User selects Go offline option in Disconnected mode popup
    Then User should get Customer account# popup
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized
    Then User must be on Order Entry Page in disconnected mode
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select catalog option
    And User should select Product from catalog and Enter Qty for the products in disconnected mode
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @DMQuickProduct
  Scenario: To create Order in disconnected mode using Quick product
    Given User should be in Order entry page
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode
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
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @DMDeleteProductFromCart
  Scenario: Test scenario for navigating to catalog tab, and delete product from cart
    Given User should be in Order entry page
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode
    And Then User selects Go offline option in Disconnected mode popup
    Then User should get Customer account# popup
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized
    Then User must be on Order Entry Page in disconnected mode
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# in Search bar and enters Qty
      |1|1|
      |2|1|
      |2|2|
    Then User click on cart in catalog and click on Gotocart, before that Delete Product from popup
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button
    Then User should be navigated to Order Entry page

