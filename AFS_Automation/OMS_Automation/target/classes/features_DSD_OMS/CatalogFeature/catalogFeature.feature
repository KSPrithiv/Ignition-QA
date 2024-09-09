Feature: Catalog
  All the scenarios that performs adding product to cart in card view, list view
  Increase, decrease product Qty, remove product from cart and create order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Catalog
    When User is on Home Page for Catalog
    Then User navigate to Client side for Catalog
    Then User should select Order Entry tab for Catalog
    Then User selects Account# for Catalog

  @SearchBarSearch
  Scenario: For verifying functionality of Search bar
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed
    Then User enters Product# in Search bar

  @SearchBarSearchAndClearSearch
  Scenario: For verifying functionality of Search bar and clear search
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
#    And User should click on Reset filter button and all the products should displayed
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# in Search bar and clear search

  @SearchByDescription
  Scenario: Search for product using Description
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed
    Then User enters Product description in Search bar

  @SortByBestMatch
  Scenario: Sorting of Products based on unit price ascending order
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in List view in Catalog page
    Then Click on sort by best match and select ascending order and verify the same from Catalog page
      |Sort by price (ascending)|

  @CardViewOrder
  Scenario: creation of order using card view from catalog page and create new order
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
    Then Click on Next button
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page after creating order from catalog

  @DeleteCardView
  Scenario: Delete the product after adding it to cart,card view delete product
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# in Search bar and enter Qty and click on Delete button
      |1|
      |2|
      |1|
    Then User click on cart in catalog and click on Gotocart
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page after creating order from catalog

  @DeleteFromShoppingCartDropdown
  Scenario: Deleting the product from the cart
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# in Search bar and enters Qty
      |1|
      |2|
      |1|
    Then User click on cart in catalog and click on Gotocart, before that Delete Product from popup
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page after creating order from catalog

  @DeleteFromMyCart
  Scenario: Adding product to cart using catalog tab and Deleting product from cart, in My cart page
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# in Search bar and enters Qty
      |1|
      |2|
      |1|
    Then User click on cart in catalog and click on Gotocart, Delete product from Mycart page
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page after creating order from catalog

    # Admin setting need to be enabled for popup to get displayed for new order or existing order
  @AddingProdToOrder
  Scenario: Search for the product and adding to cart, while navigating to NewOE page select existing order# from popup
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# in Search bar and enters Qty for single Product
      |1|
    Then User click on cart in catalog and click on Gotocart and select existing order
    #Then Click on Back button in Checkout Card page
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page after creating order from catalog

  @OrderUsingDescriptionPage
  Scenario: Searching of product and adding product to order using Product description page
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Product# in Search bar
    And User clicks on product image and enters Qty in Description page
      |1|
    Then User click on cart in catalog and click on Gotocart and select existing order
    #Then Click on Back button in Checkout Card page
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page after creating order from catalog

  @MultipleProductFromDescriptionPage
  Scenario: Searching of multiple products and adding product to order using Product description page
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters different Product# in Search bar and enter Qty by clicking image
      |1|
      |2|
      |1|
    Then User click on cart in catalog and click on Gotocart and select existing order
    #Then Click on Back button in Checkout Card page
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page after creating order from catalog

  @ProductDescriptionDelete
  Scenario: Search for multiple products, add products to cart from discription page, Delete product from Discription page
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters different Product# in Search bar and enter Qty by clicking image and click Delete product
      |1|
      |2|
      |1|
    Then User click on cart in catalog and click on Gotocart and select existing order
    #Then Click on Back button in Checkout Card page
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button for creating order from Catalog
    Then User should be navigated to Order Entry page after creating order from catalog







