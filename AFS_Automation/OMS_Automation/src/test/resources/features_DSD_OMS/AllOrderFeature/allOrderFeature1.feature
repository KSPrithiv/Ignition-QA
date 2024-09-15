Feature: All orders
  Test scenarios to create all orders, edit,delete etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for All order
    When User is on Home Page for All order
    Then User navigate to Client side for All order
    Then User should select Order Entry tab for All order

  @CreatePickupOrder
  Scenario: Test scenario for creating Pickup order
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Start order button and selects Pick up order from drop down
    Then User selects customer account# and delivery date for pickup order
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    And User validates Pickup order check box is selected
    Then Enter PO# for New order for All orders
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button for All order
    And Click on Submit Order button and read Order_no created for All order
    Then User should be navigated back to All order page
    And User clicks on Show all orders check box
    And User Clicks on Add filter button and Search for OrderNo

  @GroupLevelAvgCalculation
    Scenario Outline: Test scenario for finding Avg of the column for Qty and total
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    Then User clicks on dropdown in All order for group level calculation for Qty,Total and select "<Options>"
    And User validates the Avg amount in Qty and Total
    Examples:
      | Options |
      | Avg     |

  @VerifyCommentIcon
  Scenario: Test scenario for verifying Comment Icon
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
    Then USer clicks on Comment icon and comments popup gets displayed

  @DragAndDropAndSum
  Scenario Outline: Test scenario for drag and drop, and find sum of total and Qty columns
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    Then User clicks on dropdown in All order for group level calculation for Qty,Total and select "<Options>"
    And User validates the Sum amount in Qty and Total
    And User drag and drops "<Drag and Drop>" header
    Examples:
      | Drag and Drop | Options |
      | Order Type   |  Sum    |

  @CopyOfOpenOrder
  Scenario: Test scenario for copying Open order in all orders
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    And User selects open order from the order status filter
    Then User selects first order in the grid and clicks on copy button
    And User selects Delivery date from delivery date popup and new order from Select order popup
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    And User Clicks on Add products button and user should make sure Catalog dialog box appears
    Then User should select product and enter Qty for the products
      |1|2|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page



