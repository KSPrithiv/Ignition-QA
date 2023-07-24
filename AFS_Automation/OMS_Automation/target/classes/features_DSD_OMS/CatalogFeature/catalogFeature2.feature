Feature: Catalog2

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Catalog
    When User is on Home Page for Catalog
    Then User navigate to Client side for Catalog
    Then User should select Order Entry tab for Catalog
    Then User selects Account# for Catalog

  @CreateOrderWithSingleProduct
  Scenario: Test scenario for creating order using single product
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# in Search bar and enters Qty for single Product
      |50|
    Then User click on cart in catalog and click on Gotocart
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page

  @CreateOrderUsingListView
  Scenario: Test scenario for creating order using List view
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in List view in Catalog page
    Then User enters Product# in Search bar and enters Qty for single Product in list view
         |50|
    Then User click on cart in catalog and click on Gotocart
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page

  @TirePricing
  Scenario: Test scenario for testing tire pricing
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# with tire pricing in Search bar
    And User checks for the condition applied for tire pricing

  @TirePricingCart
  Scenario: Test scenario for testing tire pricing
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# with tire pricing in Search bar and enter some Qty
    |100|
    Then User click on cart in catalog and Clicks on tirepricing label

  @ForeignLanguageSearch
  Scenario: Test scenario for searching product, using foreign language
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed
    Then User enters Product# in foreign language, in Search bar

  @PaginationInCatalog
  Scenario: Test scenario for checking the products in last page of the catalog, after sorting products
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in List view in Catalog page
    Then Click on sort by best match and select ascending order and verify the same from Catalog pagination
      |Sort by price (ascending)|

  @TirePricingNegativePrice
  Scenario: Test scenario for finding the price displaed for tire priceing product, it should not contains negative price
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed
    Then User enters Product# with tire pricing in Search bar
    And User should read Tire pricing product price

  @PendingOrderCatalog
  Scenario: Test scenario for creating pending order and create order in catalog
    Given User must be on Order Entry Page to create pending order
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |70|50|
    Then Click on Back button to handle Pending order Popup
    And Popup message for Pending order should be displayed
    Then User should be navigated to Order Entry page
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# in Search bar and enters Qty for single Product
      |50|
    Then User click on cart in catalog and click on Gotocart and select Pending order
    Then Click on Next button in Payment page
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page

  @NavigateToDescriptionAndBack
  Scenario: Test scenario for navigating to Product description page by clicking on description and navigate back via back to catalog
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# in Search bar
    And User clicks on product description link, verify the product
    Then User clicks on Back to catalog button and navigates back to catalog page
    And User verifies that searched product details are still displayed and click on reset filter

  @SearchForInvalidProduct
  Scenario Outline: Test scenario for searching of invalid product in catalog
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters invalid "<ProdNumber>" in Search bar
    Examples:
      | ProdNumber |
      | 123456     |
