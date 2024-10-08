Feature: Order Entry
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @OESearchBar
  Scenario: Creating New order by entering Product# in Searchbar, New order entry page, using search index icon
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User enters Product# in Search box
    Then Check for Catalog popup
    Then Enter the Qty in the Product grid Case and Unit
      | 1| 1 |
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @OESearchBarAutoSearch
  Scenario: Creating New order by entering Product# in Searchbar, New order entry page, using auto search drop down
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User enters Product# in Search box and select product from auto search dropdown
#    Then Check for Catalog popup
#    Then Enter the Qty in the Product grid Case and Unit
#      | 1| 1 |
    And Enter Qty for the products in Product grid
      |1|2|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @OESearchBarDescription
  Scenario: Creating New order by entering Product description in Searchbar, New order entry page, using search index icon
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User enters Product description in Search bar
    Then Check for Catalog popup
    Then Enter the Qty in the Product grid, compare product description, enter Case and Unit
      | 1| 1 |
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @OECancle1
  Scenario: Canceling of Order using Cancel button in New OE page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|2|
    Then Click on Cancel button
    And Check for Warning popup
    Then User should be navigated to Order Entry page

  @OEQuickProductEntry
  Scenario: Creating New order by entering Product# in Quick order entry, New order entry page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |2|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @PendingOrder
  Scenario: Creating Pending order
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |2|1|
    Then Click on Back button to handle Pending order Popup
    And Popup message for Pending order should be displayed
    Then User should be navigated to Order Entry page

  @PendingToOrder
  Scenario: Creating new order using pending order
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order by selecting Pending Order option
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |2|1|
    Then Click on Back button
    And Popup message for Pending order should be displayed
    Then User should be navigated to Order Entry page
    Then User must again click Start Order button
    Then User Should handle Pending order popup, and select continue with pending order button
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @DiscardPendingOrder
  Scenario: Creating Discard all pending order
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |2|1|
    Then Click on Back button
    And Discard all Pending order should be displayed
    Then User should be navigated to Order Entry page

  @OrderCopyHistory
  Scenario: Create order using History button in OE page
    Given User must be on Order Entry Page
    Then Click on History button
    Then User verifies Order history page and add history Order to order
    And Click on Copy button
    Then User should Select delivery date from popup
    And Select New order option from popup
    And User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User should enter Units and Cases in product grid
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @EditOrder1
  Scenario: Editing the Order from New OE page,without using edit button in Summary page, for editing order date should not cross cutoff date
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |2|2|
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Enter Order# in Search box in Order Entry page
    Then Click on Order number in Order Entry page and check for New OE page for editing Order
#    Then Navigate to Summary order entry page
    Then Enter new product# in the quick product entry with qty
      |4|4|
    Then Click on Next button after editing order
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @ParOrder
  Scenario: Creating Par Order in Order entry page
    Given User must be on Order Entry Page
    When User clicks on drop down next to Start order button
    And Select Par Order from drop down options
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    And Enter Qty for the products in Product grid
      |1|2|
#      |2|1|
#    Then Enter Pro# in Quick Product Entry area
#    And Check for Case and Unit input box enabled or not based on that enter value
#      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @EditOrder2
  Scenario: Editing the Order before submitting the order
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on Edit button
    And Click on Back button in Checkout Card page
    Then Enter new product# in the quick product entry with qty
      |1|1|
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page

