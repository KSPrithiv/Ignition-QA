Feature: Catalog3

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Catalog
    When User is on Home Page for Catalog
    Then User navigate to Client side for Catalog
    Then User should select Order Entry tab for Catalog
    Then User selects Account# for Catalog
    
  @PendingOrderAndCatalogProd
  Scenario: Test scenario for creating pending order and then add products from catalog
    Given User must be on Order Entry Page
    And User should navigate to Order Entry page from Catalog tab
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|2|
    Then Click on Back button to handle Pending order Popup
    And Popup message for Pending order should be displayed
    Then User should be navigated to Order Entry page
    And Now User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User adds product to cart
      |1|
    Then User click on cart in catalog and click on Gotocart and select pending order
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page


  @PendingOrderCart
  Scenario: Test case for creating pending order by adding product to cart
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# in Search bar and enters Qty
      |1|
      |2|
      |1|
    Then User click on cart in catalog and click on Gotocart
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    And User goes through products added to order via catalog
    Then Click on Back button to handle Pending order Popup
    And Popup message for Pending order should be displayed
    Then User should be navigated to Order Entry page
