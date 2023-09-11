Feature: Order Entry2
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @CancelInOESummary
    Scenario: Cancle the order before submitting but in OE summary page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |50|20|
    Then Click on Next button
    Then Click on Cancel button in OE summary page and handle warning popup
    Then User should be navigated to Order Entry page

  # Admin setting for drag and drop should be enabled
  @OEDragDrop
  Scenario: Test scenario for drag and drop option in New OE page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
     |  80  |  55  |
    And Drag and drop table header
      |Brand|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @OESearchProdDes
  Scenario: Creating New order by entering Product# in Searchbar, New order entry page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User enters ProdDes in Search box
    Then Check for Catalog popup
    Then Enter the Qty in the Product grid Case and Unit
      | 50 | 50 |
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @CompareTotal
  Scenario: Create order and compare Total amount in New Order Entry page and Order summary page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |50|20|
    And Find total amount from New oe page
    Then Click on Next button
    And Get total amount from summary page and Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @CompareTotal1
  Scenario: Create order and compare Total amount in New Order Entry page and Order summary page, total in order details card
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |50|20|
    Then Click on Next button
    And Get total amount from summary card and Order total on SubmitOrder button
    Then User should be navigated to Order Entry page

  @VerifyRoute
  Scenario: Select route in OE page, verify it in NewOE page
    Given User must be on Order Entry Page
    Then User should  click on route index icon and select route
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Compare route selected in OE page with route in NewOE page
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |80|50|
    And Find total amount from New oe page
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @TotalProd
  Scenario: Compare Total number of lines with number of products in summary page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Prod_No in Quick Product Entry area
     |  90  |  40  |
     |  55  |  80  |
     |  45  | 35   |
     |  80  | 75   |
    Then Click on Next button
    Then In Order Summary page compare Total no of line compare it with no of products
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

    #Admin Setting should be enabled for this scenario->"Enable auto load order entry"
  # this script will work, when there are no orders for the changed account for given date
  @ChangeAccount
  Scenario: Change the account# to other account# and check whether it navigates to NewOE page or not
    Given User must be on Order Entry Page
    And change the account_No to someother account#
    And Check whether user navigated to NewOE page
    And  user should change the Account# back to Previous Account#

    #we can cancel only those orders which have not yet reached cutoff time/ delivery dates are in future
    @CancelAndVerifyInOrderGrid
    Scenario: Create new order, and once Order created Cancel that order from Order summary page
      Given User must be on Order Entry Page
      Then User must click Start Order button
      Then User should make selection between Pending order or Start New order
      Then User should select Note from popup and Order guide from popup
      Then Enter PO# for New order
        |PO123|
      Then Enter Pro# in Quick Product Entry area
      And Check for Case and Unit input box enabled or not based on that enter value
        |50|50|
      Then Click on Next button
      And Click on Submit Order button and read Order_no
      Then Enter Order# in Search box in Order Entry page
      Then Click on Order number in Order Entry page
      Then Click on Next button to naviagate to OE summary page to cancle order
      Then Click on Cancel button in OE summary page and handle warning popup
      Then User should be navigated to Order Entry page
      And verify whether Order number is not existing in OG

      @OrderCancelInNewOE
      Scenario: Test scenario for creating order and once order is created cancel it in new order entry page
           Given User must be on Order Entry Page
           Then User must click Start Order button
           Then User should make selection between Pending order or Start New order
           Then User should select Note from popup and Order guide from popup
           Then Enter PO# for New order
             |PO123|
           Then Enter Pro# in Quick Product Entry area
           And Check for Case and Unit input box enabled or not based on that enter value
             |50|50|
           Then Click on Next button
           And Click on Submit Order button and read Order_no
           Then User should be navigated to Order Entry page
           Then Enter Order# in Search box in Order Entry page
           Then Click on Order number in Order Entry page
           Then Click on Cancel button
           And Check for Warning popup
           Then User should be navigated to Order Entry page

#this scenario is only for ERP env
@LowInventroy
Scenario: Products which are low in inventory should not be displayed in Order summary page
  Given User must be on Order Entry Page
  Then User must click Start Order button
  Then User should make selection between Pending order or Start New order
  Then User should select Note from popup and Order guide from popup
  Then Enter PO# for New order
    |PO123|
  Then Enter Prod_No in Quick Product Entry area
   |  40  |  30  |
   |  50  |  80  |
   |  55  |  50  |
   |  80  |  50  |
  #here 0002, 0003 are out of stock products and they should not get displayed in Order summary
  Then Click on Next button
  Then In Order Summary page check whether Low inventory products are removed or not
  And Click on SubmitOrder button
  Then User should be navigated to Order Entry page

  @SortProdInSummary
  Scenario: check for the sorted order of products in Order summary page by clicking Down arrow and up arrow next to unit table header
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Prod_No in Quick Product Entry area
      |  10  |  40  |
      |  50  |  10  |
      |  15  |  50  |
      |  50  |  50  |
  #here 0002, 0003 are out of stock products and they should not get displayed in Order summary
    Then Click on Next button
    Then In Order Summary page click on up arrow for sorting product in descending order of product number
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page



