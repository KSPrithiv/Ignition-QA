Feature: CatalogDSD

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Catalog
    When User is on Home Page for Catalog
    Then User navigate to Client side for Catalog
    Then User should select Order Entry tab for Catalog
    Then User selects Account# for Catalog

  @ForeignLanguageSearch
  Scenario: Test scenario for searching product, using foreign language
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed
    Then User enters Product# in foreign language, in Search bar

  @TirePricingDialog
  Scenario: Test scenario for verifying tire pricing
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User enters Tire pricing Product# in Search bar and verifying whether tire pricing dialog box appeared or not

  @FrequentlyBoughtTogether
  Scenario: To list all the products which are part of Frequenly bought together
    Given User must be on Order Entry Page to select Catalog
    And User should navigate to Catalog tab
    And User clicks on Resetfilter to list all the products
    Then User clicks on product details to navigate to Description page
    And User lists all the product numbers which comes under Frequently bought together

