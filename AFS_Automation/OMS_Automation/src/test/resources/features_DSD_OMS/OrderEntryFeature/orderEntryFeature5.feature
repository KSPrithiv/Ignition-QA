Feature: Order Entry5
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @PrintOE
  Scenario: Test scenario for Printing order summary
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |45|80|
    Then Click on Next button
    Then User should be on Order Summary page  and click on Print button
    And Click on Submit Order button and read Order_no

  @PrintNewOE
  Scenario: The test scenario for printing OE in NewOE page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |55|80|
    Then User should be in NewOE page and click on Print button
    Then Click on Next button
    And Click on Submit Order button and read Order_no

  @ExportOrder
  Scenario: Create an order Open that order and export the order
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |20|20|
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Enter Order# in Search box in Order Entry page
    Then Click on Order number in Order Entry page
    Then navigate to newOE page and Click on Export button

  @ImportOrder
  Scenario: Create an order by importing .csv files
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    And Click on Import button
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page

  @CommentHistory
  Scenario: Test scenario to verify whether order in order history is having comment or not
    Given User must be on Order Entry Page
    Then Click on History button
    Then User verifies Order history page
    And User should select the First order comment icon in the order history grid to verify whether comment is added or not
    Then User should click on Order button in Order histroy page to navigate back to OE page

  @UOMDisplay
  Scenario: Test scenario for verifying UOM value displayed
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And User should verify UOM value for Quick unit and Quick Case value to be entered
    And Check for Case and Unit input box enabled or not based on that enter value
      |80|70|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @PendingOrderDateChange
  Scenario: Test scenario for creating pending order by changing deleivery date
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |50|80|
    Then Click on Back button
    And Popup message for Pending order should be displayed
    Then User should be navigated to Order Entry page
    Then User must again click Start Order button
    Then User Should handle Pending order popup, and select continue with pending order button
    Then User should select Note from popup and Order guide from popup
    And User should click on delivery date and select delivery date by increasing one day then user should handle the popup also
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |20|20|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @POMandatoryField
  Scenario: Test scenario to verify if PO# is mandatory disable all other WebElements
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    And User should verify all other WebElements are disabled, and no Products in Product grid
  #  Then Enter PO# for New order
  #    |PO123|
  #  Then Enter Pro# in Quick Product Entry area
  #  And Check for Case and Unit input box enabled or not based on that enter value
  #    |50|80|
  #  Then Click on Next button
  #  And Click on Submit Order button and read Order_no
  #  Then User should be navigated to Order Entry page

 # @ForeignLanguageSearch
 # Scenario: Test scenario for searching foreign language product
 #   Given User must be on Order Entry Page
 #   Then User must click Start Order button
 #   Then User should make selection between Pending order or Start New order
 #   Then User should select Note from popup and Order guide from popup
 #   Then Enter PO# for New order
 #     |PO123|
 #   Then User enters foregin language discription of Product in Search box
 #   Then Check for Catalog popup
 #   Then Enter the Qty in the Product grid Case and Unit
 #     | 70| 80 |
 #   Then Click on Next button
 #   And Click on SubmitOrder button
 #   Then User should be navigated to Order Entry page

