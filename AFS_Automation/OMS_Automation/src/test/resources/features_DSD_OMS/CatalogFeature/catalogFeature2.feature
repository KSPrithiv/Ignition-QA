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
    Then Click on SubmitOrder button
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
    Then Click on SubmitOrder button
    Then User should be navigated to Order Entry page