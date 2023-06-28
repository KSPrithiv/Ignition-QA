Feature: All orders
 Test scenarios to create all orders, edit,delete etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for All order
    When User is on Home Page for All order
    Then User navigate to Client side for All order
    Then User should select Order Entry tab for All order

  @AllOrderCheckBox @sanity
    Scenario: Test scenario to display all the orders
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    And User goes through all the order in Open order grid

  @ShowOrderQuotes
  Scenario: Test scenario for displaying all order with quotes
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all Quotes check box
    And User goes through all the order in Open order grid

  @OpenOrderFilter
  Scenario: For loading order details in All Order
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    And User Clicks on Add filter button and enter values for search options

  @AllSubmittedOrders
   Scenario: Test scenario for displaying all orders which are submitted using submitted status drop down
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    And User clicks on Submitted status and select Submitted option from drop down
    And User clicks on search button
    And User goes through all the order in Open order grid

  @AllOpenOrderAllOrders
    Scenario: Test scenario for displaying all Open order in all orders
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    And User clicks on Order status and select Open order option from drop down
    And User clicks on search button
    And User goes through all the order in Open order grid

  @CreateOpenOrder
  Scenario: Test scenario for creating All Order
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Start order button and selects Add from drop down
    Then User selects customer account# and delivery date from popup
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and select any OG from popup
    |SampleOG|
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |60|20|
    Then Click on Next button
    And Click on Submit Order button and read Order_no created for All order
    Then User should be navigated back to All order page
    And User clicks on Show all orders check box
    And User Clicks on Add filter button and Search for OrderNo

  @DisplayOrderWithProduct
  Scenario: Test scenario for displaying only those orders having particular product
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    And User enters product# in input box
    And User clicks on search button
    And User goes through all the order in Open order grid
    #Then User clicks on any of the order and verifies products

  @VerifyCommentIcon
  Scenario: Test scenario for verifying Comment Icon
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Start order button and selects Add from drop down
    Then User selects customer account# and delivery date from popup
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |60|80|
    Then User should click on Comment icon in Order entry card
    And User should enter comment in comment popup
      |Comment for All order|Order notes|
    Then Click on Next button
    And Click on Submit Order button and read Order_no created for All order
    Then User should be navigated back to All order page
    And User clicks on Show all orders check box
    And User Clicks on Add filter button and Search for OrderNo
    Then USer clicks on Comment icon and comments popup gets displayed

  @EditOpenOrder
  Scenario: Test scenario for editing open order
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Start order button and selects Add from drop down
    Then User selects customer account# and delivery date from popup to edit all order
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |50|60|
    Then Click on Next button
    And Click on Submit Order button and read Order_no created for All order
    Then User should be navigated back to All order page
    And User clicks on Show all orders check box
    And User Clicks on Add filter button and Search for OrderNo
    Then User Clicks on the order# in All order grid
    Then Navigate to Summary order entry page and user clicks on Edit button
    And If user navigates to payment and address page click on Back button or else add product# in Quick product entry for editng all order
      |50|50|
    Then Click on Next button
    And Click on Submit Order button and read Order_no created for All order
    Then User should be navigated back to All order page
    And User clicks on Show all orders check box
    And User Clicks on Add filter button and Search for OrderNo

  @GroupingNumberOfItem
  Scenario Outline: Test scenario for grouping or drag and drop
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    And User should drag and drop "<Drag and Drop>" then verify grouping with number of elements in each group
    Examples:
      | Drag and Drop |
      | Day of week   |

  @CreatePickupOrder
  Scenario: Test scenario for creating Pickup order
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Start order button and selects Pick up order from drop down
    Then User selects customer account# and delivery date for pickup order
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    And User validates Pickup order check box is selected
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |100|100|
    Then Click on Next button
    And Click on Submit Order button and read Order_no created for All order
    Then User should be navigated back to All order page
    And User clicks on Show all orders check box
    And User Clicks on Add filter button and Search for OrderNo

  @CopyAllOrder
  Scenario: Test scenario to create copy of Open order/All order
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    And User clicks on Order status and select Active order option from drop down
    And User clicks on search button
    And User Clicks on Add filter button and enter values for search options
    Then User select the order and click on copy button and select delivery date
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no created for All order
    Then User should be navigated back to All order page
    And User clicks on Show all orders check box
    And User Clicks on Add filter button and Search for OrderNo

  @AllOrderToOrderEntry
  Scenario: Test scenario for navigating from All order to OE
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    And User clicks on Order status and select Active order option from drop down
    And User clicks on search button
    And User Clicks on Add filter button and enter values for search options
    Then User clicks on OrderNo in All Order grid and User should be navigated Ordersummary page
    Then User clicks on Back to Order list button and should be navigated to OE page
    And User enters orderNo That he has selected from order grid and validates it exists in order also

  @PrintAllOrder
  Scenario: Test scenario for testing print button functionality
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    And User clicks on Order status and select Active order option from drop down
    And User clicks on search button
    And User Clicks on Add filter button and enter values for search options
    Then User select the order and click on Print button


