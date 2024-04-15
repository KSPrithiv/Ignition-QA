Feature: scenarios for admin credentials and client credentials, for Order Factor related test scenarios

  Background: For login to application to verify admin settings in client side, For Order entry test scenario

  @AddOrderFactorCustomer
  Scenario Outline: Test scenario for adding product to order factor
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to order entry search
    Then User should navigate to "<MenuOption>" from horizontal menu to select Order factor, select order factor level "<Order factor level>"
    And User should add product to order factor list and add "<Qty>"
    And User should save all the details
    And User logs out from Admin site
    Examples:
      |Option             | MenuOption                   |Order factor level                     |   Qty|
      |Order Entry        | Order factor/Order increments|Order factor by customer and product   |    5 |

  @OrderFactorCustomer
  Scenario: Test scenario for verifying order factor at product master level
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Inventory for admin setting
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area for Order factor
    And Check for Case and Unit input box enabled or not based on that enter value for qty to verify order factor
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |4|4|
    Then Click on Next button and validate order factor dialog box
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @DeleteOrderFactorCustomer
  Scenario Outline: Test scenario for adding product to order factor
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to order entry search
    Then User should navigate to "<MenuOption>" from horizontal menu to select Order factor, select order factor level "<Order factor level>"
    And User should delete product from order factor list
    And User should save all the details
    And User logs out from Admin site
    Examples:
      |Option             | MenuOption                      | Order factor level                  |
      |Order Entry        | Order factor/Order increments   | Order factor by customer and product|

  @AddOrderFactorProductMaster
  Scenario Outline: Test scenario for adding product to order factor
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to order entry search
    Then User should navigate to "<MenuOption>" from horizontal menu to select Order factor, select order factor level "<Order factor level>"
    And User should add product to order factor list and add "<Qty>"
    And User should save all the details
    And User logs out from Admin site
    Examples:
      |Option             | MenuOption                   |Order factor level                     |   Qty|
      |Order Entry        | Order factor/Order increments|Order factor at product master level   |    5 |

  @OrderFactorProductMasterLevel
  Scenario Outline: Test scenario for verifying order factor at product master level
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to catalog search
    Then User should navigate to "<MenuOption>" from horizontal menu to select Order factor, select order factor level "<Order factor level>" and get product#
    And User should save all the details
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Inventory for admin setting
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area for Order factor
    And Check for Case and Unit input box enabled or not based on that enter value for qty to verify order factor
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |4|4|
    Then Click on Next button and validate order factor dialog box
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Examples:
      |Option             | MenuOption                      |  Order factor level                |
      |Order Entry        | Order factor/Order increments   |Order factor at product master level|


  @DeleteOrderFactorProductMaster
  Scenario Outline: Test scenario for adding product to order factor
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to order entry search
    Then User should navigate to "<MenuOption>" from horizontal menu to select Order factor, select order factor level "<Order factor level>"
    And User should delete product from order factor list
    And User should save all the details
    And User logs out from Admin site
    Examples:
      |Option             | MenuOption                      | Order factor level                  |
      |Order Entry        | Order factor/Order increments   | Order factor at product master level|