Feature: external catalog

  Background: For login to application
    Given User enters URL and is on login page

  @ProductsSeparatedByComma
  Scenario: Search for multiple products separated by comma, in external catalog
    Given User on login page for external catalog
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters multiple Product# in Search bar separated by comma and Read the product# available in catalog

  @ResetFilter
  Scenario: Testing of Reset Filter button functionality
    Given User on login page for external catalog
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User Clicks on Category drop down and selects the 1st category
      |Juices/Juice Drinks/Water|
    And user Should click on Reset Filer button and verifies that Category is set back to All category

   #Based on admin setting
  @ProductsCatalogCardView
  Scenario: Selecting Products to be ordered in login page, before loging in to application.Using Card view.
    Given User on login page for external catalog
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters Product# in Search bar in Catalog popup and enter Qty card view
      |10|
      |1|
      |2|
    Then User click on cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page

  @ProductsCatalogListView
  Scenario: Adding product to cart, using list view
    Given User on login page for external catalog
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in List view
    Then User enters Product# in Search bar in Catalog popup and enter Qty List view
      |1|
      |2|
      |1|
    Then User click on cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page

  @DeleteProductsAddByDeleteIcon
  Scenario: Add products to cart from external catalog, Delete added product using Delete Icon. Here Card view is used
    Given User on login page for external catalog
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters Product# in Search bar in Catalog popup and enter Qty and delete the first product added
      |1|
      |1|
      |2|
    Then User click on cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page

  @SortByBestMatch
  Scenario: Sorting of items in ascending order
    Given User on login page for external catalog
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in List view
    Then Click on sort by best match and select ascending order and verify the same
      |Sort by price (ascending)|

  @DeleteItemsInCart
  Scenario: Add product to cart from external catalog and delete one of the product from Items in Cart page
    Given User on login page for external catalog
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters Product# in Search bar in Catalog popup and enter Qty card view
      |1|
      |2|
      |1|
    Then User click on cart, Delete one product from cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page

  @DeleteFromMyCart
  Scenario: Add product to cart from external catalog and delete one of the product from My cart page
    Given User on login page for external catalog
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters Product# in Search bar in Catalog popup and enter Qty card view
      |1|
      |1|
      |1|
    Then User click on cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart, Delete one product and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page
