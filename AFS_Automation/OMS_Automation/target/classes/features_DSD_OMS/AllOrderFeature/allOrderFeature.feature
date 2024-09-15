Feature: All orders
  Test scenarios to create all orders, edit,delete etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for All order
    When User is on Home Page for All order
    Then User navigate to Client side for All order
    Then User should select Order Entry tab for All order

  @AllOrderCheckBox
  Scenario: Test scenario to display all the orders
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
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
    Then User clicks on Show all orders check box after Clicking All orders tab
    And User clicks on Order status and select Open order option from drop down
    And User clicks on search button
    And User goes through all the order in Open order grid

  @GroupingNumberOfItem
  Scenario Outline: Test scenario for grouping or drag and drop
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    And User should drag and drop "<Drag and Drop>" then verify grouping with number of elements in each group
    Examples:
      | Drag and Drop |
      | Order Type    |

  @AllOrderToOrderEntry
  Scenario: Test scenario for navigating from All order to OE
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    And User clicks on Order status and select Open order option from drop down
    And User Clicks on Add filter button and enter values for search options for searching in OE
    Then User clicks on OrderNo in All Order grid and User should be navigated Ordersummary page click on Back to order list
    And User enters orderNo That he has selected from order grid and validates it exists in order also

  @CreateOpenOrder
  Scenario: Test scenario for creating All Order
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Start order button and selects Add from drop down
    Then User selects customer account# and delivery date from popup
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order for All orders
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button for All order
    And Click on Submit Order button and read Order_no created for All order
    Then User should be navigated back to All order page
    And User clicks on Show all orders check box after navigating back
    And User Clicks on Add filter button and Search for OrderNo

  @CreateOpenOrderWithComment
  Scenario: Test scenario to create open order with comment
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Start order button and selects Add from drop down
    Then User selects customer account# and delivery date from popup
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order for All orders
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then User should click on Comment icon in Order entry card
    And User should enter comment in comment popup
      |Comment for All order|Order notes|
    Then Click on Next button for All order
    And Click on Submit Order button and read Order_no created for All order
    Then User should be navigated back to All order page
    And User clicks on Show all orders check box after navigating back
    And User Clicks on Add filter button and Search for OrderNo

  @PrintAllOrder
  Scenario: Test scenario for testing print button functionality
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    And User selects open order from the order status filter
    And User Clicks on Add filter button and enter values for search options
    Then User select the order and click on Print button

  @FilterAtProductLine
  Scenario: Test scenario for filtering created by and order type
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    And User goes through all the order in Open order grid
    Then User should search in grid filter for created by and order type

  @DragAndDropInAllOrder
  Scenario Outline: Test scenario for drag and drop of header
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    And User drag and drops "<Drag and Drop>" header
    Examples:
      | Drag and Drop |
      | Order Type    |

  @GroupLevelCalculation
  Scenario Outline: Test scenario for finding sum of the column for Qty and total
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    Then User clicks on dropdown in All order for group level calculation for Qty,Total and select "<Options>"
    And User validates the Sum amount in Qty and Total
    Examples:
      | Options |
      | Sum     |

  @EditOpenOrder
  Scenario: Test scenario for editing open order
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Start order button and selects Add from drop down
    Then User selects customer account# and delivery date from popup to edit all order
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order for All orders
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button for All order
    And Click on Submit Order button and read Order_no created for All order
    Then User should be navigated back to All order page
    And User clicks on Show all orders check box after navigating back
    And User Clicks on Add filter button and Search for OrderNo
    Then User Clicks on the order# in All order grid
    Then Navigate to Summary order entry page and user clicks on Edit button
    And If user navigates to payment and address page click on Back button or else add product# in Quick product entry for editng all order
      |1|1|
    Then Click on Next button after editing all order, order
    And Click on Submit Order button and read Order_no created for All order
    Then User should be navigated back to All order page
    And User clicks on Show all orders check box after navigating back
    And User Clicks on Add filter button and Search for OrderNo









