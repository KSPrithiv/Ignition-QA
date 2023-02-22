Feature: Admin setting
  Verifying Admin setting features for Featured Products

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Admin setting
    When User is on Home Page for Admin setting
    Then User Clicks on Permissions by drop down to select Customer Account#

  @SheildIcon
  Scenario: Test scenario to check Max Featured Products Sheild Icon
    Given User is on Home Page for Admin setting to select Admin option
    And User should enter menu "<Option>" in search bar to navigate to Featured Products
    Then User should Check whether Max products to show in featured products Sheild is selected or not

  @CheckFeaturedProducts
  Scenario Outline: Test scenario to check Featured products list
    Given User is on Home Page for Admin setting to select Admin option
    And User should enter menu "<Option>" in search bar to navigate to Featured Products
    Then User should check max number of Featured products set
    Then User should select "<MenuOption2>" from horizantal menu to select Featured products list
    And User should be on Featured products list
    Then User should list all the products in Product grid of Featured products
    Examples:
      |Option             | MenuOption1 | MenuOption2      |
      |Featured Products  |  Settings   | Featured products|

  @AddFeaturedProducts
  Scenario Outline: Test scenario to add new product to Featured products list
    Given User is on Home Page for Admin setting to select Admin option
    And User should enter menu "<Option>" in search bar to navigate to Featured Products
    Then User should navigate to "<MenuOption1>" from horizantal menu to select Featured products list
    Then User should increase max number of Featured products set
    Then User should select "<MenuOption2>" from horizantal menu to select Featured products list
    And User should be on Featured products list then User should click on Add Products button and add products to list
    Then User should list all the products in Product grid of Featured products
    Examples:
      |Option             | MenuOption1 | MenuOption2      |
      |Featured Products  |  Settings   | Featured products|

  @DeleteFeaturedProducts
  Scenario Outline: Test scenario to Delete product from Featured products list
    Given User is on Home Page for Admin setting to select Admin option
    And User should enter menu "<Option>" in search bar to navigate to Featured Products
    Then User should navigate to "<MenuOption1>" from horizantal menu to select Featured products list
    Then User should decrease max number of Featured products set
    Then User should select "<MenuOption2>" from horizantal menu to select Featured products list
    And User should be on Featured products list then User should select product from grid and click on Delete button
    Then User should list all the products in Product grid of Featured products
    Examples:
      |Option             | MenuOption1 | MenuOption2      |
      |Featured Products  |  Settings   | Featured products|

  @CatalogFilters
  Scenario Outline: Test scenario to use filter in catalog popup
    Given User is on Home Page for Admin setting to select Admin option
    And User should enter menu "<Option>" in search bar to navigate to Featured Products
    Then User should navigate to "<MenuOption1>" from horizantal menu to select Featured products list
    Then User should select "<MenuOption2>" from horizantal menu to select Featured products list
    And User should be on Featured products list then User should click on Add Products button and filter product
    Examples:
      |Option             | MenuOption1 | MenuOption2      |
      |Featured Products  |  Settings   | Featured products|