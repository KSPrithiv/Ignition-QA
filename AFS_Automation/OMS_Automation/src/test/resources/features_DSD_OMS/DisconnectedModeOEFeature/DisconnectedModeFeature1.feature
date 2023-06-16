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
      |40|
      |30|
      |30|
      |50|
    Then User click on cart in catalog and click on Gotocart and select existing order
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button
    Then User should be navigated to Order Entry page