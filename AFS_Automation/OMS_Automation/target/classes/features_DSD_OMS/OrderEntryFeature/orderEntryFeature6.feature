Feature: Order Entry6
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @PickupOrder
  Scenario: Test scenario for creating Pickup order
    Given User must be on Order Entry Page
    When User clicks on drop down next to Start order button
    And Select Pickup Order from drop down options and select delivery date
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order for Pickup order
      |PO123|
    And User validates Pickup order check box is selected
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @PickupOrderValidation
  Scenario: Test scenario for Pickup order validation in new OE page, and in Order summary page
    Given User must be on Order Entry Page
    When User clicks on drop down next to Start order button
    And Select Pickup Order from drop down options and select delivery date
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order for Pickup order
      |PO123|
    And User validates Pickup order check box is selected
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button before that validate pickup order
    Then User should be navigated to Order Entry page

  @PickupOrderCheckBox
  Scenario: Test scenario for creating Pickup order by clicking check box in New OE page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order for Pickup order
      |PO123|
    And User navigated to New OE page and clicks on Pickup check box
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button before that validate pickup order
    Then User should be navigated to Order Entry page

  @PickupOrderCancel
  Scenario: Test scenario for canceling pickup order
    Given User must be on Order Entry Page
    When User clicks on drop down next to Start order button
    And Select Pickup Order from drop down options and select delivery date
    Then User should select Note from popup and Order guide from popup
    And User validates Pickup order check box is selected
    Then Click on Cancel button
    And Check for Warning popup
    Then User should be navigated to Order Entry page

  @PickupOrderTodaysDate
  Scenario: Test scenario for verifying Pickup order, Select date popup contains todays date
    Given User must be on Order Entry Page
    When User clicks on drop down next to Start order button
    And Select Pickup Order from drop down options and select delivery date by verifying existence of todays date
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order for Pickup order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @RouteMandatory
  Scenario: Test scenario for verifying Route field is mandatory popup
    Given User must be on Order Entry Page
    And User removes route details from Route field and Route is empty
    Then User clicks on Start button and Route mandatory popup should display
    And User should handle Route mandatory popup

  @PriceOverrideFromPriceInputbox
  Scenario: Test scenario for Entering price in input box and verifying price override icon
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select OrderGuide option
      |SampleOG|
    And Enter Qty for the products in Product grid
      |1|1|
      |1|1|
    Then User should enter price for product in price input box
      |$0.50|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @ContinueWithoutPayment
  Scenario: Test scenari for creating order by choosing continue Without payment option in Payment page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button and select option Continue without payment option
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @ProductWithAvailableInventory
  Scenario Outline: Test scenario for usage of "Show products with available inventory" drop down
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select OrderGuide option
      |SampleOG|
    And Enter Qty for the products in Product grid
      |1|1|
      |1|1|
    And User clicks on filter by Qty drop down and selects "<Qty filter>"
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Examples:
      |Qty filter                                 |
      |Show only products with available inventory|

  @ImportBogoItemOrder
  Scenario: Create an order Open that order and export the order with BOGO item and import that order
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area for BOGO item
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Enter Order# in Search box in Order Entry page
    Then Click on Order number in Order Entry page
    Then navigate to newOE page and Click on Export button
    And User navigate back to order entry page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    And Click on Import button
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
