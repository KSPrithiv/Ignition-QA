Feature: All orders
  Test scenarios to create all orders, edit,delete etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for All order
    When User is on Home Page for All order
    Then User navigate to Client side for All order
    Then User should select Order Entry tab for All order

  @ShowOrderQuotes
  Scenario: Test scenario for displaying all order with quotes
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all Quotes check box
    And User goes through all the order in Open order grid

  @DisplayOrderWithProduct
  Scenario: Test scenario for displaying only those orders having particular product
     Given User must be on Order Entry Page to select All Orders
     And User should navigate to All Orders
     Then User clicks on Show all orders check box after Clicking All orders tab
     And User enters product# in input box
     And User clicks on search button
     And User goes through all the order in Open order grid
     #Then User clicks on any of the order and verifies products