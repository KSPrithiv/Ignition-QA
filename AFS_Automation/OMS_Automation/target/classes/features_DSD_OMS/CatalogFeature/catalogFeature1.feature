Feature: Catalog1

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Catalog
    When User is on Home Page for Catalog
    Then User navigate to Client side for Catalog
    Then User should select Order Entry tab for Catalog
    Then User selects Account# for Catalog

@SeparatedByComma
Scenario: Search for product separated by comma
Given User must be on Order Entry Page to select Catalog
And User should navigate to Catalog tab
And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
Then User enters Product# in Search bar separated by comma and Read the product# available in catalog

@PlusMinusInCart
Scenario: To test + and - symbol orderation, that appears in my cart page
  Given User must be on Order Entry Page to select Catalog
  And User should navigate to Catalog tab
  And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
  Then User enters Product# in Search bar and enters Qty
    |50|
    |40|
    |40|
    |40|
    |40|
  Then User click on cart in catalog and click on Gotocart, Press Plus and Minus buttons
  And user should be on New Order entry page
  Then Enter PO# for New order
    |PO123|
  Then Click on Next button
  Then Click on SubmitOrder button
  Then User should be navigated to Order Entry page

  @CategoryCatalog
  Scenario: Testing of Category option
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in List view in Catalog page
    Then User should click on Category dropdown and select any of the category
    And User should read all the products available catalog page

  @SubCategoryCatalog
  Scenario: Testing of SubCategory option
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in List view in Catalog page
    Then User should click on SubCategory dropdown and select any of the category
    And User should read all the products available catalog page

  @BrandCatalog
  Scenario: Testing of Brand option
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in List view in Catalog page
    Then User should click on Brand dropdown and select any of the category
    And User should read all the products available catalog page

  @OrderGuideCatalog
  Scenario: Select OG from Dropdown and display products
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in List view in Catalog page
    Then User should click on Order Guide dropdown and select any of the category
    And User should read all the products available catalog page

  @FeaturedProducts
  Scenario: List out all the Featured Products
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    Then User reads all the products listed under featured products

  @RecentSearchProducts
  Scenario: List out all the products which are recently searched
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    Then User reads all the products listed under recent search card

  @ProductYouMayLike
  Scenario: List all the products which contains Product you may like
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User clicks on Resetfilter to list all the products
    Then User reads all the products listed under Products you may like

  @FrequentlyBoughtTogether
  Scenario: To list all the products which are part of Frequenly bought together
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User clicks on Resetfilter to list all the products
    Then User clicks on product details to navigate to Description page
    And User lists all the product numbers which comes under Frequently bought together
